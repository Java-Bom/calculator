package operation;

import input.InputExpression;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class OperatorPack {
    private List<String> operators;

    public OperatorPack(List<String> expression) {
        operators = initOperatorPack(expression);
    }

    private List<String> initOperatorPack(List<String> expression) {
        InputExpression.validInputExpression(expression);
        operators = new ArrayList<>();
        for (String exp : expression) {
            if (Operator.isOperator(exp)) { operators.add(exp); }
        }
        return operators;
    }

    private void hasOperator() {
        if (operators.isEmpty()) {
            throw new NoSuchElementException("연산자가 존재하지 않습니다.");
        }
    }

    public int getOperatorPackCounts() {
        return operators.size();
    }

    public String pollOperator() {
        hasOperator();
        return operators.remove(0);
    }

}
