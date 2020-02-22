package service;

import domain.Calculator;

public class CalculateService {

    private static final String DELIMITER = " ";

    private final Calculator calculator;

    public CalculateService(Calculator calculator) {
        this.calculator = calculator;
    }

    public double calculate(String formula) {
        String[] spitedFormula = split(formula);
        return calculator.calculate(spitedFormula);
    }

    private String[] split(String formula){
        String[] splitedFormula = formula.split(DELIMITER);
        validateFormula(splitedFormula);
        return splitedFormula;
    }

    private void validateFormula(String[] splitedFormula) {
        if(splitedFormula.length % 2 == 0) {
            throw new IllegalArgumentException("올바른 수식이 아닙니다.");
        }
    }

}
