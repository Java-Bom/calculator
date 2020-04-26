package input;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SplitTest {

    @ParameterizedTest
    @DisplayName("입력값을 제대로 쪼개는지 확인")
    @CsvSource({"  1 + 3 +  2 + 5,1+3+2+5", "1  + 22 + 3 * 55,1+22+3*55", "1 + 2 + 33,1+2+33"})
    void getExpression(String input, String eachValues) {
        Split split = new Split(input);
        List<String> values = Arrays.stream(eachValues.split("")).collect(Collectors.toList());

        assertThat(values).isEqualTo(split.getExpression());
    }
}