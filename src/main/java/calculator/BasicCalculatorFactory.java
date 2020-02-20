package calculator;

public class BasicCalculatorFactory extends CalculatorFactory {

    @Override
    public BasicCalculator makeBasicCalculator() {
        return new BasicCalculator();
    }
}
