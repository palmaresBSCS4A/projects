/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package student;

import java.io.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import com.toedter.calendar.JDateChooser;


/**
 *
 * @author MARY ANGEL
 */

public class StudentThreader {
    private Connection conn;
    private Object[] lastDeletedRow = null;


 public StudentThreader() {
        conn = DBConnection.getConnection();
        if (conn == null) {
            throw new RuntimeException("Database connection not established in Threader.");
        }
    }

    /**
     * Saves a student record to the database.
     */
    public void saveStudent(JTextField id, JTextField name, JTextField course, JTextField yearSection,
                            JComboBox<String> gender, JDateChooser dob, JTextField address,
                            JTextField email, JTextField phone, JTextField fatherName, JTextField motherName) {
        String query = "INSERT INTO students "
            + "(id, name, course, year_section, sex, bdate, address, email, phoneNum, fatherName, motherName) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pst = conn.prepareStatement(query)) {
            pst.setString(1, id.getText());
            pst.setString(2, name.getText());
            pst.setString(3, course.getText());
            pst.setString(4, yearSection.getText());
            pst.setString(5, gender.getSelectedItem().toString());

            java.util.Date utilDate = dob.getDate();
            pst.setDate(6, new java.sql.Date(utilDate.getTime()));

            pst.setString(7, address.getText());
            pst.setString(8, email.getText());
            pst.setString(9, phone.getText());
            pst.setString(10, fatherName.getText());
            pst.setString(11, motherName.getText());

            int rows = pst.executeUpdate();
            if (rows > 0) {
                JOptionPane.showMessageDialog(null, "Student record saved successfully!");
            } else {
                JOptionPane.showMessageDialog(null, "Failed to save student record.");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public void loadTableData(DefaultTableModel model) {
        model.setRowCount(0);
        String query = "SELECT id, name, course, year_section, sex, bdate, address, email, phoneNum, fatherName, motherName FROM students";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("id"),
                    rs.getString("name"),
                    rs.getString("course"),
                    rs.getString("year_section"),
                    rs.getString("sex"),
                    rs.getDate("bdate"),
                    rs.getString("address"),
                    rs.getString("email"),
                    rs.getString("phoneNum"),
                    rs.getString("fatherName"),
                    rs.getString("motherName")
                });
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error loading data: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Searches for students by name and updates the table model.
     */
    public void searchStudent(JTextField searchField, DefaultTableModel model) {
      model.setRowCount(0);
      String query = "SELECT id, name, course, year_section, sex, bdate, address, email, phoneNum, fatherName, motherName "
                   + "FROM students "
                   + "WHERE id LIKE ? OR name LIKE ? OR course LIKE ? OR year_section LIKE ? OR sex LIKE ?";

      try (PreparedStatement pst = conn.prepareStatement(query)) {
          String keyword = "%" + searchField.getText() + "%";
          for (int i = 1; i <= 5; i++) {
              pst.setString(i, keyword);
          }

          try (ResultSet rs = pst.executeQuery()) {
              while (rs.next()) {
                  model.addRow(new Object[]{
                      rs.getString("id"),
                      rs.getString("name"),
                      rs.getString("course"),
                      rs.getString("year_section"),
                      rs.getString("sex"),
                      rs.getDate("bdate"),
                      rs.getString("address"),
                      rs.getString("email"),
                      rs.getString("phoneNum"),
                      rs.getString("fatherName"),
                      rs.getString("motherName")
                  });
              }
          }
      } catch (SQLException e) {
          JOptionPane.showMessageDialog(null, "Error searching data: " + e.getMessage());
          e.printStackTrace();
      }
  }
    public void deleteStudent(JTable table, DefaultTableModel model) {
        int selectedRow = table.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Please select a row to delete.");
            return;
        }

        String studentId = model.getValueAt(selectedRow, 0).toString();

        int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this student?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
        if (confirm != JOptionPane.YES_OPTION) return;

        try (PreparedStatement pst = conn.prepareStatement("DELETE FROM students WHERE id = ?")) {
            pst.setString(1, studentId);
            int rowsAffected = pst.executeUpdate();
            if (rowsAffected > 0) {
                lastDeletedRow = new Object[model.getColumnCount()];
                for (int i = 0; i < model.getColumnCount(); i++) {
                    lastDeletedRow[i] = model.getValueAt(selectedRow, i);
                }
                model.removeRow(selectedRow);
                JOptionPane.showMessageDialog(null, "Student deleted successfully.");
            } else {
                JOptionPane.showMessageDialog(null, "Failed to delete student.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error deleting student: " + e.getMessage());
            e.printStackTrace();
        }
    }
    public void undoDelete(DefaultTableModel model) {
        if (lastDeletedRow == null) {
            JOptionPane.showMessageDialog(null, "No deletion to undo.");
            return;
        }

        String insertQuery = "INSERT INTO students (id, name, course, year_section, sex, bdate, address, email, phoneNum, fatherName, motherName) "
                           + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pst = conn.prepareStatement(insertQuery)) {
            for (int i = 0; i < lastDeletedRow.length; i++) {
                Object value = lastDeletedRow[i];
                if (i == 5 && value instanceof java.util.Date) {
                    pst.setDate(i + 1, new java.sql.Date(((java.util.Date) value).getTime()));
                } else {
                    pst.setObject(i + 1, value);
                }
            }

            int rows = pst.executeUpdate();
            if (rows > 0) {
                model.addRow(lastDeletedRow);
                lastDeletedRow = null;
                JOptionPane.showMessageDialog(null, "Undo successful.");
            } else {
                JOptionPane.showMessageDialog(null, "Undo failed.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error undoing delete: " + e.getMessage());
            e.printStackTrace();
        }
    }
    public void updateStudent(JTextField idField, JTextField nameField, JTextField courseField, JTextField yearSectionField,
                              JComboBox<String> genderCombo, JDateChooser dobField, JTextField addressField,
                              JTextField emailField, JTextField phoneField, JTextField fatherNameField, JTextField motherNameField) {

        String studentId = idField.getText().trim();

        if (studentId.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter a Student ID to update.");
            return;
        }

        String query = "UPDATE students SET name = ?, course = ?, year_section = ?, sex = ?, bdate = ?, "
                     + "address = ?, email = ?, phoneNum = ?, fatherName = ?, motherName = ? WHERE id = ?";

        try (PreparedStatement pst = conn.prepareStatement(query)) {
            pst.setString(1, nameField.getText().trim());
            pst.setString(2, courseField.getText().trim());
            pst.setString(3, yearSectionField.getText().trim());
            pst.setString(4, genderCombo.getSelectedItem().toString());

            java.util.Date utilDate = dobField.getDate();
            pst.setDate(5, new java.sql.Date(utilDate.getTime()));

            pst.setString(6, addressField.getText().trim());
            pst.setString(7, emailField.getText().trim());
            pst.setString(8, phoneField.getText().trim());
            pst.setString(9, fatherNameField.getText().trim());
            pst.setString(10, motherNameField.getText().trim());
            pst.setString(11, studentId); 

            int rows = pst.executeUpdate();
            if (rows > 0) {
                JOptionPane.showMessageDialog(null, "Student record updated successfully!");
            } else {
                JOptionPane.showMessageDialog(null, "No student found with the given ID.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error updating student: " + e.getMessage());
            e.printStackTrace();
        }
    }
}