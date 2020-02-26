package calculator.value;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class OperatorTest {

    @DisplayName("연산자가 아닌경우 Exception")
    @Test
    void operatorConstructor() {
        // given
        String character = "a";

        // then
        assertThatThrownBy(() -> new Operator(character))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("operator 계산 잘 되는지 확인")
    @Test
    void calculate() {
        // given
        Operator operator = new Operator("+");
        Number number1 = new Number("5");
        Number number2 = new Number("8");

        // when
        Number result = operator.calculate(number1, number2);

        // then
        assertThat(result.getValue()).isEqualTo(13);
    }
}