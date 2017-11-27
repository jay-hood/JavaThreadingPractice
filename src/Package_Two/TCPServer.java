package Package_Two;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TCPServer implements Runnable{
    private Socket socket;
    private ServerSocket serverSocket;



    public TCPServer(int port) throws IOException{
        this.serverSocket = new ServerSocket(port);
    }

    @Override
    public void run(){
        try {
            this.socket = serverSocket.accept();
            System.out.println("Connection established!");
            Scanner scan = new Scanner(socket.getInputStream());

            String incoming_message = "";
            while(!incoming_message.equals("close")){
                incoming_message = scan.nextLine();
                System.out.println("Received message: " + incoming_message);
            }
            socket.close();
        }
        catch(IOException iex){
            iex.printStackTrace();
        }


    }




}
