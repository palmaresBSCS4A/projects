/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author MARY ANGEL
 */
public class Employees extends javax.swing.JFrame {
    private String employeeId;

    /**
     * Creates new form EmployeeManagement
     */
    public Employees(String empId) {
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
    public void loadEmployeeData() {
        String query = "SELECT employee_id, full_name, department, position, role, contact_info, date_hired, status FROM employees";

        try (Connection conn = DBConnectionAdmin.getConnection();
             PreparedStatement pst = conn.prepareStatement(query);
             ResultSet rs = pst.executeQuery()) {

            String[] columnNames = {
                "Employee ID", "Full Name", "Department", "Position",
                "Role", "Contact Info", "Date Hired", "Status"
            };

            DefaultTableModel model = new DefaultTableModel(columnNames, 0);

            while (rs.next()) {
                Object[] row = {
                    rs.getString("employee_id"),
                    rs.getString("full_name"),
                    rs.getString("department"),
                    rs.getString("position"),
                    rs.getString("role"),
                    rs.getString("contact_info"),
                    rs.getDate("date_hired"),
                    rs.getString("status")
                };
                model.addRow(row);
            }

            employeesTBL.setModel(model);

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,
                "Failed to load employee data: " + ex.getMessage(),
                "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void searchEmployeeData() {
    String keyword = searchEmpTF.getText().trim();

    if (keyword.isEmpty()) {
        loadEmployeeData();
        return;
    }

    String query = "SELECT employee_id, full_name, department, position, role, contact_info, date_hired, status " +
                   "FROM employees " +
                   "WHERE LOWER(employee_id) = ? " +
                   "OR LOWER(full_name) = ? " +
                   "OR LOWER(department) = ? " +
                   "OR LOWER(position) = ? " +
                   "OR LOWER(role) = ? " +
                   "OR LOWER(status) = ?";  

    try (Connection conn = DBConnectionAdmin.getConnection();
         PreparedStatement pst = conn.prepareStatement(query)) {

        String exactKeyword = keyword.toLowerCase();

        for (int i = 1; i <= 6; i++) {
            pst.setString(i, exactKeyword);
        }

        ResultSet rs = pst.executeQuery();

        String[] columnNames = {
            "Employee ID", "Full Name", "Department", "Position",
            "Role", "Contact Info", "Date Hired", "Status"
        };

        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        while (rs.next()) {
            Object[] row = {
                rs.getString("employee_id"),
                rs.getString("full_name"),
                rs.getString("department"),
                rs.getString("position"),
                rs.getString("role"),
                rs.getString("contact_info"),
                rs.getDate("date_hired"),
                rs.getString("status")
            };
            model.addRow(row);
        }

        employeesTBL.setModel(model);

    } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null,
            "Failed to search employee data:\n" + ex.getMessage(),
            "Search Error", JOptionPane.ERROR_MESSAGE);
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

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        JLabelDate = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        JLabelTime = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        employeesTBL = new javax.swing.JTable();
        searchBTN = new javax.swing.JButton();
        ReturnDashboardBTN = new javax.swing.JButton();
        searchEmpTF = new javax.swing.JTextField();
        loadEmployeesBTN = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(900, 600));
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(900, 600));
        jPanel1.setMinimumSize(new java.awt.Dimension(900, 600));
        jPanel1.setLayout(null);

        jPanel4.setBackground(new java.awt.Color(0, 95, 155));
        jPanel4.setMaximumSize(new java.awt.Dimension(900, 80));
        jPanel4.setMinimumSize(new java.awt.Dimension(900, 80));
        jPanel4.setLayout(null);

        JLabelDate.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        JLabelDate.setForeground(new java.awt.Color(255, 255, 255));
        JLabelDate.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jPanel4.add(JLabelDate);
        JLabelDate.setBounds(710, 20, 150, 20);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/whitelogo.png"))); // NOI18N
        jPanel4.add(jLabel9);
        jLabel9.setBounds(20, 10, 64, 64);

        JLabelTime.setFont(new java.awt.Font("Dubai", 0, 18)); // NOI18N
        JLabelTime.setForeground(new java.awt.Color(255, 255, 255));
        JLabelTime.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jPanel4.add(JLabelTime);
        JLabelTime.setBounds(610, 40, 250, 20);

        jLabel12.setFont(new java.awt.Font("Dubai Light", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Employees Information");
        jPanel4.add(jLabel12);
        jLabel12.setBounds(90, 30, 230, 20);

        jPanel1.add(jPanel4);
        jPanel4.setBounds(0, 0, 900, 80);

        employeesTBL.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Employee ID", "Full Name", "Department", "Position", "Role", "Contact Info", "Date Hired", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(employeesTBL);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(100, 160, 710, 320);

        searchBTN.setBackground(new java.awt.Color(0, 65, 106));
        searchBTN.setFont(new java.awt.Font("Lucida Sans", 1, 16)); // NOI18N
        searchBTN.setForeground(new java.awt.Color(255, 255, 255));
        searchBTN.setText("Search");
        searchBTN.setMaximumSize(new java.awt.Dimension(250, 40));
        searchBTN.setMinimumSize(new java.awt.Dimension(250, 40));
        searchBTN.setPreferredSize(new java.awt.Dimension(250, 40));
        searchBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBTNActionPerformed(evt);
            }
        });
        jPanel1.add(searchBTN);
        searchBTN.setBounds(410, 120, 110, 30);

        ReturnDashboardBTN.setBackground(new java.awt.Color(0, 65, 106));
        ReturnDashboardBTN.setFont(new java.awt.Font("Lucida Sans", 1, 16)); // NOI18N
        ReturnDashboardBTN.setForeground(new java.awt.Color(255, 255, 255));
        ReturnDashboardBTN.setText("Back to Dashboard");
        ReturnDashboardBTN.setMaximumSize(new java.awt.Dimension(250, 40));
        ReturnDashboardBTN.setMinimumSize(new java.awt.Dimension(250, 40));
        ReturnDashboardBTN.setPreferredSize(new java.awt.Dimension(250, 40));
        ReturnDashboardBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReturnDashboardBTNActionPerformed(evt);
            }
        });
        jPanel1.add(ReturnDashboardBTN);
        ReturnDashboardBTN.setBounds(370, 490, 200, 40);

        searchEmpTF.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N
        searchEmpTF.setForeground(new java.awt.Color(0, 45, 75));
        searchEmpTF.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 45, 75)));
        searchEmpTF.setMaximumSize(new java.awt.Dimension(290, 25));
        searchEmpTF.setMinimumSize(new java.awt.Dimension(290, 25));
        searchEmpTF.setPreferredSize(new java.awt.Dimension(290, 25));
        searchEmpTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchEmpTFActionPerformed(evt);
            }
        });
        jPanel1.add(searchEmpTF);
        searchEmpTF.setBounds(100, 120, 290, 25);

        loadEmployeesBTN.setBackground(new java.awt.Color(56, 142, 60));
        loadEmployeesBTN.setFont(new java.awt.Font("Lucida Sans", 1, 16)); // NOI18N
        loadEmployeesBTN.setForeground(new java.awt.Color(255, 255, 255));
        loadEmployeesBTN.setText("Load Employees");
        loadEmployeesBTN.setMaximumSize(new java.awt.Dimension(250, 40));
        loadEmployeesBTN.setMinimumSize(new java.awt.Dimension(250, 40));
        loadEmployeesBTN.setPreferredSize(new java.awt.Dimension(250, 40));
        loadEmployeesBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadEmployeesBTNActionPerformed(evt);
            }
        });
        jPanel1.add(loadEmployeesBTN);
        loadEmployeesBTN.setBounds(610, 120, 190, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 900, 600);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void searchBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBTNActionPerformed
        // TODO add your handling code here
        searchEmployeeData();
        searchEmpTF.setText("");
    }//GEN-LAST:event_searchBTNActionPerformed

    private void ReturnDashboardBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReturnDashboardBTNActionPerformed
        // TODO add your handling code here:
        new AdminDashboard(employeeId).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ReturnDashboardBTNActionPerformed

    private void searchEmpTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchEmpTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchEmpTFActionPerformed

    private void loadEmployeesBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadEmployeesBTNActionPerformed
        loadEmployeeData();
        searchEmpTF.setText("");
    }//GEN-LAST:event_loadEmployeesBTNActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLabelDate;
    private javax.swing.JLabel JLabelTime;
    private javax.swing.JButton ReturnDashboardBTN;
    private javax.swing.JTable employeesTBL;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton loadEmployeesBTN;
    private javax.swing.JButton searchBTN;
    private javax.swing.JTextField searchEmpTF;
    // End of variables declaration//GEN-END:variables
}
