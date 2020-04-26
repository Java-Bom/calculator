package operation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class OperationTest {


    @ParameterizedTest
    @DisplayName("열거 타입으로 변환")
    @CsvSource(value = {"+,PLUS", "-,MINUS", "*,TIMES", "/,DIVIDE"})
    public void getOperationTypeTest(String symbol, String type) {
        assertThat(Operation.getType(symbol).toString()).isEqualTo(type);
    }

    @ParameterizedTest
    @DisplayName("덧셈 연산 동작")
    @CsvSource(value = {"4,6, 10", "1,9, 10", "10,0, 10", "1,-1,0", "0,5,5"})
    public void plusOperationTest(double x, double y, double result){
        assertThat(Operation.PLUS.operate(x, y)).isEqualTo(result);
    }

    @ParameterizedTest
    @DisplayName("뺄셈 연산 동작")
    @CsvSource(value = {"4,6,-2", "1,9,-8", "10,0,10", "1,-1,2", "0,5,-5"})
    public void minusOperationTest(double x, double y, double result) {
        assertThat(Operation.MINUS.operate(x, y)).isEqualTo(result);
    }

    @ParameterizedTest
    @DisplayName("곱셈 연산 동작")
    @CsvSource(value = {"4,6,24", "1,9,9", "10,0,0", "1,-1,-1", "10,5,50"})
    public void timesOperationTest(double x, double y, double result) {
        // given
        assertThat(Operation.TIMES.operate(x, y)).isEqualTo(result);
    }

    @ParameterizedTest
    @DisplayName("나눗셈 연산 동")
    @CsvSource(value = {"2,1,2", "1,2,0.5", "10,1,10", "1,-1,-1", "10,5,2"})
    public void divideOperationTest(double x, double y, double result) {
        // given
        assertThat(Operation.DIVIDE.operate(x, y)).isEqualTo(result);
        double a = 1;
        double b = 0;
        Assertions.assertThrows(ArithmeticException.class, () -> Operation.DIVIDE.operate(a ,b));
    }
}