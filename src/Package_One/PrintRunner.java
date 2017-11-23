package Package_One;

public class PrintRunner implements Runnable {

    public PrintRunner(){

    }

    @Override
    public void run() {
        System.out.println("Testing run method");
    }
}
