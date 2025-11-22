/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MARY ANGEL
 */
public class GradeThreader {
    private Connection conn;

    public GradeThreader() {
        conn = DBConnection.getConnection();
        if (conn == null) {
            throw new RuntimeException("Database connection not established in GradeThreader.");
        }
    }

public void LoadCourses(JTextField gradeStudIDTF, JTextField gradeAcadYearTF, JComboBox<String> gradeSemesterJCombo,
                        JTextField courseNameTF1, JTextField courseNameTF2, JTextField courseNameTF3,
                        JTextField courseNameTF4, JTextField courseNameTF5,
                        JTextField courseGradeTF1, JTextField courseGradeTF2, JTextField courseGradeTF3,
                        JTextField courseGradeTF4, JTextField courseGradeTF5) {

    String studentID = gradeStudIDTF.getText().trim();
    String acadYear = gradeAcadYearTF.getText().trim();
    String semester = gradeSemesterJCombo.getSelectedItem().toString().trim();

    if (studentID.isEmpty() || acadYear.isEmpty() || semester.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Please fill in all fields.");
        return;
    }

    String query = "SELECT course1, course2, course3, course4, course5 FROM course WHERE studid = ? AND acadyear = ? AND semester = ?";

    try (PreparedStatement pst = conn.prepareStatement(query)) {
        pst.setString(1, studentID);
        pst.setString(2, acadYear);
        pst.setString(3, semester);

        try (ResultSet rs = pst.executeQuery()) {
            if (rs.next()) {
                // Set course names
                courseNameTF1.setText(rs.getString("course1"));
                courseNameTF2.setText(rs.getString("course2"));
                courseNameTF3.setText(rs.getString("course3"));
                courseNameTF4.setText(rs.getString("course4"));
                courseNameTF5.setText(rs.getString("course5"));

                // For each course, check if it's dropped and set grade field appropriately
                setCourseGrade(courseGradeTF1, rs.getString("course1"), studentID, acadYear, semester);
                setCourseGrade(courseGradeTF2, rs.getString("course2"), studentID, acadYear, semester);
                setCourseGrade(courseGradeTF3, rs.getString("course3"), studentID, acadYear, semester);
                setCourseGrade(courseGradeTF4, rs.getString("course4"), studentID, acadYear, semester);
                setCourseGrade(courseGradeTF5, rs.getString("course5"), studentID, acadYear, semester);
            } else {
                JOptionPane.showMessageDialog(null, "No courses found for the given details.");
                clearFields(courseNameTF1, courseNameTF2, courseNameTF3, courseNameTF4, courseNameTF5,
                            courseGradeTF1, courseGradeTF2, courseGradeTF3, courseGradeTF4, courseGradeTF5);
            }
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error retrieving course data: " + e.getMessage());
        e.printStackTrace();
    }
}

private void setCourseGrade(JTextField gradeField, String courseName, String studid, String acadyear, String semester) {
    if (courseName == null || courseName.trim().isEmpty()) {
        gradeField.setText("");
        return;
    }

    String statusQuery = "SELECT status FROM course_status WHERE studid = ? AND course_name = ? AND acadyear = ? AND semester = ?";

    try (PreparedStatement pst = conn.prepareStatement(statusQuery)) {
        pst.setString(1, studid);
        pst.setString(2, courseName);
        pst.setString(3, acadyear);
        pst.setString(4, semester);

        try (ResultSet rs = pst.executeQuery()) {
            if (rs.next() && "Dropped".equalsIgnoreCase(rs.getString("status"))) {
                gradeField.setText("DRP");
            } else {
                gradeField.setText(""); // Leave empty if not dropped
            }
        }
    } catch (SQLException e) {
        gradeField.setText(""); // fallback if error happens
        System.err.println("Error checking course status for " + courseName + ": " + e.getMessage());
    }
}

private void clearFields(JTextField... fields) {
    for (JTextField field : fields) {
        field.setText("");
    }
}

public double calculateGwa(JTextField[] courseGrades, JTextField[] courseNames) {
    int totalUnits = 0;
    double totalGradePoints = 0.0;
    final int units = 3;

    for (int i = 0; i < courseNames.length; i++) {
        String gradeText = courseGrades[i].getText().trim();
        String courseName = courseNames[i].getText().trim();

        if (courseName.isEmpty()) continue;

        if (!gradeText.equalsIgnoreCase("DRP") && !gradeText.equalsIgnoreCase("INC")) {
            try {
                double gradeValue = Double.parseDouble(gradeText);
                totalGradePoints += gradeValue * units;
                totalUnits += units;
            } catch (NumberFormatException e) {
                System.err.println("Skipping non-numeric grade: " + gradeText);
            }
        }
    }

    if (totalUnits == 0) {
        return -1; // Indicator for no valid grades
    }

    return totalGradePoints / totalUnits;
}


public void saveGradeAndGWA(String studid, String acadYear, String semester,
                            JTextField[] courseNames, JTextField[] courseGrades) {

    int units = 3;

    try {
        for (int i = 0; i < courseNames.length; i++) {
            String courseName = courseNames[i].getText().trim();
            String gradeText = courseGrades[i].getText().trim();

            if (courseName.isEmpty()) continue;

            // Check if dropped
            String status = getCourseStatus(studid, courseName, acadYear, semester);
            if ("Dropped".equalsIgnoreCase(status)) {
                gradeText = "DRP";
                courseGrades[i].setText("DRP");
            }

            // Save to grades table
            String insertGrade = "REPLACE INTO grades (studid, course_name, acadyear, semester, grade, units) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement pst = conn.prepareStatement(insertGrade)) {
                pst.setString(1, studid);
                pst.setString(2, courseName);
                pst.setString(3, acadYear);
                pst.setString(4, semester);
                pst.setString(5, gradeText);
                pst.setInt(6, units);
                pst.executeUpdate();
            }
        }

        double gwa = calculateGwa(courseGrades, courseNames);

        if (gwa == -1) {
            JOptionPane.showMessageDialog(null, "No valid grades available to calculate GWA.");
            return;
        }

        // Save GWA
        String insertGWA = "REPLACE INTO gwa (studid, acadyear, semester, gwa) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pst = conn.prepareStatement(insertGWA)) {
            pst.setString(1, studid);
            pst.setString(2, acadYear);
            pst.setString(3, semester);
            pst.setDouble(4, gwa);
            pst.executeUpdate();
        }

        JOptionPane.showMessageDialog(null, "Grades and GWA saved successfully.\nGWA: " + String.format("%.2f", gwa));

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error saving grades or GWA: " + e.getMessage());
        e.printStackTrace();
    }
}

private String getCourseStatus(String studid, String courseName, String acadYear, String semester) {
    String query = "SELECT status FROM course_status WHERE studid = ? AND course_name = ? AND acadyear = ? AND semester = ?";
    try (PreparedStatement pst = conn.prepareStatement(query)) {
        pst.setString(1, studid);
        pst.setString(2, courseName);
        pst.setString(3, acadYear);
        pst.setString(4, semester);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            return rs.getString("status");
        }
    } catch (SQLException e) {
        System.err.println("Error checking status: " + e.getMessage());
    }
    return "Enrolled"; // Default if not found
}
public void searchGrades(JTextField gradeIDTF,
                         JTextField gradeNameTF,
                         JTextField gradeAYTF,
                         JComboBox<String> gradesemesterJcomboSearch,
                         JTable gradeTable,
                         JTextField gwaTFDisplay) {
    String studId    = gradeIDTF.getText().trim();
    String acadYear  = gradeAYTF.getText().trim();
    String semester  = gradesemesterJcomboSearch.getSelectedItem().toString().trim();

    if (studId.isEmpty() || acadYear.isEmpty() || semester.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Please enter Student ID, Academic Year and Semester.");
        return;
    }

    try {
        // 1) Fetch student name
        String nameQuery = "SELECT name FROM students WHERE id = ?";
        try (PreparedStatement pst = conn.prepareStatement(nameQuery)) {
            pst.setString(1, studId);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    gradeNameTF.setText(rs.getString("name"));
                } else {
                    gradeNameTF.setText("");
                    JOptionPane.showMessageDialog(null, "Student not found.");
                    return;
                }
            }
        }

        // 2) Populate gradeTable with course, grade, units
        DefaultTableModel model = (DefaultTableModel) gradeTable.getModel();
        model.setRowCount(0);
        String gradesQuery = 
            "SELECT course_name, grade, units " +
            "FROM grades " +
            "WHERE studid = ? AND acadyear = ? AND semester = ?";
        try (PreparedStatement pst = conn.prepareStatement(gradesQuery)) {
            pst.setString(1, studId);
            pst.setString(2, acadYear);
            pst.setString(3, semester);
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    String course = rs.getString("course_name");
                    String grade  = rs.getString("grade");
                    int units     = rs.getInt("units");
                    model.addRow(new Object[]{ course, grade, units });
                }
            }
        }

        // 3) Fetch and display GWA
        String gwaQuery = 
            "SELECT gwa FROM gwa WHERE studid = ? AND acadyear = ? AND semester = ?";
        try (PreparedStatement pst = conn.prepareStatement(gwaQuery)) {
            pst.setString(1, studId);
            pst.setString(2, acadYear);
            pst.setString(3, semester);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    gwaTFDisplay.setText(String.format("%.2f", rs.getDouble("gwa")));
                } else {
                    gwaTFDisplay.setText("");
                }
            }
        }

    } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error during search: " + ex.getMessage());
    }
}
public void updateGradeAndGwa(String studid, String acadYear, String semester,
                              JTextField[] courseNames, JTextField[] courseGrades) {

    int units = 3;

    try {
        // Update grades for each course
        for (int i = 0; i < courseNames.length; i++) {
            String courseName = courseNames[i].getText().trim();
            String gradeText = courseGrades[i].getText().trim();

            if (courseName.isEmpty()) continue;

            // Check if dropped
            String status = getCourseStatus(studid, courseName, acadYear, semester);
            if ("Dropped".equalsIgnoreCase(status)) {
                gradeText = "DRP";
                courseGrades[i].setText("DRP");
            }

            // Update grade in the database
            String updateGrade = "REPLACE INTO grades (studid, course_name, acadyear, semester, grade, units) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement pst = conn.prepareStatement(updateGrade)) {
                pst.setString(1, studid);
                pst.setString(2, courseName);
                pst.setString(3, acadYear);
                pst.setString(4, semester);
                pst.setString(5, gradeText);
                pst.setInt(6, units);
                pst.executeUpdate();
            }
        }

        // Calculate GWA using the grades entered
        double gwa = calculateGwa(courseGrades, courseNames);

        if (gwa == -1) {
            JOptionPane.showMessageDialog(null, "No valid grades available to calculate GWA.");
            return;
        }

        // Update the GWA in the database
        String updateGWA = "REPLACE INTO gwa (studid, acadyear, semester, gwa) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pst = conn.prepareStatement(updateGWA)) {
            pst.setString(1, studid);
            pst.setString(2, acadYear);
            pst.setString(3, semester);
            pst.setDouble(4, gwa);
            pst.executeUpdate();
        }

        // Optionally, update UI to show the new GWA
        JOptionPane.showMessageDialog(null, "Grades and GWA updated successfully.\nGWA: " + String.format("%.2f", gwa));

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error updating grades or GWA: " + e.getMessage());
        e.printStackTrace();
    }
}


}