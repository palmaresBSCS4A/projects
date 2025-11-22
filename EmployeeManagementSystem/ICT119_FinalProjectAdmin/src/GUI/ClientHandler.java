/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.io.*;
import java.math.BigDecimal;
import java.net.Socket;
import java.sql.*;
import java.time.*;
/**
 *
 * @author MARY ANGEL
 */
public class ClientHandler implements Runnable {
    private final Socket socket;
    private final BufferedReader in;
    private final PrintWriter out;
    private final String clientAddress;
    private String currentEmployeeId = null;

    public ClientHandler(Socket socket) throws IOException {
        this.socket = socket;
        this.clientAddress = socket.getInetAddress().getHostAddress();
        this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.out = new PrintWriter(socket.getOutputStream(), true);
    }

    @Override
    public void run() {
        try {
            out.println("CONNECTED");
            out.flush();

            String loginLine = in.readLine();
            if (loginLine == null) {
                log("Client disconnected unexpectedly from " + clientAddress);
                return;
            }

            if (!loginLine.startsWith("LOGIN|")) {
                out.println("LOGIN_FAILED|Invalid login command");
                log("Invalid login command from " + clientAddress);
                return;
            }

            String[] parts = loginLine.split("\\|");
            if (parts.length != 3) {
                out.println("LOGIN_FAILED|Invalid login format");
                log("Invalid login format from " + clientAddress);
                return;
            }

            currentEmployeeId = parts[1];
            String password = parts[2];

            if (!authenticateUser(currentEmployeeId, password)) {
                out.println("LOGIN_FAILED|Invalid credentials");
                log("Login failed for " + currentEmployeeId + " from " + clientAddress);
                return;
            }

            out.println("LOGIN_SUCCESS");
            log("Login successful for " + currentEmployeeId + " from " + clientAddress);

            String clientMessage;
            while ((clientMessage = in.readLine()) != null) {
                if (clientMessage.equalsIgnoreCase("LOGOUT|" + currentEmployeeId)) {
                    handleLogout();
                    break;
                } else if (clientMessage.startsWith("Dashboard")) {
                    handleGetEmployeeData(clientMessage);
                    log("Executed Dashboard Access for " + currentEmployeeId);
                } else if (clientMessage.startsWith("TIME_IN|")) {
                    handleTimeInCommand(clientMessage);
                } else if (clientMessage.startsWith("TIME_OUT|")) {
                    handleTimeOutCommand(clientMessage);
                } else if (clientMessage.startsWith("GET_LEAVE_REQUESTS|")) {
                    String empId = clientMessage.split("\\|")[1];
                    if (!empId.equals(currentEmployeeId)) {
                        out.println("ERROR|Unauthorized access attempt");
                        log("Unauthorized GET_LEAVE_REQUESTS attempt by " + currentEmployeeId);
                        continue;
                    }
                    handleGetLeaveRequests(empId);
                    log("Executed GET_LEAVE_REQUESTS for " + empId);
                } else if (clientMessage.startsWith("SUBMIT_LEAVE_REQUEST|")) {
                    parts = clientMessage.split("\\|");
                    if (!parts[1].equals(currentEmployeeId)) {
                        out.println("ERROR|Unauthorized leave submission attempt");
                        log("Unauthorized SUBMIT_LEAVE_REQUEST attempt by " + currentEmployeeId);
                        continue;
                    }
                    handleSubmitLeaveRequest(parts);
                    log("Executed SUBMIT_LEAVE_REQUEST for " + parts[1]);
                } else {
                    out.println("ERROR|Unknown command");
                    log("Unknown command from " + currentEmployeeId + ": " + clientMessage);
                }
                out.flush();
            }

        } catch (IOException e) {
            log("Connection error with " + (currentEmployeeId != null ? currentEmployeeId : "unknown") + 
                " from " + clientAddress + ": " + e.getMessage());
        } finally {
            cleanupResources();
            log("Connection terminated for " + (currentEmployeeId != null ? currentEmployeeId : "unknown") + 
                " from " + clientAddress);
        }
    }

    private void handleGetEmployeeData(String command) {
        try {
            String empId = command.split("\\|")[1];
            if (!empId.equals(currentEmployeeId)) {
                out.println("ERROR|Unauthorized data access");
                return;
            }

            try (Connection con = getConnection()) {
                String sql = "SELECT full_name FROM employees WHERE employee_id = ?";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, empId);
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    String fullName = rs.getString("full_name");
                    out.println("Dashboard|" + fullName);
                } else {
                    out.println("ERROR|Employee not found");
                }
            } catch (SQLException e) {
                out.println("ERROR|Database error: " + e.getMessage());
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            out.println("ERROR|Invalid command format");
        }
    }

    private void handleGetLeaveRequests(String empId) {
        try (Connection con = getConnection()) {
            String sql = "SELECT leave_type, start_date, end_date, status, reason FROM leave_requests WHERE employee_id = ?";
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setString(1, empId);
                ResultSet rs = ps.executeQuery();

                boolean hasData = false;
                while (rs.next()) {
                    hasData = true;
                    String leaveType = rs.getString("leave_type");
                    String startDate = rs.getDate("start_date").toString();
                    String endDate = rs.getDate("end_date").toString();
                    String status = rs.getString("status");
                    String reason = rs.getString("reason");

                    out.println("LEAVE_DATA|" + leaveType + "|" + startDate + "|" + endDate + "|" + status + "|" + reason);
                }

                if (!hasData) {
                    out.println("INFO|No leave requests found");
                }

                out.println("END_OF_DATA");
            }
        } catch (SQLException e) {
            out.println("ERROR|Database error: " + e.getMessage());
            log("Error fetching leave requests for " + empId + ": " + e.getMessage());
        }
    }

    private void handleSubmitLeaveRequest(String[] parts) {
        if (parts.length < 6) {
            out.println("ERROR|Invalid leave request format");
            return;
        }

        String empId = parts[1];
        String leaveType = parts[2];
        String startDate = parts[3];
        String endDate = parts[4];
        String reason = parts[5];

        try (Connection con = getConnection()) {
            String sql = "INSERT INTO leave_requests (employee_id, leave_type, start_date, end_date, reason, status, request_date) VALUES (?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setString(1, empId);
                ps.setString(2, leaveType);
                ps.setDate(3, Date.valueOf(startDate));
                ps.setDate(4, Date.valueOf(endDate));
                ps.setString(5, reason);
                ps.setString(6, "Pending");
                ps.setDate(7, new java.sql.Date(System.currentTimeMillis()));

                int rowsAffected = ps.executeUpdate();
                if (rowsAffected > 0) {
                    out.println("SUCCESS|Leave request submitted successfully");
                } else {
                    out.println("ERROR|Failed to submit leave request");
                }
            }
        } catch (SQLException e) {
            out.println("ERROR|Database error: " + e.getMessage());
            log("Error submitting leave request: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            out.println("ERROR|Invalid date format");
        }
    }

    private void handleTimeInCommand(String command) {
        try {
            String empId = command.split("\\|")[1];
            if (!empId.equals(currentEmployeeId)) {
                out.println("ERROR|Unauthorized time-in attempt");
                return;
            }
            String response = handleTimeIn(empId);
            out.println(response);
        } catch (ArrayIndexOutOfBoundsException e) {
            out.println("ERROR|Invalid command format");
        }
    }

    private void handleTimeOutCommand(String command) {
        try {
            String empId = command.split("\\|")[1];
            if (!empId.equals(currentEmployeeId)) {
                out.println("ERROR|Unauthorized time-out attempt");
                return;
            }
            String response = handleTimeOut(empId);
            out.println(response);
        } catch (ArrayIndexOutOfBoundsException e) {
            out.println("ERROR|Invalid command format");
        }
    }

    private void handleLogout() {
        out.println("LOGOUT_SUCCESS");
        log("Client requested logout: " + currentEmployeeId + " from " + clientAddress);
    }

    private void cleanupResources() {
        try {
            if (out != null) out.close();
            if (in != null) in.close();
            if (socket != null && !socket.isClosed()) socket.close();
        } catch (IOException e) {
            log("Error cleaning up resources: " + e.getMessage());
        }
    }

    private boolean authenticateUser(String empIdStr, String password) {
        String sql = "SELECT status FROM employees WHERE employee_id = ? AND password = ?";
        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, empIdStr);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String status = rs.getString("status");
                if ("Active".equalsIgnoreCase(status)) {
                    return true;
                } else {
                    out.println("LOGIN_FAILED|Your account is not active. Please contact admin.");
                    log("Login failed for " + empIdStr + " from " + clientAddress + ": Account not active");
                    return false;
                }
            } else {
                return false; // Invalid credentials
            }
        } catch (SQLException e) {
            log("Database error during authentication: " + e.getMessage());
            return false;
        }
    }

    private String handleTimeIn(String empId) {
        LocalDate today = LocalDate.now();
        LocalTime now = LocalTime.now();
        boolean isLate = false;
        int lateHours = 0;
        String timeColumn = null;

        // Determine the time column and late status
        if (!now.isBefore(LocalTime.of(9, 0)) && now.isBefore(LocalTime.of(9, 15))) {
            timeColumn = "time_in_am";
        } else if (!now.isBefore(LocalTime.of(9, 15)) && now.isBefore(LocalTime.of(12, 0))) {
            timeColumn = "time_in_am";
            int lateMinutes = (int) Duration.between(LocalTime.of(9, 0), now).toMinutes();
            if (lateMinutes >= 16 && lateMinutes <= 30) {
                isLate = true;
                lateHours = 1;
            }
        } else if (!now.isBefore(LocalTime.of(13, 0)) && now.isBefore(LocalTime.of(13, 15))) {
            timeColumn = "time_in_pm";
        } else if (!now.isBefore(LocalTime.of(13, 15)) && now.isBefore(LocalTime.of(18, 0))) {
            timeColumn = "time_in_pm";
            int lateMinutes = (int) Duration.between(LocalTime.of(13, 0), now).toMinutes();
            if (lateMinutes >= 16 && lateMinutes <= 30) {
                isLate = true;
                lateHours = 1;
            }
        } else {
            String errorMsg = "ERROR|Time-in not allowed at this time";
            log("FAILED time-in for empId=" + empId + ": " + errorMsg);
            return errorMsg;
        }

        try (Connection con = getConnection()) {
            String sqlCheck = "SELECT * FROM attendance WHERE employee_id = ? AND date = ?";
            try (PreparedStatement ps = con.prepareStatement(sqlCheck)) {
                ps.setString(1, empId);
                ps.setDate(2, Date.valueOf(today));
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    int attendanceId = rs.getInt("attendance_id");

                    if ("time_in_am".equals(timeColumn) && rs.getTime("time_in_pm") != null) {
                        String errorMsg = "ERROR|You have already time-in for the PM session. AM time-in is not allowed.";
                        log("FAILED time-in for empId=" + empId + ": " + errorMsg);
                        return errorMsg;
                    }

                    if ("time_in_pm".equals(timeColumn) &&
                        rs.getTime("time_in_am") != null &&
                        rs.getTime("time_out_am") == null) {
                        String errorMsg = "ERROR|You must time-out for AM session before you can time-in for PM.";
                        log("FAILED time-in for empId=" + empId + ": " + errorMsg);
                        return errorMsg;
                    }

                    if (rs.getTime(timeColumn) != null) {
                        String errorMsg = "ERROR|" + timeColumn.toUpperCase().replace("_", " ") + " already recorded";
                        log("FAILED time-in for empId=" + empId + ": " + errorMsg);
                        return errorMsg;
                    }

                    String updateSql = "UPDATE attendance SET " + timeColumn + " = ? WHERE attendance_id = ?";
                    try (PreparedStatement updatePs = con.prepareStatement(updateSql)) {
                        updatePs.setTime(1, Time.valueOf(now));
                        updatePs.setInt(2, attendanceId);
                        updatePs.executeUpdate();
                    }

                    String successMsg = "SUCCESS|" + timeColumn.toUpperCase().replace("_", " ") + " recorded" + (isLate ? " (Late - " + lateHours + " hour deducted)" : "");
                    if (isLate) {
                        addWorkHours(con, attendanceId, -lateHours);
                    }
                    log("SUCCESS time-in for empId=" + empId + ": " + successMsg);
                    return successMsg;
                } else {
                    String insertSql = "INSERT INTO attendance (employee_id, date, " + timeColumn + ") VALUES (?, ?, ?)";
                    try (PreparedStatement insertPs = con.prepareStatement(insertSql, Statement.RETURN_GENERATED_KEYS)) {
                        insertPs.setString(1, empId);
                        insertPs.setDate(2, Date.valueOf(today));
                        insertPs.setTime(3, Time.valueOf(now));
                        insertPs.executeUpdate();

                        ResultSet keys = insertPs.getGeneratedKeys();
                        if (keys.next()) {
                            int newId = keys.getInt(1);
                            if (isLate) {
                                addWorkHours(con, newId, -lateHours);
                            }
                            String successMsg = "SUCCESS|" + timeColumn.toUpperCase().replace("_", " ") + " recorded" + (isLate ? " (Late - " + lateHours + " hour deducted)" : "");
                            log("SUCCESS time-in for empId=" + empId + ": " + successMsg);
                            return successMsg;
                        }
                    }
                }
            }
        } catch (SQLException e) {
            String errorMsg = "ERROR|Database error: " + e.getMessage();
            log("FAILED time-in for empId=" + empId + ": " + errorMsg);
            return errorMsg;
        }
        String errorMsg = "ERROR|Unexpected error during time-in";
        log("FAILED time-in for empId=" + empId + ": " + errorMsg);
        return errorMsg;
    }


    private String handleTimeOut(String empId) {
        LocalDate today = LocalDate.now();
        LocalTime now = LocalTime.now();
        String timeColumn = null;

        if (!now.isBefore(LocalTime.of(12, 0)) && now.isBefore(LocalTime.of(14, 1))) {
            timeColumn = "time_out_am";
        } else if (!now.isBefore(LocalTime.of(18, 0)) && !now.isAfter(LocalTime.of(20, 15))) {
            timeColumn = "time_out_pm";
        } else {
            String errorMsg = "ERROR|Time-out not allowed at this time";
            log("FAILED time-out for empId=" + empId + ": " + errorMsg);
            return errorMsg;
        }

        try (Connection con = getConnection()) {
            String sqlCheck = "SELECT * FROM attendance WHERE employee_id = ? AND date = ?";
            try (PreparedStatement ps = con.prepareStatement(sqlCheck)) {
                ps.setString(1, empId);
                ps.setDate(2, Date.valueOf(today));
                ResultSet rs = ps.executeQuery();

                if (!rs.next()) {
                    String errorMsg = "ERROR|No attendance record found. Please Time-In first";
                    log("FAILED time-out for empId=" + empId + ": " + errorMsg);
                    return errorMsg;
                }

                int attendanceId = rs.getInt("attendance_id");
                String inColumn = timeColumn.equals("time_out_am") ? "time_in_am" : "time_in_pm";
                Time timeIn = rs.getTime(inColumn);

                if (timeIn == null) {
                    String errorMsg = "ERROR|Time-out is not allowed without corresponding time-in";
                    log("FAILED time-out for empId=" + empId + ": " + errorMsg);
                    return errorMsg;
                }

                if (rs.getTime(timeColumn) != null) {
                    String errorMsg = "ERROR|" + timeColumn.toUpperCase().replace("_", " ") + " already recorded";
                    log("FAILED time-out for empId=" + empId + ": " + errorMsg);
                    return errorMsg;
                }

                String updateSql = "UPDATE attendance SET " + timeColumn + " = ? WHERE attendance_id = ?";
                try (PreparedStatement updatePs = con.prepareStatement(updateSql)) {
                    updatePs.setTime(1, Time.valueOf(now));
                    updatePs.setInt(2, attendanceId);
                    updatePs.executeUpdate();
                }

                long totalMinutes = Duration.between(timeIn.toLocalTime(), now).toMinutes();
                if (!timeIn.toLocalTime().isAfter(LocalTime.NOON) && !now.isBefore(LocalTime.of(13, 0))) {
                    totalMinutes -= 60;
                }

                String successMsg;
                if (totalMinutes < 15) {
                    successMsg = "SUCCESS|Worked less than 15 minutes. No hours counted";
                } else {
                    long hoursWorked = Math.round(totalMinutes / 60.0);
                    addWorkHours(con, attendanceId, hoursWorked);
                    successMsg = "SUCCESS|" + timeColumn.toUpperCase().replace("_", " ") + 
                                 " recorded. " + hoursWorked + " hour(s) added";
                }

                log("SUCCESS time-out for empId=" + empId + ": " + successMsg);
                return successMsg;
            }
        } catch (SQLException e) {
            String errorMsg = "ERROR|Database error: " + e.getMessage();
            log("FAILED time-out for empId=" + empId + ": " + errorMsg);
            return errorMsg;
        }
    }


    private void addWorkHours(Connection conn, int attendanceId, long workedHours) {
        try {
            String updateSql = "UPDATE attendance SET total_hours = IFNULL(total_hours, 0) + ? WHERE attendance_id = ?";
            PreparedStatement ps = conn.prepareStatement(updateSql);
            ps.setBigDecimal(1, BigDecimal.valueOf(workedHours));
            ps.setInt(2, attendanceId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/employee_attendance_system";
        String user = "root";
        String pass = "12345678"; // change password di
        return DriverManager.getConnection(url, user, pass);
    }

    
    private void log(String message) {
        try {
            String date = LocalDate.now().toString();
            String time = LocalTime.now().withNano(0).toString(); 
            String folderName = "logs";
            String fileName = folderName + File.separator + date + ".txt";
            String logEntry = "[" + time + "] [" + clientAddress + "] " + message;

            File logFolder = new File(folderName);
            if (!logFolder.exists()) {
                logFolder.mkdirs();
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
                writer.write(logEntry);
                writer.newLine();
            }

            System.out.println(logEntry);

        } catch (IOException e) {
            System.err.println("Failed to write to log file: " + e.getMessage());
        }
    }
}

