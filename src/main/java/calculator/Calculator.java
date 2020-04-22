package calculator;

import java.util.List;

public class Calculator {
    private OperationType operationType;

    public double calculate(String text) {
        if (text.isEmpty()) {
            return 0;
        }
        Separator separator = new Separator(text);
        return operate(separator.getOperand(), separator.getOperation());
    }

    private double operate(List<Double> operands, List<String> operations) {
        for (int i = 0; i < operations.size(); i++) {
            operationType = OperationTypeMapping.getOperationType(operations.get(i));
            operands.set(i + 1, operationType.execute(operands.get(i), operands.get(i + 1)));
        }

        return operands.get(operands.size() - 1);
    }
}
