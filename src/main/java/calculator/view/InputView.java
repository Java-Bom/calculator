package calculator.view;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public InputExpressionDTO inputEquation() {
        return new InputExpressionDTO(scanner.nextLine());
    }


}
