import java.io.*;
import java.net.*;

public class Client {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 1234);

            PrintWriter out = new PrintWriter(
                    socket.getOutputStream(), true);

            BufferedReader keyboard = new BufferedReader(
                    new InputStreamReader(System.in));

            System.out.println("Connected to server. Type message:");

            String msg;
            while ((msg = keyboard.readLine()) != null) {
                out.println(msg);
            }

        } catch (Exception e) {
            System.out.println("Client error");
        }
    }
}
