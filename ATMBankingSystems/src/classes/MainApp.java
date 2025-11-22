/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package classes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class MainApp extends javax.swing.JFrame {
    private double balance;
    private String accountNumber;
    private String pin;
    private String currency;
    private CreateAccount createAccount;
    private Login login;
    private Map<String, List<String>> transactionRecordMap; 
    private SimpleDateFormat dateFormat;
    DecimalFormat df = new DecimalFormat("#,###.00");
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    
    /**
     * Creates new form MainApp
     */
    public MainApp(CreateAccount createAccount, Login login, String accountNumber, String pin, double amount, String currency) {
        initComponents();
        
        setSize(1366, 768);
        setPreferredSize(new java.awt.Dimension(1366, 768));
        setMinimumSize(new java.awt.Dimension(1366, 768));
        setMaximumSize(new java.awt.Dimension(1366, 768));
        setResizable(false);
        setLocationRelativeTo(null); // center

        
        this.createAccount = createAccount;
        this.login = login;
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = amount; 
        this.currency = currency;
        
        transactionRecordMap = new HashMap<>(); 
        transactionRecordMap.put("Withdrawal", new ArrayList<>());
        transactionRecordMap.put("Deposit", new ArrayList<>());
        transactionRecordMap.put("FastCash", new ArrayList<>());
        transactionRecordMap.put("Transfer", new ArrayList<>());
        transactionRecordMap.put("Change PIN", new ArrayList<>());
        
        dateFormat = new SimpleDateFormat("yyyy-MM");
        
        generateMonthlyReportIfSpecificDay(27); 
        generateWeeklyReportIfSpecificDay();
    }

    
    public double getBalance()
    {
        return this.balance;
    }
    
    
    public String getCurrency() {
        return this.currency;
    }
    
    public void withdraw(double amount, String currency) {
    if (currency.equalsIgnoreCase("PHP PESO")) {
        if (amount > 0 && amount % 500 == 0 && amount <= this.balance) {
            this.balance -= amount;
            recordTransaction(amount, "Withdrawal");
            JOptionPane.showMessageDialog(null, "Successfully withdrawn PHP " + df.format(amount) + " from your account.\nCurrent Balance: PHP " + df.format(this.balance));
            int choice = JOptionPane.showConfirmDialog(null,"\nDo you want a receipt?", "Receipt Confirmation", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
            generateReceipt("Withdrawal", amount);
        }
            updateAmountInFile();
        } else {
            JOptionPane.showMessageDialog(null, "Invalid withdrawal amount.\nPlease enter a positive value that is a multiple of 500 and does not exceed your current balance.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } else if (currency.equalsIgnoreCase("US DOLLAR")) {
        if (amount > 0 && amount % 50 == 0 && amount <= this.balance) {
            this.balance -= amount;
            recordTransaction(amount, "Withdrawal");
            JOptionPane.showMessageDialog(null, "Successfully withdrawn USD " + df.format(amount) + " from your account.\nCurrent Balance: USD " + df.format(this.balance));
            int choice = JOptionPane.showConfirmDialog(null,"\nDo you want a receipt?", "Receipt Confirmation", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
            generateReceipt("Withdrawal", amount);
        }
            updateAmountInFile();
        } else {
            JOptionPane.showMessageDialog(null, "Invalid withdrawal amount.\nPlease enter a positive value that is a multiple of 50 and does not exceed your current balance.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } else {
        JOptionPane.showMessageDialog(null, "Invalid currency selection.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    }
    
    public void deposit(double deposit, String currency) {
    if (currency.equalsIgnoreCase("PHP PESO")) {
        if (deposit > 0 && deposit % 500 == 0) {
            this.balance += deposit;
            recordTransaction(deposit, "Deposit");
            JOptionPane.showMessageDialog(null, "Successfully deposited PHP " + df.format(deposit) + " into your account.\nCurrent Balance: PHP " + df.format(this.balance));
            int choice = JOptionPane.showConfirmDialog(null,"\nDo you want a receipt?", "Receipt Confirmation", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
            generateReceipt("Deposit", deposit);
        }
            updateAmountInFile();
        } else {
            JOptionPane.showMessageDialog(null, "Invalid deposit amount.\nPlease enter a positive value that is a multiple of 500.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } else if (currency.equalsIgnoreCase("US DOLLAR")) {
        if (deposit > 0 && deposit % 50 == 0) {
            this.balance += deposit;
            recordTransaction(deposit, "Deposit");
            JOptionPane.showMessageDialog(null, "Successfully deposited USD " + df.format(deposit) + " into your account.\nCurrent Balance: USD " + df.format(this.balance));
            int choice = JOptionPane.showConfirmDialog(null,"\nDo you want a receipt?", "Receipt Confirmation", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
            generateReceipt("Deposit", deposit);
            }
            updateAmountInFile();
        } else {
            JOptionPane.showMessageDialog(null, "Invalid deposit amount.\nPlease enter a positive value that is a multiple of 50.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } else {
        JOptionPane.showMessageDialog(null, "Invalid currency selection.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}

    
    public void FastCash(double cash, String currency) {
        if (currency.equalsIgnoreCase("PHP PESO")) {
        if (cash > 0 && cash <= this.balance) {
            int choice = JOptionPane.showConfirmDialog(null, "Do you really want to withdraw PHP " + df.format(cash) + "?\nCurrent Balance: PHP " + df.format(this.balance), "Fast Cash Confirmation", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                this.balance -= cash;
                recordTransaction(cash, "FastCash");
                JOptionPane.showMessageDialog(null, "Successfully withdrew PHP " + df.format(cash) + " from your account.\nCurrent Balance: PHP " + df.format(this.balance));
                int choiceReceipt = JOptionPane.showConfirmDialog(null,"\nDo you want a receipt?", "Receipt Confirmation", JOptionPane.YES_NO_OPTION);
              if (choiceReceipt == JOptionPane.YES_OPTION) {
            generateReceipt("Fast Cash", cash);

                updateAmountInFile();
            }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Insufficient balance.\nCurrent Balance: PHP " + df.format(this.balance), "Error", JOptionPane.ERROR_MESSAGE);
        }
    } else if (currency.equalsIgnoreCase("US DOLLAR")) {
        if (cash > 0 && cash % 50 == 0 && cash <= this.balance) {
            int choice = JOptionPane.showConfirmDialog(null, "Do you really want to withdraw USD " + df.format(cash) + "?\nCurrent Balance: USD " + df.format(this.balance), "Fast Cash Confirmation", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                this.balance -= cash;
                recordTransaction(cash, "FastCash");
                JOptionPane.showMessageDialog(null, "Successfully withdrew USD " + df.format(cash) + " from your account.\nCurrent Balance: USD " + df.format(this.balance));
                int choiceReceipt = JOptionPane.showConfirmDialog(null,"\nDo you want a receipt?", "Receipt Confirmation", JOptionPane.YES_NO_OPTION);
        if (choiceReceipt == JOptionPane.YES_OPTION) {
            generateReceipt("Fast Cash", cash);

                updateAmountInFile();
            }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Invalid withdrawal amount.\nPlease enter a positive value that is a multiple of 50 and does not exceed your current balance.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } else {
        JOptionPane.showMessageDialog(null, "Invalid currency selection.", "Error", JOptionPane.ERROR_MESSAGE);
    }         
    }

private void updateAmountInFile() {
    String filePath = "src\\classes\\Database.txt";
    boolean accountFound = false;
    StringBuilder updatedContent = new StringBuilder();

    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
        String line;

        while ((line = reader.readLine()) != null) {
            if (line.startsWith("Account Number: " + accountNumber)) {
                accountFound = true;
                updatedContent.append(line).append(System.lineSeparator());
            } else if (line.startsWith("Amount: ") && accountFound) {
                line = "Amount: " + df.format(balance);
                updatedContent.append(line).append(System.lineSeparator());
                accountFound = false;
            } else {
                updatedContent.append(line).append(System.lineSeparator());
            }
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(updatedContent.toString());
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Failed to update amount for your account", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } catch (IOException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Failed to update your account.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}


    private void recordTransaction(double amount, String type) {
    String fileName = accountNumber + "_Transactions.txt";
    String filePath = "src\\classes\\Transactions\\" + fileName;
    String timestamp = sdf.format(new Date());

    List<String> records = transactionRecordMap.get(type);
    if (records == null) {
        records = new ArrayList<>(); 
        transactionRecordMap.put(type, records);
    }

    String transactionRecord = timestamp + " - " + type + ": " + df.format(amount);
    records.add(transactionRecord);

    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
        writer.write(transactionRecord + "\n");
    } catch (IOException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Failed to record transaction.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}

    
public void transfer(double amount, String receiverAccountNumber, String receiverCurrency) {
    if (!isReceiverAccountValid(receiverAccountNumber)) {
        JOptionPane.showMessageDialog(null, "Receiver's account does not exist.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    if (amount <= 0) {
        JOptionPane.showMessageDialog(null, "Invalid transfer amount.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    if (amount > this.balance) {
        JOptionPane.showMessageDialog(null, "Insufficient balance for the transfer.\nCurrent Balance: " + this.currency + " " + df.format(this.balance), "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    boolean convertCurrency = !this.currency.equalsIgnoreCase(receiverCurrency);

    if (this.currency.equalsIgnoreCase("PHP PESO")) {
        if (amount % 500 != 0) {
            JOptionPane.showMessageDialog(null, "Invalid transfer amount. PHP Peso transfers must be in multiples of 500.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
    } else if (this.currency.equalsIgnoreCase("US DOLLAR")) {
        if (amount % 50 != 0) {
            JOptionPane.showMessageDialog(null, "Invalid transfer amount. US Dollar transfers must be in multiples of 50.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
    }

    if (!convertCurrency) {
        this.balance -= amount;
        recordTransaction(amount, "Transfer to " + receiverAccountNumber + " (" + this.currency + ")");
        updateReceiverAmountInFile(amount, receiverAccountNumber, "Received from " + this.accountNumber + " (" + this.currency + ")");
        JOptionPane.showMessageDialog(null, "Transfer successful.");
        updateAmountInFile();
        generateReceipt("Transfer", amount);
    } else {
        if (this.currency.equalsIgnoreCase("PHP PESO") && receiverCurrency.equalsIgnoreCase("US DOLLAR")) {
            double convertedAmount = convertToUSD(amount);
            this.balance -= amount; 
            recordTransaction(amount, "Transfer to " + receiverAccountNumber + " (converted to USD)");
            updateReceiverAmountInFile(convertedAmount, receiverAccountNumber, "Received from " + this.accountNumber + " (" + this.currency + ")");
            JOptionPane.showMessageDialog(null, "Transfer successful.");
            updateAmountInFile();
            generateReceipt("Transfer", amount);
        } else if (this.currency.equalsIgnoreCase("US DOLLAR") && receiverCurrency.equalsIgnoreCase("PHP PESO")) {
            double convertedAmount = convertToPHP(amount);
            this.balance -= amount; // Deduct USD amount
            recordTransaction(amount, "Transfer to " + receiverAccountNumber + " (converted to PHP)");
            updateReceiverAmountInFile(convertedAmount, receiverAccountNumber, "Received from " + this.accountNumber + " (" + this.currency + ")");
            JOptionPane.showMessageDialog(null, "Transfer successful.");
            updateAmountInFile();
            generateReceipt("Transfer", amount);
        } else if (this.currency.equalsIgnoreCase("US DOLLAR") && receiverCurrency.equalsIgnoreCase("US DOLLAR")) {
            this.balance -= amount;
            recordTransaction(amount, "Transfer to " + receiverAccountNumber + " (" + this.currency + ")");
            updateReceiverAmountInFile(amount, receiverAccountNumber, "Received from " + this.accountNumber + " (" + this.currency + ")");
            JOptionPane.showMessageDialog(null, "Transfer successful.");
            updateAmountInFile();
            generateReceipt("Transfer", amount);
        } else {
            JOptionPane.showMessageDialog(null, "Invalid currency selection for the sender's account or receiver's account.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}


    
String getReceiverCurrency(String receiverAccountNumber) {
    String filePath = "src\\classes\\Database.txt";
    String currency = "";
    boolean foundAccountNumber = false;

    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.contains("Account Number") && line.contains(receiverAccountNumber)) {
                foundAccountNumber = true;
            }
            
            if (foundAccountNumber && line.contains("Currency")) {
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    currency = parts[1].trim();
                    break;
                }
            }
        }
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }

    return currency;
}

private double convertToUSD(double amount) {
    return amount * 0.02;
}

private double convertToPHP(double amount) {
    return amount * 50;
}

private void updateReceiverAmountInFile(double amount, String receiverAccountNumber, String senderInfo) {
    String receiverDatabasePath = "src\\classes\\Database.txt";
    String receiverTransactionFilePath = "src\\classes\\Transactions\\" + receiverAccountNumber + "_Transactions.txt";
    boolean receiverAccountFound = false;
    StringBuilder receiverUpdatedContent = new StringBuilder();

    try (BufferedReader receiverReader = new BufferedReader(new FileReader(receiverDatabasePath))) {
        String receiverLine;

        while ((receiverLine = receiverReader.readLine()) != null) {
            if (receiverLine.startsWith("Account Number: " + receiverAccountNumber)) {
                receiverUpdatedContent.append(receiverLine).append(System.lineSeparator());
                receiverAccountFound = true;
            } else if (receiverAccountFound && receiverLine.startsWith("Amount: ")) {
                String[] parts = receiverLine.split(": ");
                String amountStr = parts[1].trim().replace(",", ""); 
                double existingAmount = Double.parseDouble(amountStr);
                double newAmount = existingAmount + amount;
                receiverLine = "Amount: " + df.format(newAmount);
                receiverUpdatedContent.append(receiverLine).append(System.lineSeparator());
                receiverAccountFound = false;
            } else {
                receiverUpdatedContent.append(receiverLine).append(System.lineSeparator());
            }
        }

        try (BufferedWriter receiverWriter = new BufferedWriter(new FileWriter(receiverDatabasePath))) {
            receiverWriter.write(receiverUpdatedContent.toString());
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Failed to update amount for receiver's account.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        try (BufferedWriter receiverTransactionWriter = new BufferedWriter(new FileWriter(receiverTransactionFilePath, true))) {
            String timestamp = sdf.format(new Date());
            receiverTransactionWriter.write(timestamp + " - " + senderInfo + ": " + df.format(amount) + "\n");
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Failed to record transaction for receiver's account.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } catch (IOException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Failed to update receiver's account.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}
  
        private boolean isReceiverAccountValid(String receiverAccountNumber) {
        String filePath = "src\\classes\\Database.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Account Number: " + receiverAccountNumber)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public String getPin() {
    return this.pin;
}
  
    private void updatePinInFile(String newPIN) {
    String filePath = "src\\classes\\Database.txt";
    boolean accountFound = false;

    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
        String line;
        StringBuilder updatedContent = new StringBuilder();

        while ((line = reader.readLine()) != null) {
            if (line.startsWith("Account Number: " + accountNumber)) {
                updatedContent.append(line).append(System.lineSeparator());
                accountFound = true;
            } else if (accountFound && line.startsWith("PIN: ")) {
                line = "PIN: " + newPIN;
                updatedContent.append(line).append(System.lineSeparator());
                accountFound = false;
            } else {
                updatedContent.append(line).append(System.lineSeparator());
            }
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(updatedContent.toString());
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Failed to update PIN in your account.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } catch (IOException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Failed to update your account.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}

    
    public void updatePIN(String newPIN) {
    this.pin = newPIN;
    updatePinInFile(newPIN);
    recordTransaction(0, "Change PIN");
    generateReceipt("Change PIN", 0);
}

    private void generateReceipt(String type, double amount) {
    String receiptFolderPath = "src\\classes\\Receipts";
    File receiptFolder = new File(receiptFolderPath);
    
    if (!receiptFolder.exists()) {
        receiptFolder.mkdirs(); 
    }
    
    String receiptFilePath = receiptFolderPath + "\\Receipts_" + accountNumber + ".txt";
    
    String receiptContent = "\nIRIS BANK\n";
    receiptContent += "Transaction Record\n";
    receiptContent += "Date: " + sdf.format(new Date()) + "\n\n";
    receiptContent += "TRANSACTION\n";
    receiptContent += "-" + type.toUpperCase() + "\n\n";
    
    if (type.equalsIgnoreCase("change pin")) {
        receiptContent += "PIN CHANGE TRANSACTION\n";
    } else if (type.equalsIgnoreCase("deposit")) {
        receiptContent += "DEPOSIT TRANSACTION\n";
        receiptContent += "DEPOSITED AMOUNT:  " + df.format(amount) + "\n";
    } else if (type.equalsIgnoreCase("fastcash")) {
        receiptContent += "FAST CASH TRANSACTION\n";
        receiptContent += "WITHDRAWN AMOUNT:  " + df.format(amount) + "\n";
    } else if (type.toLowerCase().startsWith("transfer")) {
        receiptContent += "TRANSFER TRANSACTION\n";
        receiptContent += "TRANSFERRED AMOUNT:  " + df.format(amount) + "\n";
    } else {
        receiptContent += "WITHDRAWAL TRANSACTION\n";
        receiptContent += "WITHDRAWN AMOUNT:  " + df.format(amount) + "\n";
    }
    
    receiptContent += "CURRENT BALANCE : " + df.format(balance) + "\n";
    receiptContent += "AVAILABLE BALANCE: " + df.format(balance) + "\n\n";
    receiptContent += "TRACE NUMBER: " + generateTraceNumber() + "\n";
    receiptContent += "TRANSACTION COMPLETE\n";

    try (BufferedWriter writer = new BufferedWriter(new FileWriter(receiptFilePath, true))) {
        writer.write(receiptContent);
        JOptionPane.showMessageDialog(null, "Receipt generated successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
    } catch (IOException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Failed to generate receipt.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}

private String generateTraceNumber() {
    return String.format("%06d", (int) (Math.random() * 1000000));
}

public void generateMonthlyReport() {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(new Date());
    int year = calendar.get(Calendar.YEAR);
    int month = calendar.get(Calendar.MONTH) + 1; 

    StringBuilder reportContent = new StringBuilder();
    reportContent.append("Monthly Report: ").append(dateFormat.format(calendar.getTime())).append("\n");

    Map<String, List<String>> monthlyTransactions = new HashMap<>();
    monthlyTransactions.put("Withdrawal", new ArrayList<>());
    monthlyTransactions.put("Deposit", new ArrayList<>());
    monthlyTransactions.put("FastCash", new ArrayList<>());
    monthlyTransactions.put("Transfer", new ArrayList<>());
    monthlyTransactions.put("Change PIN", new ArrayList<>());

    File transactionFolder = new File("src\\classes\\Transactions");
    File[] transactionFiles = transactionFolder.listFiles();
    if (transactionFiles != null) {
        for (File file : transactionFiles) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    for (String type : monthlyTransactions.keySet()) {
                        if (line.contains(type)) {
                            monthlyTransactions.get(type).add(line); 
                            break;
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
                System.err.println("Failed to read transaction file: " + file.getName());
            }
        }
    }

    for (Map.Entry<String, List<String>> entry : monthlyTransactions.entrySet()) {
        String type = entry.getKey();
        List<String> transactions = entry.getValue();
        reportContent.append(type).append(" Transactions:\n");
        for (String transaction : transactions) {
            reportContent.append(transaction).append("\n");
        }
        reportContent.append("\n");
    }

    String reportFileName = "Monthly_Report_" + year + "_" + month + ".txt";
    String reportFilePath = "src\\classes\\Reports\\" + reportFileName;
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(reportFilePath))) {
        writer.write(reportContent.toString());
    } catch (IOException e) {
        e.printStackTrace();
    }
}

private void generateMonthlyReportIfSpecificDay(int specificDay) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(new Date());

    if (calendar.get(Calendar.DATE) == specificDay) {
        generateMonthlyReport();
    }
}

public void generateWeeklyReport() {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(new Date());
    int year = calendar.get(Calendar.YEAR);
    int weekOfYear = calendar.get(Calendar.WEEK_OF_YEAR);

    StringBuilder reportContent = new StringBuilder();
    reportContent.append("Weekly Report: ").append(year).append(" - Week ").append(weekOfYear).append("\n");

    Map<String, List<String>> weeklyTransactions = new HashMap<>();
    weeklyTransactions.put("Withdrawal", new ArrayList<>());
    weeklyTransactions.put("Deposit", new ArrayList<>());
    weeklyTransactions.put("FastCash", new ArrayList<>());
    weeklyTransactions.put("Transfer", new ArrayList<>());
    weeklyTransactions.put("Change PIN", new ArrayList<>());

    File transactionFolder = new File("src\\classes\\Transactions");
    File[] transactionFiles = transactionFolder.listFiles();
    if (transactionFiles != null) {
        for (File file : transactionFiles) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    for (String type : weeklyTransactions.keySet()) {
                        if (line.contains(type)) {
                            weeklyTransactions.get(type).add(line);
                            break;
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
                System.err.println("Failed to read transaction file: " + file.getName());
            }
        }
    }

    for (Map.Entry<String, List<String>> entry : weeklyTransactions.entrySet()) {
        String type = entry.getKey();
        List<String> transactions = entry.getValue();
        reportContent.append(type).append(" Transactions:\n");
        for (String transaction : transactions) {
            reportContent.append(transaction).append("\n");
        }
        reportContent.append("\n");
    }

    String reportFileName = "Weekly_Report_" + year + "_Week_" + weekOfYear + ".txt";
    String reportFilePath = "src\\classes\\Reports\\" + reportFileName;
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(reportFilePath))) {
        writer.write(reportContent.toString());
    } catch (IOException e) {
        e.printStackTrace();
    }
}


private void generateWeeklyReportIfSpecificDay() {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(new Date());

    if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY) {
        generateWeeklyReport();
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

        fastCashBTN = new javax.swing.JButton();
        chackBalanceBTN = new javax.swing.JButton();
        depositBTN = new javax.swing.JButton();
        withdrawBTN = new javax.swing.JButton();
        transferBTN = new javax.swing.JButton();
        changePinBTN = new javax.swing.JButton();
        exitBTN = new javax.swing.JButton();
        developerBTN1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(null);

        fastCashBTN.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 36)); // NOI18N
        fastCashBTN.setForeground(new java.awt.Color(2, 12, 66));
        fastCashBTN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fcIcon.png"))); // NOI18N
        fastCashBTN.setText(" Fast Cash");
        fastCashBTN.setBorder(null);
        fastCashBTN.setMaximumSize(new java.awt.Dimension(190, 60));
        fastCashBTN.setMinimumSize(new java.awt.Dimension(190, 60));
        fastCashBTN.setPreferredSize(new java.awt.Dimension(190, 60));
        fastCashBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fastCashBTNActionPerformed(evt);
            }
        });
        getContentPane().add(fastCashBTN);
        fastCashBTN.setBounds(970, 100, 270, 90);

        chackBalanceBTN.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 28)); // NOI18N
        chackBalanceBTN.setForeground(new java.awt.Color(2, 12, 66));
        chackBalanceBTN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cbIcon.png"))); // NOI18N
        chackBalanceBTN.setText(" Check Balance");
        chackBalanceBTN.setBorder(null);
        chackBalanceBTN.setMaximumSize(new java.awt.Dimension(190, 60));
        chackBalanceBTN.setMinimumSize(new java.awt.Dimension(190, 60));
        chackBalanceBTN.setPreferredSize(new java.awt.Dimension(190, 60));
        chackBalanceBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chackBalanceBTNActionPerformed(evt);
            }
        });
        getContentPane().add(chackBalanceBTN);
        chackBalanceBTN.setBounds(670, 100, 270, 90);

        depositBTN.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 36)); // NOI18N
        depositBTN.setForeground(new java.awt.Color(2, 12, 66));
        depositBTN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/depIcon.png"))); // NOI18N
        depositBTN.setText(" Deposit");
        depositBTN.setBorder(null);
        depositBTN.setMaximumSize(new java.awt.Dimension(190, 60));
        depositBTN.setMinimumSize(new java.awt.Dimension(190, 60));
        depositBTN.setPreferredSize(new java.awt.Dimension(190, 60));
        depositBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                depositBTNActionPerformed(evt);
            }
        });
        getContentPane().add(depositBTN);
        depositBTN.setBounds(970, 210, 270, 90);

        withdrawBTN.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 36)); // NOI18N
        withdrawBTN.setForeground(new java.awt.Color(2, 12, 66));
        withdrawBTN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/wIcon.png"))); // NOI18N
        withdrawBTN.setText(" Withdraw");
        withdrawBTN.setBorder(null);
        withdrawBTN.setMaximumSize(new java.awt.Dimension(190, 60));
        withdrawBTN.setMinimumSize(new java.awt.Dimension(190, 60));
        withdrawBTN.setPreferredSize(new java.awt.Dimension(190, 60));
        withdrawBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                withdrawBTNActionPerformed(evt);
            }
        });
        getContentPane().add(withdrawBTN);
        withdrawBTN.setBounds(670, 210, 270, 90);

        transferBTN.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 36)); // NOI18N
        transferBTN.setForeground(new java.awt.Color(2, 12, 66));
        transferBTN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/transferIcon.png"))); // NOI18N
        transferBTN.setText(" Tranfer");
        transferBTN.setBorder(null);
        transferBTN.setMaximumSize(new java.awt.Dimension(190, 60));
        transferBTN.setMinimumSize(new java.awt.Dimension(190, 60));
        transferBTN.setPreferredSize(new java.awt.Dimension(190, 60));
        transferBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transferBTNActionPerformed(evt);
            }
        });
        getContentPane().add(transferBTN);
        transferBTN.setBounds(970, 330, 270, 90);

        changePinBTN.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 30)); // NOI18N
        changePinBTN.setForeground(new java.awt.Color(2, 12, 66));
        changePinBTN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pinIcon.png"))); // NOI18N
        changePinBTN.setText(" Change PIN");
        changePinBTN.setBorder(null);
        changePinBTN.setMaximumSize(new java.awt.Dimension(190, 60));
        changePinBTN.setMinimumSize(new java.awt.Dimension(190, 60));
        changePinBTN.setPreferredSize(new java.awt.Dimension(190, 60));
        changePinBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changePinBTNActionPerformed(evt);
            }
        });
        getContentPane().add(changePinBTN);
        changePinBTN.setBounds(670, 330, 270, 90);

        exitBTN.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 36)); // NOI18N
        exitBTN.setForeground(new java.awt.Color(2, 12, 66));
        exitBTN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/backIcon.png"))); // NOI18N
        exitBTN.setText("Exit");
        exitBTN.setBorder(null);
        exitBTN.setVerifyInputWhenFocusTarget(false);
        exitBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitBTNActionPerformed(evt);
            }
        });
        getContentPane().add(exitBTN);
        exitBTN.setBounds(1070, 620, 170, 60);

        developerBTN1.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 36)); // NOI18N
        developerBTN1.setForeground(new java.awt.Color(2, 12, 66));
        developerBTN1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/devIcon.png"))); // NOI18N
        developerBTN1.setText(" Developer");
        developerBTN1.setBorder(null);
        developerBTN1.setMaximumSize(new java.awt.Dimension(190, 60));
        developerBTN1.setMinimumSize(new java.awt.Dimension(190, 60));
        developerBTN1.setPreferredSize(new java.awt.Dimension(190, 60));
        developerBTN1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                developerBTN1ActionPerformed(evt);
            }
        });
        getContentPane().add(developerBTN1);
        developerBTN1.setBounds(820, 450, 270, 90);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mainApp.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, -10, 1540, 790);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void transferBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transferBTNActionPerformed
        // TODO add your handling code here:
        new Transfer(MainApp.this).setVisible(true);        
    }//GEN-LAST:event_transferBTNActionPerformed

    private void fastCashBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fastCashBTNActionPerformed
        // TODO add your handling code here:
        new FastCash(MainApp.this).setVisible(true);
    }//GEN-LAST:event_fastCashBTNActionPerformed

    private void chackBalanceBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chackBalanceBTNActionPerformed
        // TODO add your handling code here:
        new CheckBalance(MainApp.this).setVisible(true);
    }//GEN-LAST:event_chackBalanceBTNActionPerformed

    private void withdrawBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_withdrawBTNActionPerformed
        // TODO add your handling code here:
        new Withdraw(MainApp.this).setVisible(true);
    }//GEN-LAST:event_withdrawBTNActionPerformed

    private void depositBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_depositBTNActionPerformed
        // TODO add your handling code here:
        new Deposit(MainApp.this).setVisible(true);
    }//GEN-LAST:event_depositBTNActionPerformed

    private void changePinBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changePinBTNActionPerformed
        // TODO add your handling code here:
        new ChangePIN(MainApp.this).setVisible(true);
    }//GEN-LAST:event_changePinBTNActionPerformed

    private void exitBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitBTNActionPerformed
        // TODO add your handling code here:
        dispose();
        login.setVisible(true);
    }//GEN-LAST:event_exitBTNActionPerformed

    private void developerBTN1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_developerBTN1ActionPerformed
        // TODO add your handling code here:
        new About(MainApp.this).setVisible(true);
    }//GEN-LAST:event_developerBTN1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
       
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton chackBalanceBTN;
    private javax.swing.JButton changePinBTN;
    private javax.swing.JButton depositBTN;
    private javax.swing.JButton developerBTN1;
    private javax.swing.JButton exitBTN;
    private javax.swing.JButton fastCashBTN;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton transferBTN;
    private javax.swing.JButton withdrawBTN;
    // End of variables declaration//GEN-END:variables

}
