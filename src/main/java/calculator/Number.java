package calculator;

public class Number {

    private int value;

    Number(String number) {
        try {
            this.value = Integer.parseInt(number);
        } catch (Exception e) {
            throw new RuntimeException("input string is not number");
        }
    }

    Number(int number) {
        this.value = number;
    }

    public int getValue() {
        return value;
    }

    // 자바는 연산자 오버로딩은 지원하지 않나요 ?????
}
