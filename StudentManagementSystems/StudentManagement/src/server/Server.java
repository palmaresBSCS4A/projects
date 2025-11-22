package server;
import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            System.out.println("Server is listening on port 12345...");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected.");

                ClientHandler clientHandler = new ClientHandler(socket);
                Thread clientThread = new Thread(clientHandler);
                clientThread.start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
        ) {
            String inputLine;
            while ((inputLine = reader.readLine()) != null) {
                System.out.println("Received: " + inputLine);

                // Handle SEARCH command
                if (inputLine.startsWith("SEARCH:")) {
                    String searchQuery = inputLine.substring(7);
                    System.out.println("Processing search for: " + searchQuery);
                    String response = "Search result for: " + searchQuery;
                    writer.println(response); 

                }
                // Handle UPDATE command
                else if (inputLine.startsWith("UPDATE:")) {
                    String updateData = inputLine.substring(7);
                    System.out.println("Processing update for: " + updateData);
                    writer.println("Update command received for ID: " + updateData);

                }
                // Handle GWA command
                else if (inputLine.startsWith("GWA:")) {
                    String gwaResult = inputLine.substring(4); 
                    System.out.println("Processing GWA: " + gwaResult);
                    writer.println("GWA result received: " + gwaResult); 
                }
                else if (inputLine.startsWith("GRADESAVE:")) {
                    String gradeData = inputLine.substring(10);
                    System.out.println("Processing grade save data: " + gradeData);

                    writer.println("Grade save successful for: " + gradeData);
                }
                else if (inputLine.startsWith("PRINTREQUEST:")) {
                    String printInfo = inputLine.substring(13); 
                    System.out.println("Processing print request for: " + printInfo);

                    writer.println("Print request received for: " + printInfo);
                }
                else if (inputLine.startsWith("COURSESEARCH:")) {
                    String courseQuery = inputLine.substring(13);
                    System.out.println("Processing course search for: " + courseQuery);

                    writer.println("Course search result for: " + courseQuery);
                }
                else if (inputLine.startsWith("COURSESAVE:")) {
                    String courseData = inputLine.substring(11);  // Get data after "COURSESAVE:"
                    System.out.println("Processing course save: " + courseData);

                    writer.println("Course save received: " + courseData);
                }
                else if (inputLine.startsWith("DROPCOURSE:")) {
                    String dropCourse = inputLine.substring(13);
                    System.out.println("Processing course drop: " + dropCourse);

                    writer.println("Course update received: " + dropCourse);
                }
                else if (inputLine.startsWith("COURSEDELETE:")) {
                    String studentID = inputLine.substring(13);
                    System.out.println("Processing course deletion for student ID: " + studentID);

                    writer.println("Course delete command received for student ID: " + studentID);
                }  
                else if (inputLine.equals("ADD_STUDENT")) {
                String studentId = reader.readLine(); 
                System.out.println("Processing ADD_STUDENT for ID: " + studentId);
                
                writer.println("Student saved successfully!");
                }
                else if (inputLine.startsWith("DELETE_STUDENT:")) {
                String studentID = inputLine.substring("DELETE_STUDENT:".length());
                System.out.println("Processing DELETE_STUDENT for ID: " + studentID);

                writer.println("Delete command received for ID: " + studentID);
                }
                else if (inputLine.startsWith("COURSEDROP:")) {
                String dropCourse = inputLine.substring(11);
                System.out.println("Processing course drop for student ID: " + dropCourse);

                writer.println("Course drop command received for student ID: " + dropCourse);
                }
                else if (inputLine.startsWith("GRADEUPDATE:")) {
                String studentID = inputLine.substring("GRADEUPDATE:".length());
                System.out.println("Processing grade update for student ID: " + studentID);

                writer.println("SUCCESS"); 
                }
                else if (inputLine.startsWith("GRADESEARCH:")) {
                String studentID = inputLine.substring(12);
                System.out.println("Processing grade search for student ID: " + studentID);

                writer.println("Grade search result for student ID: " + studentID);
                }
                else if (inputLine.startsWith("GRADESAVE:")) {
                String studentID = inputLine.substring(10); 
                System.out.println("Processing grade save for student ID: " + studentID);

                writer.println("Grade save successful for student ID: " + studentID);  
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();  
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
