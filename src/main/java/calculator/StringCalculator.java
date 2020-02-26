package calculator;

import calculator.value.Number;
import calculator.value.Operator;

import java.util.List;

public class StringCalculator {
    private static final int FIRST_INDEX = 0;

    public static int calculateWith(List<String> splitString) {
        Number result = new Number(splitString.get(FIRST_INDEX));

        for (int index = 1; index < splitString.size(); index += 2) {
            String operatorString = splitString.get(index);
            String numberString = splitString.get(index + 1);

            Number rightNumber = new Number(numberString);
            Operator operator = new Operator(operatorString);

            result = operator.calculate(result, rightNumber);
        }
        return result.getValue();
    }
}