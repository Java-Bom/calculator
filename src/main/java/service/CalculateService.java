package service;

import calculator.Calculator;

import java.util.Scanner;

public class CalculateService {

    private static final String DELIMITER = " ";

    private Calculator calculator;

    public CalculateService(Calculator calculator) {
        this.calculator = calculator;
    }

    public String calculate(){
        String formula = receiveFormula();
        String[] spitedFormula = split(formula);

        return convertToString(calculator.calculate(spitedFormula));
    }

    private String convertToString(double result) {
        return String.format("%s", result);
    }

    // 입력을 어디서 받을까 ..
    private String receiveFormula(){
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
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
