package Package_Six;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Middleman_Runner implements Runnable {

    Socket s;
    ServerSocket ss;

    public Middleman_Runner(Socket socket, ServerSocket serve_sock){
        this.s = socket;
        this.ss = serve_sock;
    }

    public void run(){
        try{
            Socket incoming = ss.accept();
            Scanner scan = new Scanner(incoming.getInputStream());
            PrintWriter printer = new PrintWriter(s.getOutputStream(), true);
            String message = "";
            while(!message.equals("close")){
                message = scan.nextLine();
                System.out.println("Message to be sent to receiver: " + message);
                printer.println();
            }
        }
        catch(IOException iex){
            iex.printStackTrace();
        }
    }
}
