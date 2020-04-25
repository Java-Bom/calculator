package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SplitterTest {

    @DisplayName("입력 값에대한 split이 잘 이뤄졌는지 수행한다.")
    @ParameterizedTest
    @ValueSource(strings = {"3 + 4 / 5 * 7"})
    public void split(String text) {
        assertTrue(Splitter.split(text).length == 7);
    }

    @DisplayName("입력 값의 길이가 잘못 됐을때 예외발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"3 + 4 / 5 *"})
    public void checkLength(String text) {
        assertThatThrownBy(() -> {
            Splitter.split(text);
        }).isInstanceOf(IllegalArgumentException.class).hasMessage("연산자와 피연산자의 수가 맞지않습니다.");
    }

    @DisplayName("입력 값중 연산자가 들어가야 할 부분에 다른 값이 들어갔을 경우 예외발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"3 + 4 / 5 & 7"})
    public void checkOperation(String text) {
        assertThatThrownBy(() -> {
            Splitter.split(text);
        }).isInstanceOf(IllegalArgumentException.class).hasMessage("정의되지 않은 연산자가 입력됐습니다.");
    }

    @DisplayName("입력 값중 피연산자가 들어가야 할 부분에 숫자가 아닌 값이 들어갔을 경우 예외발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = "3 + & / 5 * 7")
    public void checkOperand(String text) {
        assertThatThrownBy(() -> {
            Splitter.split(text);
        }).isInstanceOf(NumberFormatException.class).hasMessage("피연산자가 아닌 다른값이 입력됐습니다.");
    }
}
