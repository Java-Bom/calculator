package calculatorproject.data;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class OperatorTest {
    Operator operator;

    @Test
    @DisplayName("덧셈")
    void plus() {
        operator = new Operator("+");
        assertThat(operator.operatorGroup.calculateStrategy.calculate(new Operand(1), new Operand(2)).getValue()).isEqualTo(3);
    }

    @Test
    @DisplayName("뺄셈")
    void minus() {
        operator = new Operator("-");
        assertThat(operator.operatorGroup.calculateStrategy.calculate(new Operand(3), new Operand(2)).getValue()).isEqualTo(1);
    }

    @Test
    @DisplayName("곱셈")
    void multiply() {
        operator = new Operator("*");
        assertThat(operator.operatorGroup.calculateStrategy.calculate(new Operand(1), new Operand(2)).getValue()).isEqualTo(2);
    }

    @Test
    @DisplayName("나눗셈")
    void divide() {
        operator = new Operator("/");
        assertThat(operator.operatorGroup.calculateStrategy.calculate(new Operand(4), new Operand(2)).getValue()).isEqualTo(2);
    }
}