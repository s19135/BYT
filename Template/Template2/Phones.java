package template2;

public abstract class Phones {
    final void makePhone(){

        developPhone();

        if (youAreApple()){
            setTheHighestPrice();
            getRidOfEverythingButPhone();

        }else{
            setTheHighestPrice();
            makeALaggingPhone();
        }
    }

    public void developPhone(){
        System.out.println("Developing the phone");
    }

    abstract void setTheHighestPrice();
    abstract void getRidOfEverythingButPhone();
    abstract void makeALaggingPhone();

    boolean youAreApple(){
        return true;
    }
}
