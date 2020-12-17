import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

public class ModificationObserver {

    private URL address;
    private URLConnection connection;
    private long lastModified;

    public ModificationObserver(ModificationObserver other) {
        this.address = other.address;
        this.connection = other.connection;
        this.lastModified = other.lastModified;
    }

    public ModificationObserver(URL url) throws IOException {
        this.address = url;
        this.connection = url.openConnection();
        this.lastModified = connection.getLastModified();
    }

    public void observe() throws IOException {
        this.connection = address.openConnection();
        long newLastModified = connection.getLastModified();

        if (newLastModified != lastModified) {
            showChange(lastModified, newLastModified);
            lastModified = newLastModified;
        }
    }

    private void showChange(long oldDate_l, long newDate_l) {
        Date oldDate = new Date(oldDate_l);
        Date newDate = new Date(newDate_l);

        System.out.println("Change in " + address + ":\n last date: " + oldDate + "\n new date: " + newDate + "\n");
    }

    @Override
    public String toString() {
        return "Address: " + address + ", last modified: " + new Date(lastModified);
    }
}
