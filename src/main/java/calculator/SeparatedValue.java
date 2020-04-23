package calculator;

import java.util.List;

public class SeparatedValue {
    private List<Double> operands;
    private List<String> operations;

    public SeparatedValue(List<Double> operands, List<String> operations) {
        this.operands = operands;
        this.operations = operations;
    }

    public List<Double> getOperands() {
        return operands;
    }

    public List<String> getOperations() {
        return operations;
    }
}
