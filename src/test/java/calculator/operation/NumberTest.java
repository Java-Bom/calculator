package calculator.operation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumberTest {

    @DisplayName("숫자가 아닌 입력시 Exception")
    @Test
    void getValue() {
        //given
        String notDouble = "a";

        //then
        assertThatThrownBy(() -> Number.valueOf(notDouble))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("%s : 입력한 값은 숫자가 아닙니다.", notDouble);
    }

    @DisplayName("불변 숫자 생성")
    @Test
    void equals() {
        //given
        String doubleValue = "1";

        //when
        Number number = Number.valueOf(doubleValue);

        //then
        assertThat(number).isEqualTo(Number.valueOf("1"));
    }
}