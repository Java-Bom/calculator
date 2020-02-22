package calculator;

public class CalculateApplication {

    public static void main(String[] args) {
        String[] splitString = InputStringHelper.splitStringArray();

        int result = StringCalculator.calculateWith(splitString);

        System.out.println(result);
    }
}
