package Package_One;

public class PrintRun implements Runnable {

    public PrintRun(){

    }

    public void run(){
        System.out.println("Printing in new thread.");
    }

}