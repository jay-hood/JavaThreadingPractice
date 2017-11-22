package Package_One;

public class PrintThread {
    public static void main(String[] args) {

        PrintRun print = new PrintRun();
        Thread t = new Thread(print);
        t.start();
    }
}


