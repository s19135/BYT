package template2;

public class Apple extends Phones{
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
        System.out.println("Getting rid of everything but phone");
    }

    @Override
    void makeALaggingPhone() {

    }

    @Override
    boolean youAreApple() {
        return super.youAreApple();
    }
}
