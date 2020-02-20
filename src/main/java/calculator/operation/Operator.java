package calculator.operation;

import java.util.Objects;
import java.util.regex.Pattern;

public final class Operator {
    private static final String OPERATOR_REGEX = "[+|\\-|*|/]";
    private static final Pattern OPERATOR_PATTERN = Pattern.compile(OPERATOR_REGEX);
    private static final String INCORRECT_OPERATOR_EXCEPTION_MESSAGE = "%s : 올바르지 않은 연산자 입니다.";

    private final String operator;

    private Operator(String maybeOperator) {
        validateOperator(maybeOperator);
        this.operator = maybeOperator;
    }

    public static Operator valueOf(String maybeOperator) {
        return new Operator(maybeOperator);
    }

    private void validateOperator(String maybeOperator) {
        if (isNotOperator(maybeOperator)) {
            throw new IllegalArgumentException(String.format(INCORRECT_OPERATOR_EXCEPTION_MESSAGE, maybeOperator));
        }
    }

    private boolean isNotOperator(String maybeOperator) {
        return !OPERATOR_PATTERN.matcher(maybeOperator).find();
    }

    public String getOperator() {
        return operator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operator operator1 = (Operator) o;
        return Objects.equals(operator, operator1.operator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operator);
    }
}
