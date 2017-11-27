package Package_Six;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Sender_Runner implements Runnable{

    private Socket sock;

    public Sender_Runner(Socket s){
        this.sock = s;
    }

    public void run(){

        try{
            Scanner scan = new Scanner(System.in);
            PrintWriter print = new PrintWriter(sock.getOutputStream(), true);
            String message = "";
            while(!message.equals("close")){
                System.out.println("Enter message: ");
                message = scan.nextLine();
                print.println(message);
            }
            sock.close();
        }
        catch(IOException iex){
            iex.printStackTrace();
        }
    }
}
