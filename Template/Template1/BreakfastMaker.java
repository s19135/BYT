package template;

public class BreakfastMaker {

    public static void main(String[] args) {
        Breakfast mondayBreakfast = new MondayBreakfast();
        mondayBreakfast.makeBreakfast();

        System.out.println();

        Breakfast tuesdayBreakfast = new TuesdayBreakfast();
        tuesdayBreakfast.makeBreakfast();
    }
}
