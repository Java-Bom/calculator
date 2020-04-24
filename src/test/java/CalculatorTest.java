import input.InputProcessor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class CalculatorTest {

    @DisplayName("입력값에 따른 계산")
    @ParameterizedTest
    @CsvSource(value = {"3+2/1,5.0", "2 + 3 * 4 / 2,10.0", " 1 + 2 ,3", "1 / 2, 0.5"})
    public void calculateTest(String input, double result) {
        InputProcessor inputProcessor = new InputProcessor(input);
        List<String> operators = inputProcessor.getOperators();
        List<Double> numbers = inputProcessor.getNumbers();
        assertThat(new Calculator().calculate(numbers, operators)).isEqualTo(result);
    }

}