package calculator;
import java.util.Scanner;

public class CalculatorApplication {
    public static void main(String[] args) {
        System.out.println("input : ");
        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();

        Spliter.isBlank(value);

        int[] numberArr = Spliter.splitNumbers(value);
        String[] operatorArr = Spliter.splitOperators(value);

        Calculator calculator = new Calculator();

    }


}