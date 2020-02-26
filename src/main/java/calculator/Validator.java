package calculator;

public class Validator {
    public static void isBlank(String value) {
        if (value != null) {
            return;
        }
        System.out.println("Error : Input right value");
        throw new IllegalArgumentException();
    }
}
