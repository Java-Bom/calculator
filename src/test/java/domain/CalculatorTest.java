package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorTest {

    @DisplayName("수식 배열 계산 테스트")
    @Test
    void cal() {
        String formula = "1 + 2 * 3 / 3";
        Calculator calculator = new Calculator();

        double result = calculator.calculate(formula.split(" "));

        assertThat(result).isEqualTo(3D);
    }

    @DisplayName("Operand 자리에 잘못된 값이 들어갔을 뗴")
    @Test
    void cal_throw() {
        String formula = "가 + 2 * 3 / 3";
        Calculator calculator = new Calculator();

        assertThatThrownBy(() -> calculator.calculate(formula.split(" ")))
                .isInstanceOf(IllegalArgumentException.class);

    }


    @DisplayName("Operator 자리에 잘못된 값이 들어갔을 뗴")
    @Test
    void cal_throw_opt() {
        String formula = "1 @ 2 * 3 / 3";
        Calculator calculator = new Calculator();

        assertThatThrownBy(() -> calculator.calculate(formula.split(" ")))
                .isInstanceOf(IllegalArgumentException.class);

    }
}
