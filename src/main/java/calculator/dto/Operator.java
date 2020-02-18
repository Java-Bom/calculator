package calculator.dto;

import java.util.Arrays;

public enum Operator {

    PLUS("+", (a, b) -> a + b),
    MINUS("-", (a, b) -> a - b),
    MULTIPLY("*", (a, b) -> a * b),
    DIVIDE("/", (a, b) -> a / b);

    private String notation;
    private Expression expression;

    Operator(String notation, Expression expression) {
        this.notation = notation;
        this.expression = expression;
    }

    public static Expression getExpress(String notation) {
        return Arrays.stream(Operator.values())
                .filter(operator -> operator.isOperator(notation))
                .findAny()
                .orElseThrow(IllegalArgumentException::new)
                .expression;
    }

    private boolean isOperator(String operator) {
        return notation.equals(operator);
    }

    public interface Expression {
        double expression(double a, double b);
    }
}
