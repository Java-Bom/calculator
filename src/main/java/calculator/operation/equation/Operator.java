package calculator.operation.equation;

import java.util.Objects;
import java.util.regex.Pattern;

public final class Operator {
    private static final Pattern OPERATOR_PATTERN = Pattern.compile("[+|\\-|*|/]");

    private final String token;

    private Operator(String maybeOperator) {
        validateOperator(maybeOperator);
        this.token = maybeOperator;
    }

    public static Operator valueOf(String maybeOperator) {
        return new Operator(maybeOperator);
    }

    public static boolean isOperator(String maybeOperator) {
        return OPERATOR_PATTERN.matcher(maybeOperator)
                .find();
    }

    private void validateOperator(String maybeOperator) {
        if (isNotOperator(maybeOperator)) {
            throw new IllegalArgumentException(String.format("%s : 올바르지 않은 연산자 입니다.", maybeOperator));
        }
    }

    private boolean isNotOperator(String maybeOperator) {
        return !isOperator(maybeOperator);
    }

    public String getToken() {
        return token;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operator operator1 = (Operator) o;
        return Objects.equals(token, operator1.token);
    }

    @Override
    public int hashCode() {
        return Objects.hash(token);
    }
}
