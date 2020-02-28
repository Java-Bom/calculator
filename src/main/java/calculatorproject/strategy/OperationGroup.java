package calculatorproject.strategy;

import calculatorproject.data.Operand;

import java.util.Arrays;

public enum OperationGroup {
    PLUS("+", Operand::plus),
    MINUS("-", Operand::minus),
    DIVIDE("/", Operand::divide),
    MULTIPLY("*", Operand::multiply);

    private final String operator;
    public final CalculateStrategy calculateStrategy;

    OperationGroup(String operator, CalculateStrategy calculateStrategy) {
        this.operator = operator;
        this.calculateStrategy = calculateStrategy;
    }

    public String getOperator() {
        return operator;
    }

    public static OperationGroup of(String operator) {
        return Arrays.stream(OperationGroup.values())
                .filter(operationGroup -> operationGroup.getOperator().equals(operator))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }
}