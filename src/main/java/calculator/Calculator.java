package calculator;

public class Calculator {
    private OperationMapping mapping;

    public double calculate(String text) {
        if (text.isEmpty()) {
            return 0;
        }
        init();
        Separator separator = new Separator(text);
        separator.separate();
        return operate(separator.getArrayOperand(), separator.getArrayOperation());
    }

    private void init() {
        mapping = new OperationMapping();
        mapping.init();
    }

    private double operate(double[] operands, String[] operations) {
        Operation operation;
        for (int i = 0; i < operations.length; i++) {
            operation = mapping.findOperation(operations[i]);
            operands[i + 1] = operation.execute(operands[i], operands[i + 1]);
        }

        return operands[operands.length - 1];
    }
}
