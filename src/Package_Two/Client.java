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
        String outgoing_message = "";
        Scanner scan = new Scanner(System.in);
        PrintWriter printer = new PrintWriter(socket.getOutputStream(), true);//have to have true for autoflush
        System.out.println("Enter message: ");
        while(!outgoing_message.equals("fish")) {
            outgoing_message = scan.nextLine();
            printer.println(outgoing_message);
            System.out.println("Enter message: ");
        }
        socket.close();


    }
}
