package domain;

import domain.dto.Operand;
import domain.dto.Operator;

public class Calculator {
    public double calculate(String[] formula) {
        Operand result = new Operand(formula[0]);

        for(int i = 1 ; i < formula.length; i += 2) {
            Operator operator = new Operator(formula[i]);
            Operand operand = new Operand(formula[i + 1]);

            result = operator.compute(result, operand);
        }

        return result.getValue();
    }
}

