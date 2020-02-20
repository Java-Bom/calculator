package calculator;

import java.util.Scanner;

public class CalculatorApplication {

    private static final String DELIMITER = " ";

    public static void main(String[] args) {
        CalculatorFactory basicCalculatorFactory = new BasicCalculatorFactory();
        ValidatorFactory validatorFactory = new ValidatorFactory();

        BasicCalculator calculator = basicCalculatorFactory.makeBasicCalculator();
        TurnValidator turnValidator = validatorFactory.makeTurnValidator();
        InputValidator inputValidator = validatorFactory.makeInputValidator();

        Scanner scanner = new Scanner(System.in);
        String input;
        boolean isError = false;
        do {
            System.out.println("문자열을 입력해주세요.");
            input = scanner.nextLine();
            isError = inputValidator.validateInput(inputValidator, input);
        } while (isError);

        String[] inputArray = input.split(DELIMITER);

        Integer result = null;
        String operator = null;

        for (String inputValue : inputArray) {
            Turn turn = turnValidator.checkTurn(inputValue, result);

            if (turn.equals(Turn.FIRST_OPERAND)) {
                result = Integer.parseInt(inputValue);
            }
            if (turn.equals(Turn.OPERATOR)) {
                operator = inputValue;
            }
            if (turn.equals(Turn.OTHER_OPERAND)) {
                result = calculator.calculate(result, operator, inputValue);
            }
        }
        System.out.println(result);
    }
}