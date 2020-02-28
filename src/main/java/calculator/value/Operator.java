package calculator.value;

import java.util.Arrays;

public class Operator {

    private final Symbol operator;

    public Operator(String operator) {
        this.operator = Symbol.of(operator);
    }

    public Number calculate(Number left, Number right) {
        return operator.calculateStrategy.calculate(left, right);
    }

    enum Symbol {
        PLUS("+", Number::plus),
        MINUS("-", Number::minus),
        DIVIDE("/", Number::divide),
        MULTIPLY("*", Number::multiply);

        private final String operator;
        private final CalculateStrategy calculateStrategy;

        Symbol(String operator, CalculateStrategy calculateStrategy) {
            this.operator = operator;
            this.calculateStrategy = calculateStrategy;
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

    interface CalculateStrategy {
        Number calculate(Number left, Number right);
    }
}
