package Package_Six;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Sender_Runner implements Runnable{

    private Socket sock;

    public Sender_Runner(Socket s){
        this.sock = s;
    }

    public void run(){

        try{
            Scanner user_input = new Scanner(System.in);
            Scanner ack_input = new Scanner(sock.getInputStream());
            PrintWriter print = new PrintWriter(sock.getOutputStream(), true);
            String message = "";
            System.out.println("Enter message: ");
            while(!message.equals("close")){
                message = user_input.nextLine();
                print.println(message);
            }
            sock.close();
        }
        catch(IOException iex){
            iex.printStackTrace();
        }
    }
}
