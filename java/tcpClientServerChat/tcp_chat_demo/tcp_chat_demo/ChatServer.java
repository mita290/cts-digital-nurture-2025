package tcpClientServerChat.tcp_chat_demo.tcp_chat_demo;
import java.io.*;
import java.net.*;

public class ChatServer {
    public static void main(String[] args) {
        int port = 5000;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server started. Waiting for a client...");

            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected!");

            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);

            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

            String clientMsg, serverMsg;

            while (true) {
                clientMsg = reader.readLine();
                if (clientMsg == null || clientMsg.equalsIgnoreCase("exit")) {
                    System.out.println("Client disconnected.");
                    break;
                }

                System.out.println("Client: " + clientMsg);

                System.out.print("Server: ");
                serverMsg = consoleReader.readLine();
                writer.println(serverMsg);
            }

            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
