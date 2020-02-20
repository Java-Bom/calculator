package calculator.operation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class OperationGroupTest {

    @DisplayName("입력받은 연산자에 따라 입력 전략 찾기")
    @ParameterizedTest
    @CsvSource(value = {"+,PLUS", "-,MINUS", "*,MULTIPLE", "/,DIVIDE"})
    void findByToken(String operator, OperationGroup result) {
        assertThat(OperationGroup.findByToken(operator)).isEqualTo(result);
    }

    @DisplayName("입력전략에 따른 계산")
    @ParameterizedTest
    @CsvSource(value = {"3,3,PLUS,6", "3,3,MINUS,0", "3,3,MULTIPLE,9", "3,3,DIVIDE,1"})
    void operate(double operand1, double operand2, OperationGroup operationGroup, double result) {
        double expect = operationGroup.operate(operand1, operand2);

        assertThat(expect).isEqualTo(result);
    }
}