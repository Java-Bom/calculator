package operation;

public class Number {
    private String number = "";

    public static boolean isNumber(String value) {
        String numberPattern = "[0-9]";
        return value.matches(numberPattern);
    }

    public String getNumber() {
        return number;
    }

    public void attachContinuousNumber(String value) {
        number = number + value;
    }

    public void clearNumber() {
        number = "";
    }
}
