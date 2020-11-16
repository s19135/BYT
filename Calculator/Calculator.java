public class Calculator {

    private static int num1 = 10;
    private static int num2 = 2;

    public static void main(String[] args) {
        calculate(num1, num2,"multiply");
    }

    private static void calculate(int num1, int num2, String operationReq){

        switch (operationReq){
            case "add" : System.out.println(num1 + " + " + num2 + " = " + (num1 + num2));
                break;

            case "subtract" : System.out.println(num1 + " - " + num2 + " = " + (num1 - num2));
                break;

            case "multiply" : System.out.println(num1 + " * " + num2 + " = " + (num1 * num2));
                break;

            case "divide" : System.out.println(num1 + " / " + num2 + " = " + (num1 / num2));
                break;

            default:
                System.out.println("Operation is not allowed");
        }

//        while (true) {
//            if (operationReq == "add") {
//                System.out.println(num1 + " + " + num2 + " = " + (num1 + num2));
//                break;
//            }
//
//            if (operationReq == "subtract") {
//                System.out.println(num1 + " - " + num2 + " = " + (num1 - num2));
//                break;
//            }
//
//            if (operationReq == "multiply") {
//                System.out.println(num1 + " * " + num2 + " = " + (num1 * num2));
//                break;
//            }
//
//            if (operationReq == "divide") {
//                System.out.println(num1 + " / " + num2 + " = " + (num1 / num2));
//                break;
//
//            } else {
//                System.out.println("Operation is not allowed");
//                break;
//            }
//        }
    }
}
