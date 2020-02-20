package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Operator {

    private Symbol operator;

    Operator(String operator) {
        if (!isOperator(operator)) {
            throw new RuntimeException("input value is not operator");
        }
        this.operator = Symbol.valueOf(operator);
    }

    public Number calculate(Number left, Number right) {
        if (operator == Symbol.PLUS) {
            return new Number(left.getValue() + right.getValue());
        }
        if (operator == Symbol.MINUS) {
            return new Number(left.getValue() - right.getValue());
        }
        if (operator == Symbol.DIVIDE) {
            return new Number(left.getValue() / right.getValue());
        }
        if (operator == Symbol.MULTIPLY) {
            return new Number(left.getValue() * right.getValue());
        }
        throw new RuntimeException("operator is not exist");
    }

    private boolean isOperator(String value) {
        String[] operatorSet = {"+", "-", "*", "/"};
        List<String> operators = Arrays.stream(operatorSet)
                .collect(Collectors.toList());
        return operators.contains(value);
    }

    enum Symbol {
        PLUS,
        MINUS,
        DIVIDE,
        MULTIPLY
    }
}
