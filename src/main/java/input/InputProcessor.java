package input;

import operation.OperationType;

import java.util.*;

public class InputProcessor {

    private static final String BLANK = " ";

    private List<String> expression = new ArrayList<>();

    private List<Double> numbers = new ArrayList<>();

    private List<String> operators = new ArrayList<>();

    public InputProcessor(String input) {
        removeBlank(input);
        splitOperatorsAndNumbers();
    }

    private String[] splitStringAll(String input) {
        return input.split("");
    }

    private void removeBlank(String input) {
        String[] inputValues = splitStringAll(input);
        for (String value : inputValues) {
            if (value.equals(BLANK)) { continue; }
            expression.add(value);
        }
    }

    private void validInputString() {
        if (expression.isEmpty()) {
            throw new IllegalArgumentException("입력값이 없습니다.");
        }

        if (isContainWrongValue()) {
            throw new IllegalArgumentException("계산식에 잘못된 값이 들어 있습니다.");
        }

        if (isWrongExpression()) {
            throw new IllegalArgumentException("계산식이 잘못 입력 되었습니다.");
        }
    }

    private boolean isContainWrongValue() {
        for (String value : expression) {
            if (value.equals(BLANK)) { continue; }
            if (!OperationType.isOperator(value) && !isNumber(value)) { return true; }
        }
        return false;
    }

    private boolean isWrongExpression() {
        Stack<String> expressionChecker = new Stack<>();
        if (OperationType.isOperator(expression.get(0))) {
            return true;
        }

        expressionChecker.add(expression.get(0));

        for (int i = 1; i < expression.size(); i++) {
            String value = expressionChecker.peek();
            if (isNumber(value) && !OperationType.isOperator(expression.get(i))) { return true; }
            if (!isNumber(expression.get(i)) && OperationType.isOperator(value)) { return true; }
            expressionChecker.add(expression.get(i));
        }
        return false;
    }

    private boolean isNumber(String value) {
        String numberPattern = "[0-9]";
        return value.matches(numberPattern);
    }

    private void splitOperatorsAndNumbers() {
        validInputString();
        for (String value : expression) {
            if (OperationType.isOperator(value)) { operators.add(value);}
            if (isNumber(value)) { numbers.add(Double.parseDouble(value)); }
        }
    }

    public List<String> getOperators() {
        return operators;
    }

    public List<Double> getNumbers() {
        return numbers;
    }

    public List<String> getExpression() {
        return expression;
    }
}
