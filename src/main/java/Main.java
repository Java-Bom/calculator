import calculator.Calculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String value = sc.nextLine();
        Calculator calculator = new Calculator();
        System.out.println(calculator.calculate(value));
    }
}
