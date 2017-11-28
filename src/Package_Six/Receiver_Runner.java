package Package_Six;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Receiver_Runner implements Runnable {

    ServerSocket ss;

    public Receiver_Runner(ServerSocket serve_sock){
        this.ss = serve_sock;
    }

    public void run(){

        try{
            Socket socket = ss.accept();
            Scanner scan = new Scanner(socket.getInputStream());
            String message = "";
            while(!message.equals("close")){
                message = scan.nextLine();
                System.out.println("Message from sender: "+message);
                System.out.println("Enter message: ");
            }
        }
        catch(IOException iex){
            iex.printStackTrace();
        }

    }
}
