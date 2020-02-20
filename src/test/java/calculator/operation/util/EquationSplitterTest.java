package calculator.operation.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class EquationSplitterTest {

    @DisplayName("문자열 분리 성공")
    @Test
    void split() {
        //given
        String equation = "1 + 2";

        //when
        List<String> splitEquation = EquationSplitter.split(equation);

        //then
        assertThat(splitEquation).containsExactly("1", "+", "2");
    }

    @DisplayName("널, 빈 문자열 입력시 Exception 발생")
    @ParameterizedTest
    @NullAndEmptySource
    void inputEmptyOrNullThenThrowException(String nullOrEmptyEquation) {
        assertThatThrownBy(() -> EquationSplitter.split(nullOrEmptyEquation))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("%s : 입력식이 비어있습니다.", nullOrEmptyEquation);
    }
}