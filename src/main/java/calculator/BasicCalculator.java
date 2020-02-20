package calculator;

public class BasicCalculator extends Calculator {

    @Override
    public int calculate(Integer result, String operator, String inputValue) {

        int operand = Integer.parseInt(inputValue);

        if("+".equals(operator)){
            return plus(result,operand);
        }
        if("-".equals(operator)){
            return minus(result,operand);
        }
        if("*".equals(operator)){
            return multiply(result,operand);
        }
        return divide(result, operand);
    }

    @Override
    public int plus(Integer result, int operand) {
        return result+operand;
    }

    @Override
    public int minus(Integer result, int operand) {
        return result-operand;
    }

    @Override
    public int multiply(Integer result, int operand) {
        return result*operand;
    }

    @Override
    public int divide(Integer result, int operand) {
        try{
            result = result/operand;
        }catch (ArithmeticException e){
            e.printStackTrace();
        }
        return result;
    }
}
