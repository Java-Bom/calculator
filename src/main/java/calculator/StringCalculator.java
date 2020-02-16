package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class StringCalculator {
    public static Integer finalResult = null;
    public static String operator = "";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.next();

        String[] values = inputString.split(" ");
        for (String value : values) {
            verifyValueAndCalculateWith(value);
        }
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
            finalResult /= Integer.parseInt(value);
        }
        if (operator.equals("*")) {
            finalResult *= Integer.parseInt(value);
        }
    }

    public static boolean isOperator(String value) {
        String[] operatorSet = {"+", "-", "*", "/"};
        List<String> operators = Arrays.stream(operatorSet)
                .collect(Collectors.toList());
        return operators.contains(value);
    }
}

// 입력받고 분리 문자열 만들어내는
// 숫자인지 연산자인지 구분하는 메소드
// 실제 연산하는 코드
// 0으로 나눌때 ??