package calculator;

import java.util.ArrayList;

public class Calculator {
    private static int nextValueIndex = 1;

    public double callValue(ArrayList<String> operatorList, ArrayList<Integer> numberList){
        double result = numberList.get(0);
        for(int i = 0 ; i < operatorList.size() ; i++){
            result = calculateValue(result, numberList.get(nextValueIndex++),operatorList.get(i));
        }
        return result;
    }

    private double calculateValue(double result, int operand, String operator) {
        OperatorGroup findOperator = OperatorGroup.findByOperator(operator);
        return findOperator.calculate(result, operand);
    }
}
