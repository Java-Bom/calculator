package calculator;

import calculator.value.Number;
import calculator.value.Operator;

public class StringCalculator {
    private static final int FIRST_INDEX = 0;

    public static int calculateWith(String[] splitString) {
        Number result = new Number(splitString[FIRST_INDEX]);

        for (int index = 1; index < splitString.length; index += 2) {
            String operatorString = splitString[index];
            String numberString = splitString[index + 1];

            Number rightNumber = new Number(numberString);
            Operator operator = new Operator(operatorString);

            result = operator.calculate(result, rightNumber);
        }
        return result.getValue();
    }
}