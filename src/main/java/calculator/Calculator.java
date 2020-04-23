package calculator;

import java.util.List;

public class Calculator {
    private OperationType operationType;
    private String value;

    public Calculator(String value) {
        this.value = value;
    }

    public double calculate() {
        if (value.isEmpty()) {
            return 0;
        }
        return calculateValue();
    }

    private double calculateValue() {
        SeparatedValue separatedValue = new Separator(value).separateOperandAndOperation();

        List<Double> operands = separatedValue.getOperands();
        List<String> operations = separatedValue.getOperations();
        int length = operations.size();
        for (int i = 0; i < length; i++) {
            operationType = OperationType.valueOfOperation(operations.get(i));
            operands.set(i + 1, operationType.execute(operands.get(i), operands.get(i + 1)));
        }

        return operands.get(length);
    }
}
