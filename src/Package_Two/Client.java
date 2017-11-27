package Package_Two;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        InetAddress host = InetAddress.getLocalHost();

        TCPServer newServer = new TCPServer(5001);
        Thread thread = new Thread(newServer);
        thread.start();

        Socket socket = new Socket(host,5001);
        String message = "First";
        Scanner scan = new Scanner(System.in);
        PrintWriter printer = new PrintWriter(socket.getOutputStream());
        while(!message.equals("close")) {
            System.out.println("Enter message");
            message = scan.nextLine();
            printer.println(message);
        }
        socket.close();


    }
}
