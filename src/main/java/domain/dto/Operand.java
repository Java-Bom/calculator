package domain.dto;

public class Operand {

    private double value;

    public Operand(String operand) {
        try {
            this.value = Double.parseDouble(operand);
        } catch (NumberFormatException ne) {
            throw new IllegalArgumentException("숫자가 아닌 값입니다!");
        }
    }

    public Operand(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
