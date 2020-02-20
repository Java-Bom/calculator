package calculator.view;

import java.util.Objects;

public class InputExpressionDTO {
    private final String expression;

    public InputExpressionDTO(String expression) {
        validateExpression(expression);
        this.expression = expression;
    }

    private void validateExpression(String expression) {
        if (isEmpty(expression)) {
            throw new IllegalArgumentException("입력값이 비어 있습니다.");
        }
    }

    private boolean isEmpty(String expression) {
        return expression == null || expression.trim().equals("");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InputExpressionDTO that = (InputExpressionDTO) o;
        return Objects.equals(expression, that.expression);
    }

    @Override
    public int hashCode() {
        return Objects.hash(expression);
    }
}
