package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class StringCalculator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.next();

        String[] values = inputString.split(" ");


    }

    public static boolean isOperation(String value) {
        String[] operationSet = {"+", "-", "*", "/"};
        List<String> operations = Arrays.stream(operationSet)
                .collect(Collectors.toList());
        return operations.contains(value);
    }
}

// 입력받고 분리 문자열 만들어내는
// 숫자인지 연산자인지 구분하는 메소드
// 실제 연산하는 코드
