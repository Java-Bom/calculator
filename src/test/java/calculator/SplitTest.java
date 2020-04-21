package calculator;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.assertj.core.api.Assertions.assertThat;

public class SplitTest {


    @DisplayName("입력 값에대한 split이 잘 이뤄졌는지 수행한다.")
    @Test
    public void split() {
        Split split = new Split("3 + 4 / 5 * 7");
        assertThat(split.split().length).isEqualTo(7);
    }

    @DisplayName("입력 값의 길이가 잘못 됐을때 예외발생시킨다.")
    @Test(expected = IllegalArgumentException.class)
    public void checkLength() {
        Split split = new Split("3 + 4 / 5 *");
        split.split();
    }

    @DisplayName("입력 값중 연산자가 들어가야 할 부분에 다른 값이 들어갔을 경우 예외발생시킨다.")
    @Test(expected = IllegalArgumentException.class)
    public void checkOperation() {
        Split split = new Split("3 + 4 / 5 & 7");
        split.split();
    }

    @DisplayName("입력 값중 피연산자가 들어가야 할 부분에 숫자가 아닌 값이 들어갔을 경우 예외발생시킨다.")
    @Test(expected = NumberFormatException.class)
    public void checkOperand() {
        Split split = new Split("3 + & / 5 * 7");
        split.split();
    }
}
