package calculatorproject.strategy;

import calculatorproject.data.Operand;

public interface CalculateStrategy {
    Operand calculate(Operand operand1, Operand operand2);
}
