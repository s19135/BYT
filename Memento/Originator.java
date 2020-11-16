public class Originator {
    private String state;

    public void setState(String newState) {

        System.out.println("Current version of state: " + newState);

        this.state = newState;
    }

    public String getState() {
        return state;
    }

    public Memento saveState() {

        System.out.println("Saving to Memento");

        return new Memento(state);
    }

    public String restoreState(Memento memento) {

        this.state = memento.getState();

        System.out.println("Previous state saved in Memento: " + state);

        return state;

    }
}
