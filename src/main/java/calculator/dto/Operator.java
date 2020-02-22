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

    public Operand compute(Operand leftOperand, Operand rightOperand) {
        return type.computeExpression(leftOperand, rightOperand);
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

        static Type of(String operator) {
            return Arrays.stream(Type.values())
                    .filter(type -> type.isOperator(operator))
                    .findAny()
                    .orElseThrow(IllegalArgumentException::new);
        }

        private boolean isOperator(String operator) {
            return notation.equals(operator);
        }

        public Operand computeExpression(Operand result, Operand operand) {
            return new Operand(expression.compute(result.getValue(), operand.getValue()));
        }
    }

    private interface Expression {
        double compute(double leftOperand, double rightOperand);
    }

}
