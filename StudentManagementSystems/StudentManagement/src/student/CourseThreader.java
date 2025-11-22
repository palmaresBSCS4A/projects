/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MARY ANGEL
 */
public class CourseThreader {
    private Connection conn;
    private Object[] lastDeletedRow = null;

    public CourseThreader() {
        conn = (Connection) DBConnection.getConnection();
        if (conn == null) {
            throw new RuntimeException("Database connection not established in CourseThreader.");
        }
    }
    
    public void save(JTextField studID, JTextField acadYear, JComboBox<String> semester,
                 JComboBox<String> course1, JComboBox<String> course2, JComboBox<String> course3,
                 JComboBox<String> course4, JComboBox<String> course5, JTable courseTable,
                 JTextField YearSectionTF, JTextField CourseTF) {

    String id = studID.getText().trim();
    String academicYear = acadYear.getText().trim();
    String sem = (String) semester.getSelectedItem();
    String year_section = YearSectionTF.getText().trim();
    String courseText = CourseTF.getText().trim();

    if (id.isEmpty() || academicYear.isEmpty() || sem == null || 
        year_section.isEmpty() || courseText.isEmpty() ||
        course1.getSelectedItem() == null || course2.getSelectedItem() == null ||
        course3.getSelectedItem() == null || course4.getSelectedItem() == null ||
        course5.getSelectedItem() == null) {
        JOptionPane.showMessageDialog(null, "Please enter all required fields.");
        return;
    }

    String validateQuery = "SELECT COUNT(*) FROM students WHERE id = ? AND year_section = ? AND course = ?";
    try (PreparedStatement validateStmt = conn.prepareStatement(validateQuery)) {
        validateStmt.setString(1, id);
        validateStmt.setString(2, year_section);
        validateStmt.setString(3, courseText);

        ResultSet validateRs = validateStmt.executeQuery();
        if (validateRs.next() && validateRs.getInt(1) == 0) {
            JOptionPane.showMessageDialog(null, "Mismatch in Student ID, Year & Section, or Course. Please double-check the entries.");
            return;
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error validating student-course details: " + e.getMessage());
        e.printStackTrace();
        return;
    }

    String checkQuery = "SELECT COUNT(*) FROM course WHERE studid = ? AND acadyear = ? AND semester = ?";
    try (PreparedStatement pst = conn.prepareStatement(checkQuery)) {
        pst.setString(1, id);
        pst.setString(2, academicYear);
        pst.setString(3, sem);

        ResultSet rs = pst.executeQuery();
        rs.next();

        if (rs.getInt(1) > 0) {
            JOptionPane.showMessageDialog(null, "This student has already enrolled for the selected semester and academic year.");
        } else {
            String query = "INSERT INTO course (studid, acadyear, semester, course1, course2, course3, course4, course5) " +
                           "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement pstInsert = conn.prepareStatement(query)) {
                pstInsert.setString(1, id);
                pstInsert.setString(2, academicYear);
                pstInsert.setString(3, sem);
                pstInsert.setString(4, (String) course1.getSelectedItem());
                pstInsert.setString(5, (String) course2.getSelectedItem());
                pstInsert.setString(6, (String) course3.getSelectedItem());
                pstInsert.setString(7, (String) course4.getSelectedItem());
                pstInsert.setString(8, (String) course5.getSelectedItem());

                int rows = pstInsert.executeUpdate();
                if (rows > 0) {
                    JOptionPane.showMessageDialog(null, "Course record saved successfully!");

                    String insertCourseStatusQuery = "INSERT INTO course_status (studid, acadyear, semester, course_name, status) VALUES (?, ?, ?, ?, 'Enrolled')";
                    try (PreparedStatement pstCourseStatus = conn.prepareStatement(insertCourseStatusQuery)) {

                        String[] courses = {
                            (String) course1.getSelectedItem(),
                            (String) course2.getSelectedItem(),
                            (String) course3.getSelectedItem(),
                            (String) course4.getSelectedItem(),
                            (String) course5.getSelectedItem()
                        };

                        for (String course : courses) {
                            if (course != null && !course.isEmpty()) {
                                pstCourseStatus.setString(1, id);
                                pstCourseStatus.setString(2, academicYear);
                                pstCourseStatus.setString(3, sem);
                                pstCourseStatus.setString(4, course);
                                pstCourseStatus.executeUpdate();
                            }
                        }
                    }
                    loadTableData((DefaultTableModel) courseTable.getModel());
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to save course record.");
                }
            }
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error saving course data: " + e.getMessage());
        e.printStackTrace();
    }
}

 
    public void loadTableData(DefaultTableModel model) {
        model.setRowCount(0);

        String query = "SELECT c.studid, s.name AS studname, c.acadyear, c.semester, " +
                       "c.course1, c.course2, c.course3, c.course4, c.course5 " +
                       "FROM course c " +
                       "JOIN students s ON c.studid = s.id";

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("studid"),
                    rs.getString("studname"),
                    rs.getString("acadyear"),
                    rs.getString("semester"),
                    rs.getString("course1"),
                    rs.getString("course2"),
                    rs.getString("course3"),
                    rs.getString("course4"),
                    rs.getString("course5")
                });
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error loading course table: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void search(JTextField studIDSearchTF, JTable courseTable) {
        DefaultTableModel model = (DefaultTableModel) courseTable.getModel();
        model.setRowCount(0);

        String searchText = "%" + studIDSearchTF.getText() + "%";

        String query = "SELECT c.studid, s.name AS studname, c.acadyear, c.semester, " +
                       "c.course1, c.course2, c.course3, c.course4, c.course5 " +
                       "FROM course c " +
                       "JOIN students s ON c.studid = s.id " +
                       "WHERE c.studid LIKE ? OR s.name LIKE ? OR c.acadyear LIKE ? OR " +
                       "c.semester LIKE ? OR c.course1 LIKE ? OR c.course2 LIKE ? OR " +
                       "c.course3 LIKE ? OR c.course4 LIKE ? OR c.course5 LIKE ?";

        try (PreparedStatement pst = conn.prepareStatement(query)) {
            for (int i = 1; i <= 9; i++) {
                pst.setString(i, searchText);
            }

            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    model.addRow(new Object[]{
                        rs.getString("studid"),
                        rs.getString("studname"),
                        rs.getString("acadyear"),
                        rs.getString("semester"),
                        rs.getString("course1"),
                        rs.getString("course2"),
                        rs.getString("course3"),
                        rs.getString("course4"),
                        rs.getString("course5")
                    });
                }

                if (model.getRowCount() == 0) {
                    JOptionPane.showMessageDialog(null, "No course records found matching the search.");
                }
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error searching course data: " + e.getMessage());
            e.printStackTrace();
        }
    }

public void dropCourse(JTable courseTable, DefaultTableModel model) {
    int selectedRow = courseTable.getSelectedRow();
    int selectedColumn = courseTable.getSelectedColumn();

    if (selectedRow == -1 || selectedColumn < 4 || selectedColumn > 8) {
        JOptionPane.showMessageDialog(null, "Please select a valid course to drop.");
        return;
    }

    String studentId = model.getValueAt(selectedRow, 0).toString();
    String academicYear = model.getValueAt(selectedRow, 2).toString();
    String semester = model.getValueAt(selectedRow, 3).toString();
    String courseName = model.getValueAt(selectedRow, selectedColumn).toString();

    int confirm = JOptionPane.showConfirmDialog(null,
        "Are you sure you want to drop " + courseName + "?", "Confirm Drop", JOptionPane.YES_NO_OPTION);
    if (confirm != JOptionPane.YES_OPTION) return;

    try {
        String updateCourseStatusQuery = "UPDATE course_status SET status = 'Dropped' " +
                                          "WHERE studid = ? AND acadyear = ? AND semester = ? AND course_name = ?";
        try (PreparedStatement pst = conn.prepareStatement(updateCourseStatusQuery)) {
            pst.setString(1, studentId);
            pst.setString(2, academicYear);
            pst.setString(3, semester);
            pst.setString(4, courseName);
            int rowsAffected = pst.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Course \"" + courseName + "\" dropped successfully.");
                loadTableData(model);  
            } else {
                JOptionPane.showMessageDialog(null, "Failed to drop the course.");
            }
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error dropping course: " + e.getMessage());
        e.printStackTrace();
    }
}


public void deleteCourse(JTable courseTable, DefaultTableModel model) {
    int selectedRow = courseTable.getSelectedRow();

    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(null, "Please select a row to delete.");
        return;
    }

    String studentId = model.getValueAt(selectedRow, 0).toString();
    String academicYear = model.getValueAt(selectedRow, 2).toString();
    String semester = model.getValueAt(selectedRow, 3).toString();

    int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this course record?",
                                                "Confirm Delete", JOptionPane.YES_NO_OPTION);
    if (confirm != JOptionPane.YES_OPTION) return;

    lastDeletedRow = new Object[model.getColumnCount()];
    for (int i = 0; i < model.getColumnCount(); i++) {
        lastDeletedRow[i] = model.getValueAt(selectedRow, i);
    }

    try {
        String deleteCourseStatusQuery = "DELETE FROM course_status WHERE studid = ? AND acadyear = ? AND semester = ?";
        try (PreparedStatement pst = conn.prepareStatement(deleteCourseStatusQuery)) {
            pst.setString(1, studentId);
            pst.setString(2, academicYear);
            pst.setString(3, semester);
            pst.executeUpdate();
        }

        String deleteCourseQuery = "DELETE FROM course WHERE studid = ? AND acadyear = ? AND semester = ?";
        try (PreparedStatement pst = conn.prepareStatement(deleteCourseQuery)) {
            pst.setString(1, studentId);
            pst.setString(2, academicYear);
            pst.setString(3, semester);
            pst.executeUpdate();
        }

        String deleteGradesQuery = "DELETE FROM grades WHERE studid = ? AND acadyear = ? AND semester = ?";
        try (PreparedStatement pst = conn.prepareStatement(deleteGradesQuery)) {
            pst.setString(1, studentId);
            pst.setString(2, academicYear);
            pst.setString(3, semester);
            pst.executeUpdate();
        }

        String deleteGwaQuery = "DELETE FROM gwa WHERE studid = ? AND acadyear = ? AND semester = ?";
        try (PreparedStatement pst = conn.prepareStatement(deleteGwaQuery)) {
            pst.setString(1, studentId);
            pst.setString(2, academicYear);
            pst.setString(3, semester);
            pst.executeUpdate();
        }

        
        model.removeRow(selectedRow);
        JOptionPane.showMessageDialog(null, "Course record deleted successfully.");

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error deleting course record: " + e.getMessage());
        e.printStackTrace();
    }
    }
}
