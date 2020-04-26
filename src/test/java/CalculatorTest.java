import input.InputExpression;
import input.Split;
import operation.NumberPack;
import operation.OperatorPack;
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
        Split split = new Split(input);
        List<String> expression = split.getExpression();
        NumberPack numberPack = new NumberPack(expression);
        OperatorPack operatorPack = new OperatorPack(expression);
        assertThat(new Calculator().calculate(numberPack, operatorPack)).isEqualTo(result);
    }

}