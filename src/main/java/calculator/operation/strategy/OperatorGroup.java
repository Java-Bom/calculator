package calculator.operation.strategy;

import calculator.operation.equation.Number;
import calculator.operation.equation.Operator;

import java.util.Arrays;

public enum OperatorGroup {
    PLUS(Operator.valueOf("+"), Number::add),
    MINUS(Operator.valueOf("-"), Number::minus),
    MULTIPLE(Operator.valueOf("*"), Number::multiple),
    DIVIDE(Operator.valueOf("/"), Number::divide);

    private final Operator operator;
    private final OperationStrategy strategy;

    OperatorGroup(Operator operator, OperationStrategy strategy) {
        this.operator = operator;
        this.strategy = strategy;
    }

    public static OperatorGroup findByToken(Operator operator) {
        return Arrays.stream(values())
                .filter(aOperation -> aOperation.isEqual(operator))
                .findFirst()
                .orElseThrow(AssertionError::new);
    }

    private boolean isEqual(Operator operator) {
        return this.operator.equals(operator);
    }

    public Number operate(Number firstOperand, Number secondOperand) {
        return this.strategy.operate(firstOperand, secondOperand);
    }
}
