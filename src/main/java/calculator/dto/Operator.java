package calculator.dto;

import java.util.Arrays;

public class Operator {
    private Type type;

    public Operator(String operator) {
        this.type = Type.getType(operator);
    }

    public Type.Expression getExpression() {
        return type.expression;
    }

    public Type getType() {
        return type;
    }

    public enum Type {

        PLUS("+", (a, b) -> a + b),
        MINUS("-", (a, b) -> a - b),
        MULTIPLY("*", (a, b) -> a * b),
        DIVIDE("/", (a, b) -> a / b);

        private String notation;
        private Expression expression;

        Type(String notation, Expression expression) {
            this.notation = notation;
            this.expression = expression;
        }

        public static Type getType(String operator) {
            return Arrays.stream(Type.values())
                    .filter(type -> type.isOperator(operator))
                    .findAny()
                    .orElseThrow(IllegalArgumentException::new);
        }

        public Expression getExpression() {
            return this.expression;
        }

        private boolean isOperator(String operator) {
            return notation.equals(operator);
        }

        public interface Expression {
            double expression(double a, double b);
        }
    }
}
