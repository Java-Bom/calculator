package calculator.operation.strategy;

import calculator.operation.equation.Number;

public interface OperationStrategy {
    Number operate(Number firstOperand, Number secondOperand);
}
