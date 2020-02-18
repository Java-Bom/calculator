package calculator;

import calculator.dto.Operator;
import calculator.support.Splitter;

public class Calculator {

    public double calc(String formula) {
        String[] splitedFormula = Splitter.split(formula);

        validateFormula(splitedFormula);

        double result = Double.parseDouble(splitedFormula[0]);

        for(int i = 1 ; i < splitedFormula.length; i += 2) {
            String operator = splitedFormula[i];
            double operand = Double.parseDouble(splitedFormula[i + 1]);

//            Operator.Expression expression = Operator.getExpress(operator);
//            result = expression.expression(result, operand);
        }

        return result;
    }

    private void validateFormula(String[] splitedFormular) {
        if(splitedFormular.length % 2 == 0) {
            throw new IllegalArgumentException("올바른 수식이 아닙니다.");
        }
    }

}

