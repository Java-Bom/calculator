package calculator;

import java.util.List;

public class Calculator {
    private OperationType operationType;

    public double calculate(String value) {
        if (value.isEmpty()) {
            return 0;
        }
        return calculateValue(value);
    }

    private double calculateValue(String value) {
        SeparatedValue separatedValue = Separator.separateOperandAndOperation(value);
        List<String> operations = separatedValue.getOperations();
        List<Double> operands = separatedValue.getOperands();

        int length = operations.size();
        for (int i = 0; i < length; i++) {
            operationType = OperationType.valueOfOperation(operations.get(i));
            operands.set(i + 1, operationType.execute(operands.get(i), operands.get(i + 1)));
        }

        return operands.get(length);
    }
}
