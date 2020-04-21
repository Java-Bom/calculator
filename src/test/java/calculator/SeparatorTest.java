package calculator;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.assertj.core.api.Assertions.assertThat;

public class SeparatorTest {
    private Separator separator;

    @Before
    public void setUp() {
        separator = new Separator("2 + 5 / 7 * 6");
        separator.separate();
    }

    @DisplayName("연산자와 피연산자를 분리시켰을 때 초기화가 잘 됐는지 수행한다.")
    @Test
    public void init() {
        double[] expectOperand = separator.getArrayOperand();
        String[] expectOperation = separator.getArrayOperation();
        assertThat(expectOperand.length).isEqualTo(4);
        assertThat(expectOperation.length).isEqualTo(3);
    }

    @DisplayName("연산자와 피연산자로 분리시켰을 때 각각의 값이 알맞게 들어갔는지 수행한다.")
    @Test
    public void separateNumberAndOperation() {
        double[] expectOperand = separator.getArrayOperand();
        String[] expectOperation = separator.getArrayOperation();
        assertThat((int) expectOperand[0]).isEqualTo(2);
        assertThat(expectOperation[0]).isEqualTo("+");
    }
}
