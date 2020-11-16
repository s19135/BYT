package template;

public class MondayBreakfast extends Breakfast {

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
        System.out.println("Making a coffee");
    }

    @Override
    void makeTea() {

    }

    @Override
    void addSausage() {
        System.out.println("Adding the sausage to the sandwich");
    }

    @Override
    void addCheese() {
        System.out.println("Adding the cheese to the sandwich");
    }
}
