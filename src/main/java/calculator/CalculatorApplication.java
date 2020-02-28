package calculator;
import java.util.ArrayList;
import java.util.Scanner;

public class CalculatorApplication {
    public static void main(String[] args) {
        System.out.println("input : ");
        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();

        Spliter spliter = new Spliter();
        Validator.isBlank(value);

        ArrayList<String> operatorList = spliter.splitOperators(value);
        ArrayList<Integer> numberList = spliter.splitNumbers(value);

        Calculator calculator = new Calculator();
        double result = calculator.callValue(operatorList,numberList);

        System.out.println("result : "+result);
    }
}