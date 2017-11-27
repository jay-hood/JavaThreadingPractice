package Package_Four;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server implements Runnable{
    ServerSocket ssocket;
    int port;

    public Server(int port) throws IOException{
        this.port = port;
        ssocket = new ServerSocket(port);
    }

    @Override
    public void run(){
        try {
            System.out.println("Waiting on connection.");
            Socket socket = ssocket.accept();
            System.out.println("Connection established.");
            Scanner scan = new Scanner(socket.getInputStream());
            System.out.println("Scanner active and waiting.");
            String message;
            message = scan.nextLine();
            System.out.println(message);
        }
        catch(IOException iex){
            iex.printStackTrace();
        }


    }

}
