package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    @DisplayName("입력에 따른 계산")
    @Test
    void calculateWith() {
        // given
        List<String> splitString = Arrays.asList("2", "+", "3", "*", "4", "/", "2");

        // when
        int result = StringCalculator.calculateWith(splitString);

        // then
        assertThat(result).isEqualTo(10);
    }
}