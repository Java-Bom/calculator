package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SeparatorTest {
    private SeparatedValue separatedValue;
    List<Double> expectedOperands;
    List<String> expectedOperations;

    @BeforeEach
    public void setUp() {
        separatedValue = new Separator("2 + 5 / 7 * 6").separateOperandAndOperation();

        expectedOperands = new ArrayList<>();
        expectedOperands.add(2.0);
        expectedOperands.add(5.0);
        expectedOperands.add(7.0);
        expectedOperands.add(6.0);

        expectedOperations = new ArrayList<>();
        expectedOperations.add("+");
        expectedOperations.add("/");
        expectedOperations.add("*");
    }

    @DisplayName("연산자와 피연산자를 분리시켰을 때 초기화가 잘 됐는지 수행한다.")
    @Test
    public void init() {
        assertThat(separatedValue.getOperands().size()).isEqualTo(expectedOperands.size());
        assertThat(separatedValue.getOperations().size()).isEqualTo(expectedOperations.size());
    }

    @DisplayName("연산자와 피연산자로 분리시켰을 때 각각의 값이 알맞게 들어갔는지 수행한다.")
    @Test
    public void separateNumberAndOperation() {
        assertThat(separatedValue.getOperands().get(1)).isEqualTo(expectedOperands.get(1));
        assertThat(separatedValue.getOperations().get(2)).isEqualTo(expectedOperations.get(2));
    }
}
