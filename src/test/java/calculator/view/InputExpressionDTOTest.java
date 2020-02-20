package calculator.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class InputExpressionDTOTest {

    @DisplayName("객체 생성 테스트")
    @Test
    void construct1() {
        //given
        String expression = "1 + 2";

        //when
        InputExpressionDTO inputExpressionDTO = new InputExpressionDTO(expression);

        //then
        assertThat(inputExpressionDTO).isEqualTo(new InputExpressionDTO("1 + 2"));
    }

    @DisplayName("null 혹은 empty 입력값으로 객체 생성시 exception 발생")
    @ParameterizedTest
    @NullAndEmptySource
    void validateExpression(String nullAndEmptyExpression) {
        assertThatThrownBy(() -> new InputExpressionDTO(nullAndEmptyExpression))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력값이 비어 있습니다.");
    }
}