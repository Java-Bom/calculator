package calculator;

public class AddOperation implements Operation {
    @Override
    public double execute(double fistOperand, double secondOperand) {
        return fistOperand + secondOperand;
    }
}
