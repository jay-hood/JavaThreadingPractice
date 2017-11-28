package Package_Six;

import java.io.IOException;

public class Client {
    public static void main(String[] args) {
        try {
            Server receiver = new Server(6003, "receiver");
            //Server router_four = new Server(6004, 6005, 4);
            //Server router_three = new Server(6003, 6004);
            //Server router_one = new Sever(6001, 6002);
            Server router_two = new Server(6002, 6003);
            Server sender = new Server(6002, "sender");
            receiver.receiver_thread();
            router_two.middleman_thread();
            sender.sender_thread();
        }
        catch(IOException iex){
            iex.printStackTrace();
        }
    }
}
