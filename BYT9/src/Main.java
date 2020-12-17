import java.io.IOException;
import java.net.URL;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

        ModificationObserver pjatk = new ModificationObserver(new URL("https://www.pja.edu.pl"));

        ObserverManager manager = ObserverManager.getInstance();
        manager.attach(pjatk, 1000);

        while (true) {
            manager.observeAll();
        }

    }

}
