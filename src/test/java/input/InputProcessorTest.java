package input;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class InputProcessorTest {

    private final String BLANK = " ";

    @DisplayName("입력값 유효성 검사")
    @ParameterizedTest
    @ValueSource(strings = {"1 + 2 + ( )", " 1 ++ 1 +", "+ 1 + 2", "1 + aa + 1", "", " "})
    public void validInputStringTest(String input) {
        Assertions.assertThrows(IllegalArgumentException.class, ()-> new InputProcessor(input));
    }

    @DisplayName("입력값에 있는 빈칸 제거")
    @ParameterizedTest
    @ValueSource(strings = {"1 + 2 +   3", "  1 +  2  ", "1+ 2 ", " 1  "})
    public void removeBlank(String input) {
        assertThat(new InputProcessor(input).getExpression().contains(BLANK)).isFalse();
    }

    @DisplayName("입력값에 있는 연산자와 숫자 분리")
    @ParameterizedTest
    @CsvSource(value = {"1+2+3/2,  1232, ++/", "1 + 2 / 3 * 2, 1232,+/*", "5 + 2 * 5 * 6 / 2 - 3, 525623,+**/-"})
    public void splitOperatorAndNumbersTest(String input, String numbers, String operators) throws Exception {
        InputProcessor inputProcessor = new InputProcessor(input);
        List<Double> inputNumbers = Arrays.stream(numbers.split("")).map(
                Double::parseDouble).collect(Collectors.toList());
        List<String> inputOperators = Arrays.stream(operators.split("")).collect(Collectors.toList());
        assertThat(inputNumbers).isEqualTo(inputProcessor.getNumbers());
        assertThat(inputOperators).isEqualTo(inputProcessor.getOperators());
    }


}