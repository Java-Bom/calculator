package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class StringCalculator {
    public static Integer finalResult = null;
    public static String operator = "";

    public static void main(String[] args) {

        String[] splitString = InputStringHelper.splitStringArray();

        for (String value : splitString) {
            verifyValueAndCalculateWith(value);
        }
        System.out.println(finalResult);
    }

    private static void verifyValueAndCalculateWith(String value) {
        if (isOperator(value)) {
            operator = value;
            return;
        }
        calculateWith(value);
    }

    public static void calculateWith(String value) {
        if (finalResult == null) {
            finalResult = Integer.parseInt(value);
            return;
        }
        if (operator.equals("+")) {
            finalResult += Integer.parseInt(value);
        }
        if (operator.equals("-")) {
            finalResult -= Integer.parseInt(value);
        }
        if (operator.equals("/")) {
            isArithmeticException(Integer.parseInt(value));
        }
        if (operator.equals("*")) {
            finalResult *= Integer.parseInt(value);
        }
    }

    private static void isArithmeticException(int value) {
        try {
            finalResult /= value;
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }
    }

    public static boolean isOperator(String value) {
        String[] operatorSet = {"+", "-", "*", "/"};
        List<String> operators = Arrays.stream(operatorSet)
                .collect(Collectors.toList());
        return operators.contains(value);
    }
}