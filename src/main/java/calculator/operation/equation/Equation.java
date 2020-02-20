package calculator.operation.equation;

import calculator.operation.strategy.OperationGroup;

import java.util.List;

public class Equation {
    private final NumberBundle numbers;
    private final OperatorBundle operators;

    public Equation(List<String> splitEquation) {
        this.numbers = new NumberBundle(splitEquation);
        this.operators = new OperatorBundle(splitEquation);
    }


    public double getResult() {
        double result = numbers.getNextNumber();

        while (operators.isNotEmpty()) {
            OperationGroup nextStrategy = operators.getNextStrategy();
            result = nextStrategy.operate(result, numbers.getNextNumber());
        }

        return result;
    }
}
