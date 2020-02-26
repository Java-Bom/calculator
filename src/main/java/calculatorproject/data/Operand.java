package calculatorproject.data;

public class Operand {

    private final int value;

    public Operand(String number) {
            this.value = Integer.parseInt(number);
    }

    public Operand(int number) {
        this.value = number;
    }

    public int getValue() {
        return value;
    }

    public Operand plus(Operand inputValue) {
        return new Operand(this.value + inputValue.getValue());
    }

    public Operand minus(Operand inputValue) {
        return new Operand(this.value - inputValue.getValue());
    }

    public Operand multiply(Operand inputValue) {
        return new Operand(this.value * inputValue.getValue());
    }

    public Operand divide(Operand inputValue) {
        return new Operand(this.value / inputValue.getValue());
    }
}