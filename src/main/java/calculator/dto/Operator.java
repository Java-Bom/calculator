package calculator.dto;

import java.util.Arrays;

public class Operator {

    private Type type;

    public Operator(String operator) {
        this.type = Type.of(operator);
    }

    public Type getType() {
        return type;
    }

    public double compute(double result, double operand) {
        return type.getExpression().compute(result, operand);
    }

    enum Type {

        PLUS("+", (a, b) -> a + b),
        MINUS("-", (a, b) -> a - b),
        MULTIPLY("*", (a, b) -> a * b),
        DIVIDE("/", (a, b) -> {
            if (b == 0) {
                throw new NumberFormatException("0으로 나눌 수 없습니다.");
            }
            return a / b;
        });

        private String notation;
        private Expression expression;

        Type(String notation, Expression expression) {
            this.notation = notation;
            this.expression = expression;
        }

        Expression getExpression() {
            return this.expression;
        }

        static Type of(String operator) {
            return Arrays.stream(Type.values())
                    .filter(type -> type.isOperator(operator))
                    .findAny()
                    .orElseThrow(IllegalArgumentException::new);
        }

        private boolean isOperator(String operator) {
            return notation.equals(operator);
        }

    }

    private interface Expression {
        double compute(double leftOperand, double rightOperand);
    }
}
