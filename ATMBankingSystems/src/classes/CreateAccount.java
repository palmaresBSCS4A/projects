/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package classes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class CreateAccount extends javax.swing.JFrame {
    MainApp main;
    Login login;

    /**
     * Creates new form Deposit
     */
    public CreateAccount(MainApp m, Login login) {
        initComponents();

        setSize(1366, 768);
        setPreferredSize(new java.awt.Dimension(1366, 768));
        setMinimumSize(new java.awt.Dimension(1366, 768));
        setMaximumSize(new java.awt.Dimension(1366, 768));
        setResizable(false);
        setLocationRelativeTo(null); // center
        this.main = m;
        this.login = login;
    }
    
     private void saveInfoToFile() {
    String accHolderName1 = accHolderTF1.getText();
    String accHolderName2 = accHolderTF2.getText();
    String age1 = ageTF1.getText();
    String age2 = ageTF2.getText();
    String accNo = accNoTF.getText();
    String address1 = addressTF1.getText();
    String address2 = addressTF2.getText();
    String contactNo1 = contactTF1.getText();
    String contactNo2 = contactTF2.getText();
    String email1 = emailTF1.getText();
    String email2 = emailTF2.getText();
    String occupation1 = occupationTF1.getText();
    String occupation2 = occupationTF2.getText();
    String amount = amountTF.getText();
    String pin = pinTF.getText();
    String idType1 = (String) jcomboID1.getSelectedItem();
    String idType2 = (String) jcomboID2.getSelectedItem();
    String subType = (String) jcomboSubType.getSelectedItem();
    String productType = (String) jcomboProductType.getSelectedItem();
    String currency = (String) jcomboCurrency.getSelectedItem();
    
    String allInfo;
    
    if (subType.equals("INDIVIDUAL")) {
        allInfo = "\nACCOUNT DETAILS" +
                "\nAccount Holder Name: " + accHolderName1 +
                "\nAccount Number: " + accNo +
                "\nAccount Sub-Type: " + subType +
                "\nProduct Type: " + productType +
                "\nCurrency: " + currency +
                "\nAmount: " + amount +
                "\nPIN: " + pin +
                "\nID: " + idType1 +
                "\nPERSONAL INFORMATION" +
                "\nAge: " + age1 +
                "\nAddress: " + address1 +
                "\nContact No.: " + contactNo1 +
                "\nEmail: " + email1 +
                "\nOccupation: " + occupation1;
    } else {
        allInfo = "\nACCOUNT DETAILS" +
                "\nPrimary Account Holder Name: " + accHolderName1 +
                "\nSecond Account Holder Name: " + accHolderName2 +
                "\nAccount Number: " + accNo +
                "\nAccount Sub-Type: " + subType +
                "\nProduct Type: " + productType +
                "\nCurrency: " + currency +
                "\nAmount: " + amount +
                "\nPIN: " + pin +
                "\nPrimary Account Holder ID: " + idType1 +
                "\nSecondary Account Holder ID: " + idType2 +
                "\nPERSONAL INFORMATION" +
                "\nPrimary Account Holder Age: " + age1 +
                "\nSecondary Account Holder Age: " + age2 +
                "\nPrimary Account Holder Address: " + address1 +
                "\nSecondary Account Holder Address: " + address2 +
                "\nPrimary Account Holder Contact No.: " + contactNo1 +
                "\nSecondary Account Holder Contact No.: " + contactNo2 +
                "\nPrimary Account Holder Email: " + email1 +
                "\nSecondary Account Holder Email: " + email2 +
                "\nPrimary Account Holder Occupation: " + occupation1 +
                "\nSecondary Account Holder Occupation: " + occupation2;
    }

    
    String filePath = "C:\\Users\\MARY ANGEL\\Documents\\ATM_BANK\\src\\classes\\Database.txt";

    try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(filePath, true)))) {
        writer.println(allInfo);
        writer.println();
    } catch (IOException e) {
        e.printStackTrace();
    }
}

private boolean accountExists(String accNo) {
    String filePath = "C:\\Users\\MARY ANGEL\\Documents\\ATM_BANK\\src\\classes\\Database.txt";

    try (Scanner scanner = new Scanner(new File(filePath))) {
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.contains("Account Number: " + accNo)) {
                return true;
            }
        }
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
    return false;
}

private boolean isValidAmount(String amount) {
    if (!amount.matches("\\d+")) {
        return false;
    }

    int intAmount = Integer.parseInt(amount);
    
    if (intAmount < 500) {
        return false;
    }
    return true;
}


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backBTN = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jcomboSubType = new javax.swing.JComboBox<>();
        jcomboCurrency = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        jcomboProductType = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        accHolderTF1 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        ageTF1 = new javax.swing.JTextField();
        jcomboID1 = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        accHolderTF2 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jcomboID2 = new javax.swing.JComboBox<>();
        jLabel23 = new javax.swing.JLabel();
        ageTF2 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        pinTF = new javax.swing.JTextField();
        accNoTF = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        addressTF1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        addressTF2 = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        contactTF1 = new javax.swing.JTextField();
        contactTF2 = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        emailTF1 = new javax.swing.JTextField();
        emailTF2 = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        occupationTF1 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        occupationTF2 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        amountTF = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        caBTN = new javax.swing.JButton();
        deleteBTN = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(null);

        backBTN.setFont(new java.awt.Font("Berlin Sans FB", 1, 24)); // NOI18N
        backBTN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/backIcon.png"))); // NOI18N
        backBTN.setText("Back");
        backBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBTNActionPerformed(evt);
            }
        });
        getContentPane().add(backBTN);
        backBTN.setBounds(1120, 630, 150, 60);

        jLabel7.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(2, 12, 66));
        jLabel7.setText("Select Sub-Type");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(50, 130, 200, 30);

        jLabel13.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(2, 12, 66));
        jLabel13.setText("Select Currency");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(270, 130, 190, 30);

        jcomboSubType.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        jcomboSubType.setForeground(new java.awt.Color(2, 12, 66));
        jcomboSubType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "INDIVIDUAL", "JOINT" }));
        jcomboSubType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcomboSubTypeActionPerformed(evt);
            }
        });
        getContentPane().add(jcomboSubType);
        jcomboSubType.setBounds(50, 160, 200, 30);

        jcomboCurrency.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        jcomboCurrency.setForeground(new java.awt.Color(2, 12, 66));
        jcomboCurrency.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PHP PESO", "US DOLLAR" }));
        jcomboCurrency.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcomboCurrencyActionPerformed(evt);
            }
        });
        getContentPane().add(jcomboCurrency);
        jcomboCurrency.setBounds(270, 160, 200, 30);

        jLabel14.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(2, 12, 66));
        jLabel14.setText("Select Product Type");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(50, 210, 240, 30);

        jcomboProductType.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        jcomboProductType.setForeground(new java.awt.Color(2, 12, 66));
        jcomboProductType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ATM SAVINGS ACCOUNT", "ATM CURRENT ACCOUNT" }));
        jcomboProductType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcomboProductTypeActionPerformed(evt);
            }
        });
        getContentPane().add(jcomboProductType);
        jcomboProductType.setBounds(50, 240, 270, 30);

        jLabel18.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 24)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(2, 12, 66));
        jLabel18.setText("Name of the Account Holder");
        getContentPane().add(jLabel18);
        jLabel18.setBounds(50, 280, 320, 30);

        accHolderTF1.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        accHolderTF1.setForeground(new java.awt.Color(2, 12, 66));
        accHolderTF1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accHolderTF1ActionPerformed(evt);
            }
        });
        getContentPane().add(accHolderTF1);
        accHolderTF1.setBounds(50, 310, 420, 40);

        jLabel20.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 24)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(2, 12, 66));
        jLabel20.setText("Age");
        getContentPane().add(jLabel20);
        jLabel20.setBounds(50, 350, 150, 30);

        ageTF1.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        ageTF1.setForeground(new java.awt.Color(2, 12, 66));
        ageTF1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ageTF1ActionPerformed(evt);
            }
        });
        getContentPane().add(ageTF1);
        ageTF1.setBounds(50, 380, 150, 40);

        jcomboID1.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        jcomboID1.setForeground(new java.awt.Color(2, 12, 66));
        jcomboID1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NATIONAL ID", "PASSPORT", "POSTAL ID", "TIN ID", "GOVERNMENT ID", "STUDENT ID" }));
        jcomboID1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcomboID1ActionPerformed(evt);
            }
        });
        getContentPane().add(jcomboID1);
        jcomboID1.setBounds(240, 380, 230, 40);

        jLabel19.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 24)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(2, 12, 66));
        jLabel19.setText("Select ID");
        getContentPane().add(jLabel19);
        jLabel19.setBounds(240, 350, 150, 30);

        jLabel21.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 24)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(2, 12, 66));
        jLabel21.setText("Name of the Account Holder");
        getContentPane().add(jLabel21);
        jLabel21.setBounds(50, 420, 310, 30);

        jLabel5.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(2, 12, 66));
        jLabel5.setText("(For Joint Acc.)");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(360, 430, 110, 21);

        accHolderTF2.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        accHolderTF2.setForeground(new java.awt.Color(2, 12, 66));
        accHolderTF2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accHolderTF2ActionPerformed(evt);
            }
        });
        getContentPane().add(accHolderTF2);
        accHolderTF2.setBounds(50, 450, 420, 40);

        jLabel22.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 24)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(2, 12, 66));
        jLabel22.setText("Age");
        getContentPane().add(jLabel22);
        jLabel22.setBounds(50, 490, 150, 30);

        jLabel3.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(2, 12, 66));
        jLabel3.setText("Select ID");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(240, 490, 150, 30);

        jcomboID2.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        jcomboID2.setForeground(new java.awt.Color(2, 12, 66));
        jcomboID2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NATIONAL ID", "PASSPORT", "POSTAL ID", "TIN ID", "GOVERNMENT ID", "STUDENT ID" }));
        jcomboID2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcomboID2ActionPerformed(evt);
            }
        });
        getContentPane().add(jcomboID2);
        jcomboID2.setBounds(240, 520, 230, 40);

        jLabel23.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(2, 12, 66));
        jLabel23.setText("(For Joint Acc.)");
        getContentPane().add(jLabel23);
        jLabel23.setBounds(340, 500, 110, 21);

        ageTF2.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        ageTF2.setForeground(new java.awt.Color(2, 12, 66));
        ageTF2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ageTF2ActionPerformed(evt);
            }
        });
        getContentPane().add(ageTF2);
        ageTF2.setBounds(50, 520, 150, 40);

        jLabel9.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(2, 12, 66));
        jLabel9.setText("PIN");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(50, 580, 100, 30);

        pinTF.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        pinTF.setForeground(new java.awt.Color(2, 12, 66));
        pinTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pinTFActionPerformed(evt);
            }
        });
        getContentPane().add(pinTF);
        pinTF.setBounds(100, 570, 260, 40);

        accNoTF.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        accNoTF.setForeground(new java.awt.Color(2, 12, 66));
        accNoTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accNoTFActionPerformed(evt);
            }
        });
        getContentPane().add(accNoTF);
        accNoTF.setBounds(530, 150, 420, 40);

        jLabel11.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Account No.");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(530, 120, 190, 30);

        jLabel24.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 24)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Address");
        getContentPane().add(jLabel24);
        jLabel24.setBounds(530, 190, 90, 30);

        addressTF1.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        addressTF1.setForeground(new java.awt.Color(2, 12, 66));
        addressTF1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressTF1ActionPerformed(evt);
            }
        });
        getContentPane().add(addressTF1);
        addressTF1.setBounds(530, 220, 420, 40);

        jLabel6.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Address");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(530, 260, 110, 30);

        addressTF2.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        addressTF2.setForeground(new java.awt.Color(2, 12, 66));
        addressTF2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressTF2ActionPerformed(evt);
            }
        });
        getContentPane().add(addressTF2);
        addressTF2.setBounds(530, 290, 420, 40);

        jLabel29.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("(For Joint Acc.)");
        getContentPane().add(jLabel29);
        jLabel29.setBounds(620, 270, 110, 21);

        jLabel25.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 24)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Contact No.");
        getContentPane().add(jLabel25);
        jLabel25.setBounds(530, 330, 150, 30);

        jLabel27.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("(For Joint Acc.)");
        getContentPane().add(jLabel27);
        jLabel27.setBounds(750, 340, 110, 21);

        contactTF1.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        contactTF1.setForeground(new java.awt.Color(2, 12, 66));
        contactTF1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contactTF1ActionPerformed(evt);
            }
        });
        getContentPane().add(contactTF1);
        contactTF1.setBounds(530, 360, 210, 40);

        contactTF2.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        contactTF2.setForeground(new java.awt.Color(2, 12, 66));
        contactTF2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contactTF2ActionPerformed(evt);
            }
        });
        getContentPane().add(contactTF2);
        contactTF2.setBounds(750, 360, 200, 40);

        jLabel26.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 24)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Email");
        getContentPane().add(jLabel26);
        jLabel26.setBounds(530, 400, 150, 30);

        jLabel28.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("(For Joint Acc.)");
        getContentPane().add(jLabel28);
        jLabel28.setBounds(750, 410, 110, 21);

        emailTF1.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        emailTF1.setForeground(new java.awt.Color(2, 12, 66));
        emailTF1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailTF1ActionPerformed(evt);
            }
        });
        getContentPane().add(emailTF1);
        emailTF1.setBounds(530, 430, 210, 40);

        emailTF2.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        emailTF2.setForeground(new java.awt.Color(2, 12, 66));
        emailTF2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailTF2ActionPerformed(evt);
            }
        });
        getContentPane().add(emailTF2);
        emailTF2.setBounds(750, 430, 210, 40);

        jLabel30.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 24)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Occupation");
        getContentPane().add(jLabel30);
        jLabel30.setBounds(530, 470, 150, 30);

        occupationTF1.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        occupationTF1.setForeground(new java.awt.Color(2, 12, 66));
        occupationTF1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                occupationTF1ActionPerformed(evt);
            }
        });
        getContentPane().add(occupationTF1);
        occupationTF1.setBounds(530, 500, 420, 40);

        jLabel17.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Occupation");
        getContentPane().add(jLabel17);
        jLabel17.setBounds(530, 540, 150, 30);

        jLabel31.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("(For Joint Acc.)");
        getContentPane().add(jLabel31);
        jLabel31.setBounds(660, 550, 110, 21);

        occupationTF2.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        occupationTF2.setForeground(new java.awt.Color(2, 12, 66));
        occupationTF2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                occupationTF2ActionPerformed(evt);
            }
        });
        getContentPane().add(occupationTF2);
        occupationTF2.setBounds(530, 570, 420, 40);

        jLabel12.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Initial Amount");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(980, 120, 190, 30);

        amountTF.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        amountTF.setForeground(new java.awt.Color(2, 12, 66));
        amountTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                amountTFActionPerformed(evt);
            }
        });
        getContentPane().add(amountTF);
        amountTF.setBounds(980, 150, 230, 40);

        jLabel32.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("Notice: Amount must be divisible by 500");
        jLabel32.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(jLabel32);
        jLabel32.setBounds(980, 200, 260, 20);

        caBTN.setBackground(new java.awt.Color(204, 255, 255));
        caBTN.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 24)); // NOI18N
        caBTN.setForeground(new java.awt.Color(2, 12, 66));
        caBTN.setText("Create Account");
        caBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                caBTNActionPerformed(evt);
            }
        });
        getContentPane().add(caBTN);
        caBTN.setBounds(1010, 310, 250, 40);

        deleteBTN.setBackground(new java.awt.Color(204, 255, 255));
        deleteBTN.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 24)); // NOI18N
        deleteBTN.setForeground(new java.awt.Color(2, 12, 66));
        deleteBTN.setText("Delete");
        deleteBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBTNActionPerformed(evt);
            }
        });
        getContentPane().add(deleteBTN);
        deleteBTN.setBounds(1010, 360, 250, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/createAccount.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1366, 768);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void backBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBTNActionPerformed
         // TODO add your handling code here:
        dispose();
        login.setVisible(true);
    }//GEN-LAST:event_backBTNActionPerformed

    private void jcomboSubTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcomboSubTypeActionPerformed

        if ("INDIVIDUAL".equals(jcomboSubType.getSelectedItem())) {
            // If selected subtype is "INDIVIDUAL", disable accHolderTF2 and clear its text
            accHolderTF2.setEnabled(false);
            accHolderTF2.setBackground(new java.awt.Color(107,107,107));
            ageTF2.setEnabled(false);
            ageTF2.setBackground(new java.awt.Color(107,107,107));
            addressTF2.setEnabled(false);
            addressTF2.setBackground(new java.awt.Color(107,107,107));
            contactTF2.setEnabled(false);
            contactTF2.setBackground(new java.awt.Color(107,107,107));
            emailTF2.setEnabled(false);
            emailTF2.setBackground(new java.awt.Color(107,107,107));
            jcomboID2.setEnabled(false);
            jcomboID2.setBackground(new java.awt.Color(107,107,107));
            occupationTF2.setEnabled(false);
            occupationTF2.setBackground(new java.awt.Color(107,107,107));

        } else {
            accHolderTF2.setEnabled(true);
            accHolderTF2.setBackground(new java.awt.Color(255, 255, 255));
            ageTF2.setEnabled(true);
            ageTF2.setBackground(new java.awt.Color(255, 255, 255));
            addressTF2.setEnabled(true);
            addressTF2.setBackground(new java.awt.Color(255, 255, 255));
            contactTF2.setEnabled(true);
            contactTF2.setBackground(new java.awt.Color(255, 255, 255));
            emailTF2.setEnabled(true);
            emailTF2.setBackground(new java.awt.Color(255, 255, 255));
            jcomboID2.setEnabled(true);
            jcomboID2.setBackground(new java.awt.Color(255, 255, 255));
            occupationTF2.setEnabled(true);
            occupationTF2.setBackground(new java.awt.Color(255, 255, 255));
        }
    }//GEN-LAST:event_jcomboSubTypeActionPerformed

    private void jcomboCurrencyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcomboCurrencyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcomboCurrencyActionPerformed

    private void jcomboProductTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcomboProductTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcomboProductTypeActionPerformed

    private void accHolderTF1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accHolderTF1ActionPerformed
        // TODO add your handling code here:  
    }//GEN-LAST:event_accHolderTF1ActionPerformed

    private void ageTF1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ageTF1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ageTF1ActionPerformed

    private void jcomboID1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcomboID1ActionPerformed

    }//GEN-LAST:event_jcomboID1ActionPerformed

    private void accHolderTF2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accHolderTF2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_accHolderTF2ActionPerformed

    private void jcomboID2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcomboID2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcomboID2ActionPerformed

    private void ageTF2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ageTF2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ageTF2ActionPerformed

    private void pinTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pinTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pinTFActionPerformed

    private void accNoTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accNoTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_accNoTFActionPerformed

    private void addressTF1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressTF1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addressTF1ActionPerformed

    private void addressTF2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressTF2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addressTF2ActionPerformed

    private void contactTF1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contactTF1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contactTF1ActionPerformed

    private void contactTF2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contactTF2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contactTF2ActionPerformed

    private void emailTF1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailTF1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailTF1ActionPerformed

    private void emailTF2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailTF2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailTF2ActionPerformed

    private void occupationTF1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_occupationTF1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_occupationTF1ActionPerformed

    private void occupationTF2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_occupationTF2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_occupationTF2ActionPerformed

    private void amountTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_amountTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_amountTFActionPerformed

    private void caBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_caBTNActionPerformed
String accNo = accNoTF.getText().trim();

if (accNo.length() != 6 || !accNo.matches("\\d{6}")) {
    JOptionPane.showMessageDialog(this, "Account number must be 6 digits.", "Error", JOptionPane.ERROR_MESSAGE);
    return;
}

if (accountExists(accNo)) {
    JOptionPane.showMessageDialog(this, "Account number already exists.", "Error", JOptionPane.ERROR_MESSAGE);
    return;
}

String iniAmount = amountTF.getText();

if (!isValidAmount(iniAmount)) {
    JOptionPane.showMessageDialog(this, "Amount must be at least PHP/USD 500.", "Error", JOptionPane.ERROR_MESSAGE);
    return;
}

if (jcomboSubType.getSelectedItem().equals("INDIVIDUAL")) {
    if (accHolderTF1.getText().equals("") || ageTF1.getText().equals("") ||
            pinTF.getText().equals("") || addressTF1.getText().equals("") ||
            contactTF1.getText().equals("") || emailTF1.getText().equals("") ||
            occupationTF1.getText().equals("")) {
        JOptionPane.showMessageDialog(null, "Please complete your Information!", "Iris Bank System", JOptionPane.INFORMATION_MESSAGE);
    } else {
        int option = JOptionPane.showConfirmDialog(this, "Are you sure you want to create the account?", "Confirmation", JOptionPane.YES_NO_OPTION);

        if (option == JOptionPane.YES_OPTION) {
            saveInfoToFile();
            JOptionPane.showMessageDialog(this, "Account created successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        }

        accHolderTF1.setText("");
        ageTF1.setText("");
        pinTF.setText("");
        accNoTF.setText("");
        addressTF1.setText("");
        emailTF1.setText("");
        contactTF1.setText("");
        occupationTF1.setText("");
        amountTF.setText("");
    }
} else if (jcomboSubType.getSelectedItem().equals("JOINT")) {
    if (accHolderTF1.getText().equals("") || ageTF1.getText().equals("") ||
            pinTF.getText().equals("") || addressTF1.getText().equals("") ||
            contactTF1.getText().equals("") || emailTF1.getText().equals("") ||
            occupationTF1.getText().equals("") || accHolderTF2.getText().equals("") ||
            ageTF2.getText().equals("") || addressTF2.getText().equals("") ||
            emailTF2.getText().equals("") || contactTF2.getText().equals("") ||
            occupationTF2.getText().equals("")) {
        JOptionPane.showMessageDialog(null, "Please complete your information!", "Iris Bank System", JOptionPane.INFORMATION_MESSAGE);
    } else {
        int option = JOptionPane.showConfirmDialog(this, "Are you sure you want to create the account?", "Confirmation", JOptionPane.YES_NO_OPTION);

        if (option == JOptionPane.YES_OPTION) {
            saveInfoToFile();
            JOptionPane.showMessageDialog(this, "Account created successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        }

        accHolderTF1.setText("");
        accHolderTF2.setText("");
        ageTF1.setText("");
        ageTF2.setText("");
        pinTF.setText("");
        accNoTF.setText("");
        addressTF1.setText("");
        addressTF2.setText("");
        emailTF1.setText("");
        emailTF2.setText("");
        contactTF1.setText("");
        contactTF2.setText("");
        occupationTF1.setText("");
        occupationTF2.setText("");
        amountTF.setText("");
    }
    }
    }//GEN-LAST:event_caBTNActionPerformed

    private void deleteBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBTNActionPerformed
        accHolderTF1.setText("");
        accHolderTF2.setText("");
        ageTF1.setText("");
        ageTF2.setText("");
        pinTF.setText("");
        accNoTF.setText("");
        addressTF1.setText("");
        addressTF2.setText("");
        emailTF1.setText("");
        emailTF2.setText("");
        contactTF1.setText("");
        contactTF2.setText("");
        occupationTF1.setText("");
        occupationTF2.setText("");
        amountTF.setText("");
    }//GEN-LAST:event_deleteBTNActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
         
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField accHolderTF1;
    private javax.swing.JTextField accHolderTF2;
    private javax.swing.JTextField accNoTF;
    private javax.swing.JTextField addressTF1;
    private javax.swing.JTextField addressTF2;
    private javax.swing.JTextField ageTF1;
    private javax.swing.JTextField ageTF2;
    private javax.swing.JTextField amountTF;
    private javax.swing.JButton backBTN;
    private javax.swing.JButton caBTN;
    private javax.swing.JTextField contactTF1;
    private javax.swing.JTextField contactTF2;
    private javax.swing.JButton deleteBTN;
    private javax.swing.JTextField emailTF1;
    private javax.swing.JTextField emailTF2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JComboBox<String> jcomboCurrency;
    private javax.swing.JComboBox<String> jcomboID1;
    private javax.swing.JComboBox<String> jcomboID2;
    private javax.swing.JComboBox<String> jcomboProductType;
    private javax.swing.JComboBox<String> jcomboSubType;
    private javax.swing.JTextField occupationTF1;
    private javax.swing.JTextField occupationTF2;
    private javax.swing.JTextField pinTF;
    // End of variables declaration//GEN-END:variables
}
