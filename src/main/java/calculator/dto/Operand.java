package calculator.dto;

public class Operand {

    private double operand;

    public Operand(String operand) {
        try {
            this.operand = Double.parseDouble(operand);
        } catch (NumberFormatException ne) {
            throw new IllegalArgumentException("숫자가 아닌 값입니다!");
        }
    }

    public double getOperand() {
        return operand;
    }


}
