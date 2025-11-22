/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.io.*;
import java.net.*;
/**
 *
 * @author MARY ANGEL
 */
public class Server {
    public static void main(String[] args) {
        final int PORT = 1234;

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is running on port " + PORT + "...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getInetAddress());

                ClientHandler handler = new ClientHandler(clientSocket);
                Thread thread = new Thread(handler);
                thread.start();
            }

        } catch (IOException e) {
            System.err.println("Error in server: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
