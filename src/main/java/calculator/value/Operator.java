package calculator.value;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Operator {

    private Symbol operator;

    public Operator(String operator) {
        if (!isOperator(operator)) {
            throw new IllegalArgumentException("input value is not operator");
        }
        this.operator = Symbol.of(operator);
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
        throw new NoSuchElementException("operator is not exist");
    }

    private boolean isOperator(String value) {
        String[] operatorSet = {"+", "-", "*", "/"};
        List<String> operators = Arrays.stream(operatorSet)
                .collect(Collectors.toList());
        return operators.contains(value);
    }

    enum Symbol {
        PLUS("+"),
        MINUS("-"),
        DIVIDE("/"),
        MULTIPLY("*");

        private String operator;

        Symbol(String operator) {
            this.operator = operator;
        }

        public String getOperator() {
            return operator;
        }

        public static Symbol of(String operator) {
            return Arrays.stream(Symbol.values())
                    .filter(symbol -> symbol.getOperator().equals(operator))
                    .findFirst()
                    .orElseThrow(NoSuchElementException::new);
        }
    }
}
