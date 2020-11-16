package template;

public abstract class Breakfast {

    final void makeBreakfast(){

        boilWater();

        if(youAreSleppy()){
            makeCoffee();
        }else {
            makeTea();
        }

        makeSandwich();

        if(haveSausage()){
            addSausage();
        }
        if(haveCheese()){
            addCheese();
        }
    }

    public void boilWater(){
        System.out.println("The water boils...");
    }
    public void makeSandwich(){
        System.out.println("Making sandwich...");
    }

    abstract void makeCoffee();
    abstract void makeTea();
    abstract void addSausage();
    abstract void addCheese();

    boolean youAreSleppy(){
        return true;
    }
    boolean haveSausage(){
        return true;
    }
    boolean haveCheese(){
        return true;
    }


}
