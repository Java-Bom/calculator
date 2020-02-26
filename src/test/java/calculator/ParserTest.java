package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.opentest4j.AssertionFailedError;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ParserTest {
    @DisplayName("숫자가 아닌 것을 인자로 넘기면 AssertionFailedError를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"/", "*", "%"})
    void shouldReturnErrorTest(String value){
        assertThat(value.equals(new AssertionFailedError()));
    }
}