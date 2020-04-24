package operation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class OperationTypeTest {


    @ParameterizedTest
    @DisplayName("열거 타입으로 변환")
    @CsvSource(value = {"+,PLUS", "-,MINUS", "*,TIMES", "/,DIVIDE"})
    public void getOperationTypeTest(String symbol, String type) {
        assertThat(OperationType.getType(symbol).toString()).isEqualTo(type);
    }

    @ParameterizedTest
    @DisplayName("연산자인지 판별")
    @ValueSource(strings = {"/", "*", "-", "+"})
    public void isOperatorTest(String operators) {
        // given
        assertThat(OperationType.isOperator(operators)).isTrue();
        String alpha = "a";
        assertThat(OperationType.isOperator(alpha)).isFalse();
        String number = "1";
        assertThat(OperationType.isOperator(number)).isFalse();

    }

    @ParameterizedTest
    @DisplayName("덧셈 연산 동작")
    @CsvSource(value = {"4,6, 10", "1,9, 10", "10,0, 10", "1,-1,0", "0,5,5"})
    public void plusOperationTest(double x, double y, double result){
        assertThat(OperationType.PLUS.operate(x, y)).isEqualTo(result);
    }

    @ParameterizedTest
    @DisplayName("뺄셈 연산 동작")
    @CsvSource(value = {"4,6,-2", "1,9,-8", "10,0,10", "1,-1,2", "0,5,-5"})
    public void minusOperationTest(double x, double y, double result) {
        assertThat(OperationType.MINUS.operate(x, y)).isEqualTo(result);
    }

    @ParameterizedTest
    @DisplayName("곱셈 연산 동작")
    @CsvSource(value = {"4,6,24", "1,9,9", "10,0,0", "1,-1,-1", "10,5,50"})
    public void timesOperationTest(double x, double y, double result) {
        // given
        assertThat(OperationType.TIMES.operate(x, y)).isEqualTo(result);
    }

    @ParameterizedTest
    @DisplayName("나눗셈 연산 동")
    @CsvSource(value = {"2,1,2", "1,2,0.5", "10,1,10", "1,-1,-1", "10,5,2"})
    public void divideOperationTest(double x, double y, double result) {
        // given
        assertThat(OperationType.DIVIDE.operate(x, y)).isEqualTo(result);
        double a = 1;
        double b = 0;
        Assertions.assertThrows(ArithmeticException.class, () -> OperationType.DIVIDE.operate(a ,b));
    }
}