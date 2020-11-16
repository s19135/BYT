package template;

public class TuesdayBreakfast extends Breakfast {

    boolean youAreSleppy(){
        return false;
    }
    boolean haveSausage(){
        return false;
    }

    @Override
    public void boilWater() {
        super.boilWater();
    }

    @Override
    public void makeSandwich() {
        super.makeSandwich();
    }

    @Override
    void makeCoffee() {

    }

    @Override
    void makeTea() {
        System.out.println("Making a tea");
    }

    @Override
    void addSausage() {
    }

    @Override
    void addCheese() {
        System.out.println("Adding the cheese");
    }
}
