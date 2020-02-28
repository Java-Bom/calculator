package calculator.value;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class NumberTest {

    @DisplayName("숫자가 아니면 Exception")
    @Test
    void numberConstructor() {
        // given
        String character = "a";

        // then
        assertThatThrownBy(() -> new Number(character))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("input string is not number");
    }
}