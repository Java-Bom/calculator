import calculator.Calculator;
import view.InputView;
import view.OutputView;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        InputView inputView = new InputView(new Scanner(System.in));
        OutputView.printInputMessage();

        String mathExpression = inputView.inputMathExpression();

        Calculator calculator = new Calculator();
        OutputView.printResult(calculator.calc(mathExpression));
    }
}
