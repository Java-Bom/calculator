import calculator.Calculator;
import service.CalculateService;
import view.InputView;
import view.OutputView;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CalculateService calculateService = new CalculateService(new Calculator());

        OutputView.printInputMessage();
        String receivedFormula = scanner.nextLine();

        double result = calculateService.calculate(receivedFormula);
        OutputView.printResult(result);
    }
}
