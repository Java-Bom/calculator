package calculator.value;

public class Number {

    private final int value;

    public Number(String number) {
        try {
            this.value = Integer.parseInt(number);
        } catch (Exception e) {
            throw new IllegalArgumentException("input string is not number");
        }
    }

    public Number(int number) {
        this.value = number;
    }

    public int getValue() {
        return value;
    }

    public Number plus(Number inputValue) {
        return new Number(this.value + inputValue.getValue());
    }

    public Number minus(Number inputValue) {
        return new Number(this.value - inputValue.getValue());
    }

    public Number multiply(Number inputValue) {
        return new Number(this.value * inputValue.getValue());
    }

    public Number divide(Number inputValue) {
        return new Number(this.value / inputValue.getValue());
    }
}
// 원래 터지는 익셉션이여도 따로 내가 터트리는게 더 나은것같다는 결론.