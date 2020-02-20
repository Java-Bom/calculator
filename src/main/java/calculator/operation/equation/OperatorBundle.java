package calculator.operation.equation;

import calculator.operation.strategy.OperationGroup;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Queue;
import java.util.stream.Collectors;

public class OperatorBundle {
    private static final String EMPTY_OPERATORS_EXCEPTION_MESSAGE = "연산자가 비어있습니다.";
    private final Queue<Operator> operatorBundle;

    public OperatorBundle(List<String> splitEquation) {
        this.operatorBundle = collectOperators(splitEquation);
    }

    private Queue<Operator> collectOperators(List<String> splitEquation) {
        return splitEquation.stream()
                .filter(Operator::isOperator)
                .map(Operator::valueOf)
                .collect(Collectors.toCollection(LinkedList::new));
    }

    public OperationGroup getNextStrategy() {
        checkEmpty();
        String token = Objects.requireNonNull(operatorBundle.poll())
                .getToken();
        return OperationGroup.findByToken(token);
    }

    private void checkEmpty() {
        if (isEmpty()) {
            throw new NoSuchElementException(EMPTY_OPERATORS_EXCEPTION_MESSAGE);
        }
    }

    public boolean isNotEmpty() {
        return !isEmpty();
    }

    private boolean isEmpty() {
        return operatorBundle.isEmpty();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OperatorBundle that = (OperatorBundle) o;
        return Objects.equals(operatorBundle, that.operatorBundle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operatorBundle);
    }
}
