package classes;

import classes.CreateAccount;
import classes.Intro;
import classes.Login;
import classes.MainApp;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author admin
 */
public class Accounts {
    public static String[] readAccountAndPIN(String accountNumber) {
    String filePath = "src\\classes\\Database.txt";
    String line;
    String[] accountAndPIN = null;
    boolean foundAccountNumber = false;
    
    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
        while ((line = reader.readLine()) != null) {
            
            if (line.contains("Account Number") && line.contains(accountNumber)) {
                foundAccountNumber = true;
            }
            
            if (foundAccountNumber && line.contains("PIN")) {
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    accountAndPIN = new String[]{accountNumber, parts[1].trim()};
                    break;
                }
            }
        }
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
    
    return accountAndPIN;
}
      
public static double readAmount(String accountNumber) {
    String filePath = "src\\classes\\Database.txt";
    String line;
    double amount = 0;
    boolean foundAccountNumber = false;

    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
        while ((line = reader.readLine()) != null) {
            if (line.contains("Account Number") && line.contains(accountNumber)) {
                foundAccountNumber = true;
            }

            if (foundAccountNumber && line.contains("Amount")) {
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    String amountString = parts[1].trim().replaceAll(",", "");
                    amount = Double.parseDouble(amountString);
                    break;
                }
            }
        }
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }

    return amount;
}

    public static String readCurrency(String accountNumber) {
        String filePath = "src\\classes\\Database.txt";
        String line;
        String currency = "";
        boolean foundAccountNumber = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            while ((line = reader.readLine()) != null) {
                if (line.contains("Account Number") && line.contains(accountNumber)) {
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
}

