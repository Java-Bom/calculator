package input;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class InputProcessorTest {

    @Test
    public void validInputStringTest() throws Exception {
        // given
        String input = "";
        String[] values = input.split(" ");
        System.out.println(values.length);
        InputProcessor processor = new InputProcessor();

        // then
        Assertions.assertThrows(IllegalArgumentException.class,() -> processor.validInputString(values));
    }

    @Test
    @DisplayName("입력값이 숫자와 연산자로 잘 분리 되는지 확인!")
    public void splitOperatorsAndNumbersTest() throws Exception {
        // given
        String input = "2 + 3 * 4 / 2";
        String[] values = input.split(" ");
        InputProcessor processor = new InputProcessor();
        processor.splitOperatorsAndNumbers(values);

        // when
        List<Double> numbers = processor.numbers;
        List<String> operators = processor.operators;

        // then
        assertThat(3).isEqualTo(operators.size());
        assertThat(4).isEqualTo(numbers.size());
        assertThat(2.0).isEqualTo(numbers.get(0));
        assertThat(2.0).isEqualTo(numbers.get(numbers.size()-1));
        assertThat("+").isEqualTo(operators.get(0));
        assertThat("/").isEqualTo(operators.get(operators.size()-1));
    }
}