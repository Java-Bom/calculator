package calculator.value;

public class Number {

    private int value;

    public Number(String number) {
        try {
            this.value = Integer.parseInt(number);
        } catch (Exception e) {
            throw new RuntimeException("input string is not number");
        }
    }

    public Number(int number) {
        this.value = number;
    }

    public int getValue() {
        return value;
    }

    // 원래 터지는 익셉션이여도 따로 내가 터트리는게 더 나은것같다는 결론.
    // IllegalArgumentException 사용이 더 낫다
}
