package domain.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

class OperatorTest {


    @DisplayName("String 연산자가 Operator 클래스로 매핑")
    @CsvSource({"+", "-", "*", "/"})
    @ParameterizedTest
    void StringToOperator(String input) {
        Operator operator = new Operator(input);

        assertThat(operator.getType()).isIn(Operator.Type.values());

    }

    @DisplayName("올바른 연산자가 아니면 Exception")
    @CsvSource({"1", "asdf", "="})
    @ParameterizedTest
    void StringToOpeartorFail(String input) {
        assertThatThrownBy(() -> new Operator(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
