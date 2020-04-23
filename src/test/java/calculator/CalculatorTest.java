package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CalculatorTest {
    private Calculator calculator;

    @DisplayName("더하기 연산을 수행한다")
    @ParameterizedTest
    @ValueSource(strings = {"6 + 2 + 1"})
    public void PlusOperation(String text) {
        calculator = new Calculator(text);
        assertTrue(calculator.calculate() == 9);
    }

    @DisplayName("뺴기 연산을 수행한다")
    @ParameterizedTest
    @ValueSource(strings = {"6 - 2 - 1"})
    public void MinusOperation(String text) {
        calculator = new Calculator(text);
        assertTrue(calculator.calculate() == 3);
    }

    @DisplayName("곱하기 연산을 수행한다")
    @ParameterizedTest
    @ValueSource(strings = {"2 * 6"})
    public void MulOperation(String text) {
        calculator = new Calculator(text);
        assertTrue(calculator.calculate() == 12);
    }

    @DisplayName("나누기 연산을 수행한다")
    @ParameterizedTest
    @ValueSource(strings = {"6 / 2"})
    public void DivideOperation(String text) {
        calculator = new Calculator(text);
        assertTrue(calculator.calculate() == 3);
    }

    @DisplayName("나누기 연산할 때 분모의 값이 0일경우 예외발생시킨다")
    @ParameterizedTest
    @ValueSource(strings = {"3 / 0"})
    public void bottomIsZero(String text) {
        calculator = new Calculator(text);
        assertThatThrownBy(() -> {
            calculator.calculate();
        }).isInstanceOf(ArithmeticException.class).hasMessage("분모값이 0이면 안됩니다.");
    }
}
