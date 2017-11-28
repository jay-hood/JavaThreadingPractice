package Package_Six;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private Socket socket;
    private ServerSocket server_socket;
    private InetAddress host;
    private int port;

    //Constructor for sender/receiver - only takes a port as a parameter and creates a socket or server socket that listens on it.
    public Server(int port, String server_type) throws IOException {
        String temp = server_type.toLowerCase();
        if (temp.equals("sender")){
            this.host = InetAddress.getLocalHost();
            this.socket = new Socket(host, port);
        }
        else if(temp.equals("receiver")){
            this.server_socket = new ServerSocket(port);
        }
        else{
            System.out.println("Incorrect server type entered.");
            System.exit(1);
        }
    }

    public Server(int in_port, int out_port) throws IOException{
        this.host = InetAddress.getLocalHost();
        this.server_socket = new ServerSocket(in_port);
        this.socket = new Socket(host, out_port);
    }

    public void sender_thread(){
        Sender_Runner send = new Sender_Runner(socket);
        Thread thread = new Thread(send);
        thread.start();
    }

    public void receiver_thread(){
        Receiver_Runner receive = new Receiver_Runner(server_socket);
        Thread thread = new Thread(receive);
        thread.start();
    }

    public void middleman_thread(){
        Middleman_Runner middle = new Middleman_Runner(socket, server_socket);
        Thread thread = new Thread(middle);
        thread.start();
    }


}
