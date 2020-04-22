import input.InputProcessor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

    @DisplayName("실제 연산이 잘 수행되는지 확인!")
    @Test
    public void calculateTest() throws Exception {
        // given
        String input = "2 + 3 * 4 / 2";
        String[] values = input.split(" ");
        InputProcessor processor = new InputProcessor();
        processor.splitOperatorsAndNumbers(values);
        Calculator calculator = new Calculator();
        List<String> operators = processor.operators;
        List<Double> numbers = processor.numbers;

        // when
        double result = calculator.calculate(operators, numbers);

        // then
        assertThat(10.0).isEqualTo(result);
    }

}