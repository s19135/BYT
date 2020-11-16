package template2;

public class Samsung extends Phones{
    @Override
    public void developPhone() {
        super.developPhone();
    }

    @Override
    void setTheHighestPrice() {
        System.out.println("Setting the highest price on the market");
    }

    @Override
    void getRidOfEverythingButPhone() {
    }

    @Override
    void makeALaggingPhone() {
        System.out.println("Making a lagging phone");
    }

    @Override
    boolean youAreApple() {
        return false;
    }
}
