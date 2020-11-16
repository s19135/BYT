package template2;

public class PhoneConstructor {

    public static void main(String[] args) {
        Phones apple = new Apple();
        apple.makePhone();

        System.out.println();

        Phones samsung = new Samsung();
        samsung.makePhone();
    }
}
