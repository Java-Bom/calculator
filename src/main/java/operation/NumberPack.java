package operation;

import input.InputExpression;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class NumberPack {
    private List<Double> numbers;

    private Number number;

    public NumberPack(List<String> expression) {
        numbers = initNumberPack(expression);
    }

    private List<Double> initNumberPack(List<String> expression) {
        InputExpression.validInputExpression(expression);
        numbers = new ArrayList<>();
        number = new Number();

        for (String exp : expression) {
            if (Number.isNumber(exp)) { number.attachContinuousNumber(exp);}
            if (Operator.isOperator(exp)) { addNumber(number);}
        }
        if (!number.getNumber().equals("")) { addNumber(number);}

        return numbers;
    }

    private void addNumber(Number number) {
        numbers.add(Double.parseDouble(number.getNumber()));
        number.clearNumber();
    }

    private void hasNumber() {
        if (numbers.isEmpty()) {
            throw new NoSuchElementException("숫자가 존재하지 않습니다.");
        }
    }

    public int getNumberCount() {
        return numbers.size();
    }

    public double pollNumber() {
        hasNumber();
        return numbers.remove(0);
    }
}
