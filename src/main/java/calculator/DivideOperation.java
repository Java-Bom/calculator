package calculator;

public class DivideOperation implements Operation {
    @Override
    public double execute(double fistOperand, double secondOperand) {
        if (bottomIsZero(secondOperand)) {
            throw new ArithmeticException();
        }
        return fistOperand / secondOperand;
    }

    private boolean bottomIsZero(double number) {
        return number == 0;
    }
}
