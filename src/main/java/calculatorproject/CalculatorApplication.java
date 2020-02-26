package calculatorproject;

import calculatorproject.data.*;
import calculatorproject.data.Operand;
import calculatorproject.input.Input;

public class CalculatorApplication {
    public static final int INDEX_FOR_FIRST_OPERAND = 0;
    public static void main(String[] args) {
        String[] inputArray = Input.split();

        Operand result = new Operand(inputArray[INDEX_FOR_FIRST_OPERAND]);

        for (int index = 1; index < inputArray.length; index += 2) {
            Operator operator = new Operator(inputArray[index]);
            Operand operand = new Operand(Integer.parseInt(inputArray[index+1]));

            result = operator.calculate(result,operand);
        }
        System.out.println(result.getValue());
    }
}