package calculator;

public abstract class Calculator {
    public abstract int calculate(Integer result, String operator, String inputValue);
    public abstract int plus(Integer result, int operand);
    public abstract int minus(Integer result, int operand);
    public abstract int multiply(Integer result, int operand);
    public abstract int divide(Integer result, int operand);
}
