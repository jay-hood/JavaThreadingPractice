package Package_Four;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            Server server = new Server(5005);
            Thread thread = new Thread(server);
            thread.start();
            InetAddress host = InetAddress.getLocalHost();
            Socket sock = new Socket(host,5005);
            PrintWriter print = new PrintWriter(sock.getOutputStream());
            String message = "Test message.";
            System.out.println("Sending message.");
            print.println(message);
        }
        catch(IOException iex){
            iex.printStackTrace();
        }


    }
}
