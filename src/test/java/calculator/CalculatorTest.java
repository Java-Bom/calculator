package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @DisplayName("문자열 계산 정상동작")
    @Test
    void calc() {
        String expression = "1 + 3 / 4";
        Calculator calculator = new Calculator();
        assertThat(calculator.calc(expression)).isEqualTo(1);
    }

    @DisplayName("잘못된 수식 입력시 예외")
    @Test
    void calc_throw_exception() {
        String expression = "1 + 3 /";
        Calculator calculator = new Calculator();
        assertThrows(IllegalArgumentException.class,() -> calculator.calc(expression));
    }
}