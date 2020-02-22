package calculator;
import java.util.Scanner;

public class CalculatorApplication {
    public static void main(String[] args) {
        System.out.println("input : ");
        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();
        isBlank(value);

        int[] numberArr = Spliter.splitNumbers(value);
        String[] operatorArr = Spliter.splitOperators(value);

        int result = Calculator.calculate(operatorArr, numberArr);

        Calculator calculator = new Calculator(operatorArr, numberArr);
        System.out.println(calculator.getResult());
    }

    public static void isBlank(String value) {
        if (value != null) {
            return;
        }
        System.out.println("Error : Input right value");
        throw new IllegalArgumentException();
    }
}