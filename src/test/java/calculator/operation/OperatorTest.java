package calculator.operation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OperatorTest {

    @DisplayName("올바르지 않은 연산자 입력시")
    @ParameterizedTest
    @ValueSource(strings = {"1", "a"})
    void getOperatorThrowException(String notOperator) {
        assertThatThrownBy(() -> Operator.valueOf(notOperator))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("%s : 올바르지 않은 연산자 입니다.", notOperator);
    }

    @DisplayName("불변 연산자 객체")
    @ParameterizedTest
    @ValueSource(strings = {"+", "-", "*", "/"})
    void valueOf(String correctOperator) {
        Operator operator = Operator.valueOf(correctOperator);

        assertThat(operator).isEqualTo(Operator.valueOf(correctOperator));
    }
}