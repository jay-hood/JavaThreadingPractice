package Package_Two;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TCPServer implements Runnable{
    private InetAddress host;
    private int out_port;
    private int in_port;
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
            String message = "";
            while(!message.equals("close")){
                message = scan.nextLine();
                System.out.println("Received message: " + message);
            }
            socket.close();
        }
        catch(IOException iex){
            iex.printStackTrace();
        }


    }
    /*
    public TCPServer(int port, String servertype) throws IOException{//Constructor for sender or receiver
        if(servertype.equals("sender")) {
            this.out_port = port;
            this.host = InetAddress.getLocalHost();
            this.socket = new Socket(host, out_port);
        }
        else if(servertype.equals("receiver")){
            this.in_port = port;
            this.serverSocket = new ServerSocket(in_port);
        }
        else{
            System.out.println("Invalid server type.");
            System.exit(0);
        }

    }

    public TCPServer(int out_port, int in_port) throws IOException{//Constructor for middleman server
        this.in_port = in_port;
        this.out_port = out_port;
        this.host = InetAddress.getLocalHost();
        this.socket = new Socket(host, out_port);
        this.serverSocket = new ServerSocket(in_port);
    }*/




}
