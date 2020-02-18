package service;

import calculator.Calculator;

import java.util.Scanner;

public class CalculateService {

    private static final String DELIMITER = " ";

    private Calculator calculator;

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

    private void validateFormula(String[] splitedFormular) {
        if(splitedFormular.length % 2 == 0) {
            throw new IllegalArgumentException("올바른 수식이 아닙니다.");
        }
    }

}
