import input.InputProcessor;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class CalculatorApplication {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        InputProcessor processor = new InputProcessor(input);

        List<Double> numbers = processor.getNumbers();
        List<String> operators = processor.getOperators();
        System.out.println(calculator.calculate(numbers, operators));
    }
}
