package calculator;

public class StringCalculator {

    private static final int FIRST_INDEX = 0;

    public static void main(String[] args) {

        String[] splitString = InputStringHelper.splitStringArray();

        int result = StringCalculator.calculateWith(splitString);

        System.out.println(result);

    }

    public static int calculateWith(String[] splitString) {
        Operator operator;
        Number result = new Number(splitString[FIRST_INDEX]);

        for (int index = 1; index < splitString.length; index += 2) {
            String operatorString = splitString[index];
            String numberString = splitString[index + 1];

            Number rightNumber = new Number(numberString);
            operator = new Operator(operatorString);
            result = operator.calculate(result, rightNumber);
        }

        return result.getValue();
    }

}