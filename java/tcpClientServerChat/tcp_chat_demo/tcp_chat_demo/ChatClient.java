package tcpClientServerChat.tcp_chat_demo.tcp_chat_demo;
import java.io.*;
import java.net.*;

public class ChatClient {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 5000;

        try (Socket socket = new Socket(host, port)) {
            System.out.println("Connected to server.");

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

            String userMsg, serverReply;

            while (true) {
                System.out.print("You: ");
                userMsg = consoleReader.readLine();
                writer.println(userMsg);

                if (userMsg.equalsIgnoreCase("exit")) {
                    break;
                }

                serverReply = reader.readLine();
                if (serverReply == null) {
                    break;
                }

                System.out.println("Server: " + serverReply);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
