package calculator.operation.strategy;

import calculator.operation.equation.Number;
import calculator.operation.equation.Operator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class OperatorGroupTest {

    @DisplayName("입력받은 연산자에 따라 입력 전략 찾기")
    @ParameterizedTest
    @CsvSource(value = {"+,PLUS", "-,MINUS", "*,MULTIPLE", "/,DIVIDE"})
    void findByToken(String token, OperatorGroup result) {
        Operator operator = Operator.valueOf(token);

        assertThat(OperatorGroup.findByToken(operator)).isEqualTo(result);
    }

    @DisplayName("입력전략에 따른 계산")
    @ParameterizedTest
    @CsvSource(value = {"3,3,PLUS,6", "3,3,MINUS,0", "3,3,MULTIPLE,9", "3,3,DIVIDE,1"})
    void operate(String operand1, String operand2, OperatorGroup operatorGroup, String result) {
        Number number1 = Number.valueOf(operand1);
        Number number2 = Number.valueOf(operand2);

        Number resultNumber = Number.valueOf(result);

        Number expect = operatorGroup.operate(number1, number2);

        assertThat(expect).isEqualTo(resultNumber);
    }
}