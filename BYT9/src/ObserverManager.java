import java.io.IOException;
import java.util.ArrayList;

public class ObserverManager {

    private ArrayList<ModificationObserver> observers;
    private int period;

    private static ObserverManager INSTANCE = new ObserverManager();

    public static ObserverManager getInstance() { return INSTANCE; }

    public void attach(ModificationObserver observer, int period) {
        observers = new ArrayList<>();
        observers.add(observer);

        this.period = period;
    }

    public void observeAll() throws InterruptedException, IOException {
        for (ModificationObserver observer : observers) {
            observer.observe();
        }

        Thread.sleep(period);
    }

    public ArrayList<ModificationObserver> getObservers() {
        return observers;
    }

}
