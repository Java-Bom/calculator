import domain.Calculator;
import service.CalculateService;
import view.OutputView;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        OutputView.printInputMessage();

        Scanner scanner = new Scanner(System.in);
        String receivedFormula = scanner.nextLine();

        CalculateService calculateService = new CalculateService(new Calculator());
        double result = calculateService.calculate(receivedFormula);

        OutputView.printResult(result);
    }
}
