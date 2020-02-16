package view;

import java.util.Scanner;

public class InputView {

    private Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }


    public String inputMathExpression() {
        return scanner.nextLine();
    }

}
