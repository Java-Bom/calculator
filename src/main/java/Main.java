import calculator.Calculator;
import service.CalculateService;
import view.InputView;
import view.OutputView;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        CalculateService calculateService = new CalculateService(new Calculator());

        OutputView.printInputMessage();
        OutputView.printResult(calculateService.calculate());

    }
}
