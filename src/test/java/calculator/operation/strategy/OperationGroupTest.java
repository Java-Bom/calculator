package calculator.operation.strategy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @DisplayName("없는 연산자로 입력 전략을 찾으려하는 경우 Exception")
    @Test
    void notFountException() {
        //given
        String notExistOperation = "@";

        //then
        assertThatThrownBy(() -> OperationGroup.findByToken(notExistOperation))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("%s : 존재하지 않는 토큰입니다.", notExistOperation);
    }
}