package calculator;

import java.util.List;

public class CalculateApplication {

    public static void main(String[] args) {
        List<String> splitString = InputStringHelper.splitString();

        int result = StringCalculator.calculateWith(splitString);

        System.out.println(result);
    }
}
