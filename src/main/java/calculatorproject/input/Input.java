package calculatorproject.input;

import calculatorproject.factory.ValidatorFactory;

import java.util.Scanner;

public class Input {
    private static final String DELIMITER = " ";

    public static String[] split(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("문자열을 입력해주세요.");
        String input = scanner.nextLine();
        InputValidator inputValidator = ValidatorFactory.makeInputValidator();
        inputValidator.validateInput(input);
        return input.split(DELIMITER);
    }
}
