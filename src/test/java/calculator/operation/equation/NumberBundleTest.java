package calculator.operation.equation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class NumberBundleTest {

    @DisplayName("숫자만 분리해서 저장")
    @Test
    void create() {
        //given
        List<String> splitEquation = Arrays.asList("1", "+", "2", "*", "6", "/", "9");
        List<String> numbers = Arrays.asList("1", "2", "6", "9");

        //when
        NumberBundle numberBundle = new NumberBundle(splitEquation);

        //then
        assertThat(numberBundle).isEqualTo(new NumberBundle(numbers));
    }

}