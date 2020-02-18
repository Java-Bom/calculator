package calculator;

import calculator.dto.Operand;
import calculator.dto.Operator;

public class Calculator {

    public double calculate(String[] formula) {

        double result = new Operand(formula[0]).getValue();

        for(int i = 1 ; i < formula.length; i += 2) {
            Operator operator = new Operator(formula[i]);
            Operand operand = new Operand(formula[i + 1]);

            result = operator.getType().getExpression().expression(result, operand.getValue());
        }

        return result;
    }



}

