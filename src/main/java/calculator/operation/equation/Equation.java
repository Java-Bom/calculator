package calculator.operation.equation;

import java.util.List;

public class Equation {
    private final NumberBundle numbers;
    private final OperatorBundle operators;

    public Equation(List<String> splitEquation) {
        this.numbers = new NumberBundle(splitEquation);
        this.operators = new OperatorBundle(splitEquation);
        validateEquation();
    }

    private void validateEquation() {
        int numberSize = numbers.size();
        int operatorSize = operators.size();
        if (numberSize != operatorSize + 1) {
            throw new ArithmeticException(String.format("연산자(%d개)와 피연산자(%d개)의 갯수가 올바르지 않습니다.", operatorSize, numberSize));
        }
    }

    public double getResult() {
        return operators.operate(numbers);
    }
}
