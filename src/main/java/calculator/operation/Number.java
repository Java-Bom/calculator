package calculator.operation;

import java.util.Objects;

public final class Number {
    private static final String DOUBLE_PARSE_FAIL_EXCEPTION = "%s : 입력한 값은 숫자가 아닙니다.";
    private final double value;

    private Number(String maybeDouble) {
        this.value = parseDouble(maybeDouble);
    }

    public static Number valueOf(String maybeNumber) {
        return new Number(maybeNumber);
    }

    private double parseDouble(String maybeDouble) {
        try {
            return Double.parseDouble(maybeDouble);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(String.format(DOUBLE_PARSE_FAIL_EXCEPTION, maybeDouble));
        }
    }

    public double getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number = (Number) o;
        return Double.compare(number.value, value) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
