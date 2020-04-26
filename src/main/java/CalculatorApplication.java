import input.InputExpression;
import input.Split;
import operation.NumberPack;
import operation.OperatorPack;

import java.util.List;
import java.util.Scanner;

public class CalculatorApplication {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        Split split = new Split(input);
        List<String> expression = split.getExpression();
        NumberPack numberPack = new NumberPack(expression);
        OperatorPack operatorPack = new OperatorPack(expression);
        System.out.println(calculator.calculate(numberPack, operatorPack));
    }
}
