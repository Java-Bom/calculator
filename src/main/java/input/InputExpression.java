package input;

import operation.Number;
import operation.Operation;
import operation.Operator;

import java.util.*;

public class InputExpression {

    public static void validInputExpression(List<String> expression) {
        if (expression.isEmpty()) {
            throw new IllegalArgumentException("입력값이 없습니다.");
        }

        if (isContainWrongValue(expression)) {
            throw new IllegalArgumentException("계산식에 잘못된 값이 들어 있습니다.");
        }

        if (isWrongExpression(expression)) {
            throw new IllegalArgumentException("계산식이 잘못 입력 되었습니다.");
        }
    }

    private static boolean isContainWrongValue(List<String> expression) {
        for (String value : expression) {
            if (!Operator.isOperator(value) && !Number.isNumber(value)) { return true; }
        }
        return false;
    }

    private static boolean isContinuousOperator(String previous, String current) {
        return Operator.isOperator(previous) && Operator.isOperator(current);
    }

    private static boolean isWrongExpression(List<String> expression) {
        Stack<String> expressionChecker = new Stack<>();
        if (Operator.isOperator(expression.get(0))) {
            return true;
        }

        if (Operator.isOperator(expression.get(expression.size()-1))) {return true;}
        expressionChecker.add(expression.get(0));

        for (int i = 1; i < expression.size(); i++) {
            String previousValue = expressionChecker.peek();
            if (isContinuousOperator(previousValue, expression.get(i))) { return true; }
            expressionChecker.add(expression.get(i));
        }
        return false;
    }

}
