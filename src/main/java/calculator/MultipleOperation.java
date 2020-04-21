package calculator;

public class MultipleOperation implements Operation {
    @Override
    public double execute(double fistOperand, double secondOperand) {
        return fistOperand * secondOperand;
    }
}
