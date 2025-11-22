/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package student;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author MARY ANGEL
 */
public class RFThreader {
    private Connection conn;

    public RFThreader() {
        conn = DBConnection.getConnection();
        if (conn == null) {
            throw new RuntimeException("Database connection not established.");
        }
    }

    public void launchRF(String studentID, String acadYear, String semester) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        DefaultTableModel gradeTableModel = new DefaultTableModel();
        gradeTableModel.addColumn("Course");
        gradeTableModel.addColumn("Grade");
        gradeTableModel.addColumn("Units");

        try {
            String sql = "SELECT s.name, s.course, s.year_section, gwa.gwa, g.course_name, g.grade, g.units " +
                         "FROM students s " +
                         "JOIN gwa gwa ON s.id = gwa.studid " +
                         "JOIN grades g ON s.id = g.studid " +
                         "WHERE s.id = ? AND gwa.acadyear = ? AND gwa.semester = ? AND g.acadyear = ? AND g.semester = ?";

            stmt = conn.prepareStatement(sql);
            stmt.setString(1, studentID); 
            stmt.setString(2, acadYear);  
            stmt.setString(3, semester);  
            stmt.setString(4, acadYear);   
            stmt.setString(5, semester);   

            rs = stmt.executeQuery();

            if (rs.next()) {
                String studentName = rs.getString("name");
                String course = rs.getString("course");
                String yearSection = rs.getString("year_section");
                String gwa = rs.getString("gwa");

                LocalDateTime currentDateTime = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                String dateTime = currentDateTime.format(formatter);

                RF rfFrame = new RF();

                rfFrame.populateRF(studentID, studentName, course, yearSection, acadYear, semester, gwa, dateTime);

                do {
                    String courseName = rs.getString("course_name");
                    String grade = rs.getString("grade");
                    int units = rs.getInt("units");

                    gradeTableModel.addRow(new Object[]{courseName, grade, units});
                } while (rs.next());

                rfFrame.getGradeTable().setModel(gradeTableModel);

                rfFrame.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "No student data found for the provided details.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error fetching student data: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}