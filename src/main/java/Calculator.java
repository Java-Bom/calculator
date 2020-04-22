import input.InputProcessor;
import operation.Operation;

import java.util.List;
import java.util.Scanner;

public class Calculator {

    public void run() {
        Scanner sc = new Scanner(System.in);
        String value = sc.nextLine();
        String[] values = value.split(" ");
        InputProcessor processor = new InputProcessor();
        // 입력값 검사
        processor.validInputString(values);

        // 연산자 & 숫자 분리
        processor.splitOperatorsAndNumbers(values);
        List<String> operators = processor.operators;
        List<Double> numbers = processor.numbers;
        System.out.println(calculate(operators, numbers));
    }

    public double calculate(List<String> operators, List<Double> numbers) {
        while (!operators.isEmpty()) {
            double x = numbers.remove(0);
            double y = numbers.remove(0);
            String operatorSymbol = operators.remove(0);
            double result = 0.0;
            if (operatorSymbol.equals("+")) { result = Operation.PLUS.apply(x, y); }
            if (operatorSymbol.equals("-")) { result = Operation.MINUS.apply(x, y); }
            if (operatorSymbol.equals("*")) { result = Operation.TIMES.apply(x, y); }
            if (operatorSymbol.equals("/")) { result = Operation.DIVIDE.apply(x, y); }
            numbers.add(0, result);
        }
        return numbers.remove(0);
    }
}
