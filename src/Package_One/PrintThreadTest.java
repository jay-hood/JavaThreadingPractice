package Package_One;

public class PrintThreadTest {
    public static void main(String[] args) {

        PrintRunner pr = new PrintRunner();
        Thread thread = new Thread(pr);

        thread.start();
    }
}
