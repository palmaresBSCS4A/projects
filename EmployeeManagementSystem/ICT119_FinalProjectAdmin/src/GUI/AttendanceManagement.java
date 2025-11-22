/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import java.sql.ResultSetMetaData;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @author MARY ANGEL
 */
public class AttendanceManagement extends javax.swing.JFrame {
    private String employeeId;


    /**
     * Creates new form AttendanceManagement
     */
    public AttendanceManagement(String empId) {
        initComponents();
        this.employeeId = empId;
        setCurrentDate();    
        startClock();   
        
    }
    private void setCurrentDate() {
        LocalDate today = LocalDate.now();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        JLabelDate.setText(today.format(dateFormat));
    }
    private void startClock() {
        Timer timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LocalTime now = LocalTime.now();
                DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm:ss");
                JLabelTime.setText(now.format(timeFormat));
            }
        });
        timer.start();
    }
    private void loadTable(ResultSet rs, JTable table) throws SQLException {
        ResultSetMetaData metaData = rs.getMetaData();
        int columnCount = metaData.getColumnCount();
        DefaultTableModel model = new DefaultTableModel();

        for (int i = 1; i <= columnCount; i++) {
            model.addColumn(metaData.getColumnName(i));
        }

        while (rs.next()) {
            Object[] row = new Object[columnCount];
            for (int i = 1; i <= columnCount; i++) {
                row[i - 1] = rs.getObject(i);
            }
            model.addRow(row);
        }

        table.setModel(model);
    }

    private void exportToCSV() {
        int confirm = JOptionPane.showConfirmDialog(this, 
            "Do you want to export the current table to CSV?", 
            "Confirm Export", 
            JOptionPane.YES_NO_OPTION);

        if (confirm != JOptionPane.YES_OPTION) {
            return; 
        }

        try {
            String reportType = reportTypeJCombo.getSelectedItem().toString();
            String directoryPath = "C:\\Users\\MARY ANGEL\\OneDrive\\Documents\\NetBeansProjects\\Admin\\ICT119_FinalProjectAdmin\\src\\AttedanceReports";
            File dir = new File(directoryPath);
            if (!dir.exists()) dir.mkdirs();

            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String fileName;

            if (reportType.equals("Summary per Employee") && attendanceRecordTBL.getRowCount() == 1) {
                String empId = attendanceRecordTBL.getValueAt(0, 0).toString().replaceAll("\\s+", "_");
                String name = attendanceRecordTBL.getValueAt(0, 1).toString().replaceAll("\\s+", "_");
                fileName = empId + "_" + name + "_" + timestamp + ".csv";
            } else {
                fileName = reportType.replaceAll("\\s+", "_") + "_" + timestamp + ".csv";
            }

            File file = new File(dir, fileName);
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);

            for (int i = 0; i < attendanceRecordTBL.getColumnCount(); i++) {
                bw.write(attendanceRecordTBL.getColumnName(i));
                if (i < attendanceRecordTBL.getColumnCount() - 1) {
                    bw.write(",");
                }
            }
            bw.newLine();

            for (int row = 0; row < attendanceRecordTBL.getRowCount(); row++) {
                for (int col = 0; col < attendanceRecordTBL.getColumnCount(); col++) {
                    Object value = attendanceRecordTBL.getValueAt(row, col);
                    bw.write(value != null ? value.toString().replace(",", " ") : "");
                    if (col < attendanceRecordTBL.getColumnCount() - 1) {
                        bw.write(",");
                    }
                }
                bw.newLine();
            }

            bw.close();
            fw.close();

            JOptionPane.showMessageDialog(this, "CSV exported successfully to:\n" + file.getAbsolutePath());

        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "CSV export failed: " + e.getMessage());
        }
    }
    
    private void logAdminAction(String action) {
        try {
            String folderName = "admin_logs";
            File folder = new File(folderName);
            if (!folder.exists()) {
                folder.mkdirs(); 
            }

            String date = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            File logFile = new File(folderName + "/" + date + ".txt");

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(logFile, true))) {
                String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                writer.write("[" + timestamp + "] Admin ID: " + employeeId + " - " + action);
                writer.newLine();
            }

        } catch (IOException e) {
            System.err.println("Error writing log: " + e.getMessage());
        }
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        JLabelDate = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        JLabelTime = new javax.swing.JLabel();
        attendanceReturnDashboardBTN = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        attendanceRecordTBL = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        attendanceGenerateReportBTN = new javax.swing.JButton();
        reportTypeJCombo = new javax.swing.JComboBox<>();
        attendanceGenerateReportBTN1 = new javax.swing.JButton();
        ToJDateChooser = new com.toedter.calendar.JDateChooser();
        fromJDateChooser = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(900, 600));
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel.setBackground(new java.awt.Color(255, 255, 255));
        jPanel.setMaximumSize(new java.awt.Dimension(900, 600));
        jPanel.setMinimumSize(new java.awt.Dimension(900, 600));
        jPanel.setLayout(null);

        jPanel4.setBackground(new java.awt.Color(0, 95, 155));
        jPanel4.setMaximumSize(new java.awt.Dimension(900, 80));
        jPanel4.setMinimumSize(new java.awt.Dimension(900, 80));
        jPanel4.setLayout(null);

        JLabelDate.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        JLabelDate.setForeground(new java.awt.Color(255, 255, 255));
        JLabelDate.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        JLabelDate.setText("DATE");
        jPanel4.add(JLabelDate);
        JLabelDate.setBounds(710, 20, 150, 20);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/whitelogo.png"))); // NOI18N
        jPanel4.add(jLabel9);
        jLabel9.setBounds(20, 10, 64, 64);

        jLabel10.setFont(new java.awt.Font("Dubai Light", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Attendance Records Portal");
        jPanel4.add(jLabel10);
        jLabel10.setBounds(90, 30, 230, 20);

        JLabelTime.setFont(new java.awt.Font("Dubai", 0, 18)); // NOI18N
        JLabelTime.setForeground(new java.awt.Color(255, 255, 255));
        JLabelTime.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        JLabelTime.setText("TIME");
        jPanel4.add(JLabelTime);
        JLabelTime.setBounds(610, 40, 250, 20);

        jPanel.add(jPanel4);
        jPanel4.setBounds(0, 0, 900, 80);

        attendanceReturnDashboardBTN.setBackground(new java.awt.Color(0, 65, 106));
        attendanceReturnDashboardBTN.setFont(new java.awt.Font("Lucida Sans", 1, 16)); // NOI18N
        attendanceReturnDashboardBTN.setForeground(new java.awt.Color(255, 255, 255));
        attendanceReturnDashboardBTN.setText("Back to Dashboard");
        attendanceReturnDashboardBTN.setMaximumSize(new java.awt.Dimension(250, 40));
        attendanceReturnDashboardBTN.setMinimumSize(new java.awt.Dimension(250, 40));
        attendanceReturnDashboardBTN.setPreferredSize(new java.awt.Dimension(250, 40));
        attendanceReturnDashboardBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                attendanceReturnDashboardBTNActionPerformed(evt);
            }
        });
        jPanel.add(attendanceReturnDashboardBTN);
        attendanceReturnDashboardBTN.setBounds(620, 510, 200, 30);

        attendanceRecordTBL.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Employee ID", "Name", "Department", "Date", "Time In", "Time Out", "Total Hours"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(attendanceRecordTBL);

        jPanel.add(jScrollPane1);
        jScrollPane1.setBounds(60, 140, 770, 360);

        jLabel14.setFont(new java.awt.Font("Dubai Light", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 45, 75));
        jLabel14.setText("From:");
        jLabel14.setToolTipText("");
        jPanel.add(jLabel14);
        jLabel14.setBounds(60, 110, 90, 20);

        jLabel15.setFont(new java.awt.Font("Dubai Light", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 45, 75));
        jLabel15.setText("To:");
        jLabel15.setToolTipText("");
        jPanel.add(jLabel15);
        jLabel15.setBounds(290, 110, 90, 20);

        attendanceGenerateReportBTN.setBackground(new java.awt.Color(0, 119, 204));
        attendanceGenerateReportBTN.setFont(new java.awt.Font("Lucida Sans", 1, 16)); // NOI18N
        attendanceGenerateReportBTN.setForeground(new java.awt.Color(255, 255, 255));
        attendanceGenerateReportBTN.setText("Generate Report");
        attendanceGenerateReportBTN.setMaximumSize(new java.awt.Dimension(250, 40));
        attendanceGenerateReportBTN.setMinimumSize(new java.awt.Dimension(250, 40));
        attendanceGenerateReportBTN.setPreferredSize(new java.awt.Dimension(250, 40));
        attendanceGenerateReportBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                attendanceGenerateReportBTNActionPerformed(evt);
            }
        });
        jPanel.add(attendanceGenerateReportBTN);
        attendanceGenerateReportBTN.setBounds(80, 510, 180, 30);

        reportTypeJCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Full Attendance Records", "Summary per Employee", "Late or Incomplete Days" }));
        reportTypeJCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportTypeJComboActionPerformed(evt);
            }
        });
        jPanel.add(reportTypeJCombo);
        reportTypeJCombo.setBounds(550, 100, 280, 30);

        attendanceGenerateReportBTN1.setBackground(new java.awt.Color(56, 142, 60));
        attendanceGenerateReportBTN1.setFont(new java.awt.Font("Lucida Sans", 1, 16)); // NOI18N
        attendanceGenerateReportBTN1.setForeground(new java.awt.Color(255, 255, 255));
        attendanceGenerateReportBTN1.setText("Export to CSV");
        attendanceGenerateReportBTN1.setMaximumSize(new java.awt.Dimension(250, 40));
        attendanceGenerateReportBTN1.setMinimumSize(new java.awt.Dimension(250, 40));
        attendanceGenerateReportBTN1.setPreferredSize(new java.awt.Dimension(250, 40));
        attendanceGenerateReportBTN1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                attendanceGenerateReportBTN1ActionPerformed(evt);
            }
        });
        jPanel.add(attendanceGenerateReportBTN1);
        attendanceGenerateReportBTN1.setBounds(350, 510, 180, 30);
        jPanel.add(ToJDateChooser);
        ToJDateChooser.setBounds(320, 110, 180, 22);
        jPanel.add(fromJDateChooser);
        fromJDateChooser.setBounds(100, 110, 180, 22);

        getContentPane().add(jPanel);
        jPanel.setBounds(10, 0, 900, 600);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void attendanceGenerateReportBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_attendanceGenerateReportBTNActionPerformed
    String selectedReport = reportTypeJCombo.getSelectedItem().toString();
    logAdminAction("Generated report: " + selectedReport);

    java.util.Date fromDate = fromJDateChooser.getDate();
    java.util.Date toDate = ToJDateChooser.getDate();

    if (fromDate == null || toDate == null) {
        JOptionPane.showMessageDialog(this, "Please select both From and To dates.", "Input Error", JOptionPane.WARNING_MESSAGE);
        return;
    }

    java.sql.Date sqlFromDate = new java.sql.Date(fromDate.getTime());
    java.sql.Date sqlToDate = new java.sql.Date(toDate.getTime());

    try (Connection conn = DBConnectionAdmin.getConnection()) {
        PreparedStatement stmt = null;

        switch (selectedReport) {
            case "Full Attendance Records":
                stmt = conn.prepareStatement("""
                    SELECT 
                        e.employee_id AS 'Employee ID',
                        e.full_name AS 'Name',
                        e.department AS 'Department',
                        a.date AS 'Date',
                        a.time_in_am AS 'Time In AM',
                        a.time_out_am AS 'Time Out AM',
                        a.time_in_pm AS 'Time In PM',
                        a.time_out_pm AS 'Time Out PM',
                        a.total_hours AS 'Total Hours'
                    FROM attendance a
                    JOIN employees e ON e.employee_id = a.employee_id
                    WHERE a.date BETWEEN ? AND ?
                    ORDER BY a.date DESC;
                """);
                stmt.setDate(1, sqlFromDate);
                stmt.setDate(2, sqlToDate);
                break;

            case "Summary per Employee":
                stmt = conn.prepareStatement("""
                    SELECT 
                        e.employee_id AS 'Employee ID',
                        e.full_name AS 'Name',
                        e.department AS 'Department',
                        COUNT(a.date) AS 'Total Days Present',
                        SUM(a.total_hours) AS 'Total Hours Worked'
                    FROM attendance a
                    JOIN employees e ON e.employee_id = a.employee_id
                    WHERE a.date BETWEEN ? AND ?
                    GROUP BY e.employee_id, e.full_name, e.department
                    ORDER BY e.employee_id;
                """);
                stmt.setDate(1, sqlFromDate);
                stmt.setDate(2, sqlToDate);
                break;

            case "Late or Incomplete Days":
                stmt = conn.prepareStatement("""
                    SELECT 
                        e.employee_id AS 'employee id',
                        e.full_name AS 'name',
                        a.date AS 'date',
                        CONCAT(
                            CASE 
                                WHEN a.time_in_am > '09:15:00' THEN 'late am'
                                WHEN a.time_in_am IS NULL THEN 'missing time-in am'
                                WHEN a.time_out_am IS NULL THEN 'missing time-out am'
                                ELSE ''
                            END,
                            CASE 
                                WHEN a.time_in_pm > '13:15:00' THEN 
                                    CASE 
                                        WHEN a.time_in_am > '09:15:00' THEN ', late pm'
                                        ELSE 'late pm'
                                    END
                                WHEN a.time_in_pm IS NULL THEN 
                                    CASE 
                                        WHEN a.time_in_am > '09:15:00' THEN ', missing time-in pm'
                                        ELSE 'missing time-in pm'
                                    END
                                WHEN a.time_out_pm IS NULL THEN 
                                    CASE 
                                        WHEN a.time_in_am > '09:15:00' THEN ', missing time-out pm'
                                        ELSE 'missing time-out pm'
                                    END
                                ELSE ''
                            END
                        ) AS 'issues',
                        a.time_in_am AS 'time in am',
                        a.time_out_am AS 'time out am',
                        a.time_in_pm AS 'time in pm',
                        a.time_out_pm AS 'time out pm'
                    FROM attendance a
                    JOIN employees e ON e.employee_id = a.employee_id
                    WHERE 
                        (a.time_in_am > '09:15:00'
                        OR a.time_in_am IS NULL
                        OR a.time_out_am IS NULL
                        OR a.time_in_pm > '13:15:00'
                        OR a.time_in_pm IS NULL
                        OR a.time_out_pm IS NULL)
                        AND a.date BETWEEN ? AND ?
                    ORDER BY a.date DESC;
                """);
                stmt.setDate(1, sqlFromDate);
                stmt.setDate(2, sqlToDate);
                break;
        }

        if (stmt != null) {
            ResultSet rs = stmt.executeQuery();
            loadTable(rs, attendanceRecordTBL);
        }

    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error loading report: " + e.getMessage());
        }

    }//GEN-LAST:event_attendanceGenerateReportBTNActionPerformed

    private void attendanceReturnDashboardBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_attendanceReturnDashboardBTNActionPerformed
        // TODO add your handling code here:
        new AdminDashboard(employeeId).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_attendanceReturnDashboardBTNActionPerformed

    private void reportTypeJComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportTypeJComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_reportTypeJComboActionPerformed

    private void attendanceGenerateReportBTN1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_attendanceGenerateReportBTN1ActionPerformed
        // TODO add your handling code here:
        exportToCSV();
    }//GEN-LAST:event_attendanceGenerateReportBTN1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLabelDate;
    private javax.swing.JLabel JLabelTime;
    private com.toedter.calendar.JDateChooser ToJDateChooser;
    private javax.swing.JButton attendanceGenerateReportBTN;
    private javax.swing.JButton attendanceGenerateReportBTN1;
    private javax.swing.JTable attendanceRecordTBL;
    private javax.swing.JButton attendanceReturnDashboardBTN;
    private com.toedter.calendar.JDateChooser fromJDateChooser;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> reportTypeJCombo;
    // End of variables declaration//GEN-END:variables
}
