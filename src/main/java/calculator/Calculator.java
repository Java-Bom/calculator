package calculator;

//계산하는 역할만 하도록!!
public class Calculator {
    private static int nextValueIndex = 1;

    private double callValue(String[] operatorArr, int[] numberArr){
        double result = numberArr[0];
        for(int i = 0 ; i < operatorArr.length ; i++){
            result = calculateValue(result, numberArr[nextValueIndex++],operatorArr[i]);
        }
        return result;
    }

    private double calculateValue(double result, int operand, String operator) {
        OperatorGroup findOperator = OperatorGroup.findByOperator(operator);
        return findOperator.calculate(result, operand);
    }
}
