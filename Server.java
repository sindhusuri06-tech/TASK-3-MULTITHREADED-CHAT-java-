import java.io.*;
import java.net.*;

public class Server {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(1234);
            System.out.println("Server started... Waiting for clients");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected");

                ClientHandler handler = new ClientHandler(socket);
                handler.start();   // new thread
            }

        } catch (Exception e) {
            System.out.println("Server error");
        }
    }
}

// Thread class
class ClientHandler extends Thread {
    Socket socket;

    ClientHandler(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            String msg;
            while ((msg = in.readLine()) != null) {
                System.out.println("Client: " + msg);
            }

        } catch (Exception e) {
            System.out.println("Client disconnected");
        }
    }
}
