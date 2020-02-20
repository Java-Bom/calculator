package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Operator {

    private String operator;

    Operator(String operator) {
        if (!isOperator(operator)) {
            throw new RuntimeException("input value is not operator");
        }
        this.operator = operator;
    }

    public Number calculate(Number left, Number right) {
        if ("+".equals(operator)) {
            return new Number(left.getValue() + right.getValue());
        }
        if ("-".equals(operator)) {
            return new Number(left.getValue() - right.getValue());
        }
        if ("/".equals(operator)) {
            return new Number(left.getValue() / right.getValue());
        }
        if ("*".equals(operator)) {
            return new Number(left.getValue() * right.getValue());
        }
        throw new RuntimeException("operator is not exist");
    }

    private boolean isOperator(String value) {
        String[] operatorSet = {"+", "-", "*", "/"};
        List<String> operators = Arrays.stream(operatorSet)
                .collect(Collectors.toList());
        return operators.contains(value);
    }

}
