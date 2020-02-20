package calculator.operation.equation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class EquationTest {

    @DisplayName("계산결과 반환하기")
    @Test
    void getResult() {
        //given
        List<String> splitEquation = Arrays.asList("1", "+", "2", "*", "6", "/", "9");

        //when
        Equation equation = new Equation(splitEquation);

        //then
        assertThat(equation.getResult()).isEqualTo(2D);
    }
}