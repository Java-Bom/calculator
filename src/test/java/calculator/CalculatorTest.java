package calculator;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    private Calculator calculator;

    @Before
    public void setup() {
        calculator = new Calculator();
    }

    @DisplayName("입력이 비었을때 0을 출력한다")
    @Test
    public void isEmpty() {
        assertThat(calculator.calculate("")).isEqualTo(0);
    }

    @DisplayName("더하기 연산을 수행한다")
    @Test
    public void AddOperation() {
        assertThat(calculator.calculate("1 + 2 + 6")).isEqualTo(9);
    }

    @DisplayName("뺴기 연산을 수행한다")
    @Test
    public void MinusOperation() {
        assertThat(calculator.calculate("6 - 2 - 1")).isEqualTo(3);
    }

    @DisplayName("곱하기 연산을 수행한다")
    @Test
    public void MulOperation() {
        assertThat(calculator.calculate("1 * 2 * 6")).isEqualTo(12);
    }

    @DisplayName("나누기 연산을 수행한다")
    @Test
    public void DivideOperation() {
        assertThat(calculator.calculate("6 / 2")).isEqualTo(3);
    }

    @DisplayName("나누기 연산할 때 분모의 값이 0일경우 예외발생시킨다")
    @Test(expected = ArithmeticException.class)
    public void bottomIsZero() {
        calculator.calculate("3 / 0");
    }
}
