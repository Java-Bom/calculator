package calculator.operation.equation;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Queue;
import java.util.stream.Collectors;

public class NumberBundle {
    private static final String EMPTY_NUMBER_EXCEPTION_MESSAGE = "연산 가능한 숫자가 존재하지 않습니다.";
    private final Queue<Number> numberBundle;

    public NumberBundle(List<String> splitEquation) {
        this.numberBundle = collectNumbers(splitEquation);
    }

    private Queue<Number> collectNumbers(List<String> splitEquation) {
        return splitEquation.stream()
                .filter(Number::isNumber)
                .map(Number::valueOf)
                .collect(Collectors.toCollection(LinkedList::new));
    }

    public double getNextNumber() {
        checkEmpty();
        return Objects.requireNonNull(numberBundle.poll())
                .getValue();
    }

    private void checkEmpty() {
        if (numberBundle.isEmpty()) {
            throw new NoSuchElementException(EMPTY_NUMBER_EXCEPTION_MESSAGE);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NumberBundle that = (NumberBundle) o;
        return Objects.equals(numberBundle, that.numberBundle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberBundle);
    }
}
