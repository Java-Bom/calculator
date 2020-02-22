package calculator.value;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class Operator {

    private final Symbol operator;

    public Operator(String operator) {
        this.operator = Symbol.of(operator);
    }

    public Number calculate(Number left, Number right) {
        if (operator == Symbol.PLUS) {
            return left.plus(right);
        }
        if (operator == Symbol.MINUS) {
            return left.minus(right);
        }
        if (operator == Symbol.DIVIDE) {
            return left.divide(right);
        }
        if (operator == Symbol.MULTIPLY) {
            return left.multiply(right);
        }
        throw new NoSuchElementException("operator is not exist");
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
                    .orElseThrow(IllegalArgumentException::new);
        }
    }
}
