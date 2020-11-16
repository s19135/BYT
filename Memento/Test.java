import java.util.Currency;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
    Originator originator = new Originator();
    Caretaker caretaker = new Caretaker();

    originator.setState("Hello");
    System.out.println("Current state: " + originator.getState());
    caretaker.setMemento(originator.saveState());

    originator.setState("Hello, World!");
    System.out.println("Current state: " + originator.getState());

    originator.restoreState(caretaker.getMemento());
    System.out.println("State is " + originator.getState());

    }
}
