package calculator;

public class Calculator {
    private final String PLUS = "+";
    private final String MINUS = "-";
    private final String MUL = "*";

    private int[] numbers;
    private String[] operations;

    public int calculate(String text) {
        if (isEmptyOrNull(text)) {
            return 0;
        }
        initNumberAndOperation(separateNumberAndOperation(split(text)));
        operate();

        return numbers[numbers.length - 1];
    }

    private boolean isEmptyOrNull(String text) {
        return text.isEmpty() || text == null;
    }

    private String[] split(String text) {
        return text.split(" ");
    }

    private String[][] separateNumberAndOperation(String[] text) {
        int length = text.length;
        String[][] numberAndOperation = new String[2][length / 2 + 1];

        int idx = 0;
        for (int i = 0; i < length - 1; i += 2) {
            numberAndOperation[0][idx] = text[i];
            numberAndOperation[1][idx++] = text[i + 1];
        }
        numberAndOperation[0][idx] = text[length - 1];

        return numberAndOperation;
    }

    private void initNumberAndOperation(String[][] numberAndOperation) {
        int numberSize = numberAndOperation[0].length;
        int operationSize = numberAndOperation[1].length - 1;
        numbers = new int[numberSize];
        operations = new String[operationSize];

        initNumbers(numberAndOperation[0]);
        initOperation(numberAndOperation[1]);
    }

    private void initNumbers(String[] StrNumbers) {
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(StrNumbers[i]);
        }
    }

    private void initOperation(String[] preOperations) {
        for (int i = 0; i < operations.length; i++) {
            operations[i] = preOperations[i];
        }
    }

    private void operate() {
        for (int i = 0; i < operations.length; i++) {
            numbers[i + 1] = getOperateResult(numbers[i], numbers[i + 1], operations[i]);
        }
    }

    private int getOperateResult(int firstNumber, int secondNumber, String operation) {
        if (operation.equals(PLUS)) {
            return firstNumber + secondNumber;
        }

        return getOperateMinus(firstNumber, secondNumber, operation);
    }

    private int getOperateMinus(int firstNumber, int secondNumber, String operation) {
        if (operation.equals(MINUS)) {
            return firstNumber - secondNumber;
        }

        return getOperateMul(firstNumber, secondNumber, operation);
    }

    private int getOperateMul(int firstNumber, int secondNumber, String operation) {
        if (operation.equals(MUL)) {
            return firstNumber * secondNumber;
        }

        return getOperateDivide(firstNumber, secondNumber, operation);
    }

    private int getOperateDivide(int firstNumber, int secondNumber, String operation) {
        if (bottomIsZero(secondNumber)) {
            return 0;
        }

        return firstNumber / secondNumber;
    }

    private boolean bottomIsZero(int number) {
        return number == 0;
    }
}
