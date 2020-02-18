package calculator.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class OperatorTest {

    @DisplayName("String 연산자가 계산식을 들고있는 Operator로 변한다.")
    @Test
    void StringToOperator() {
        String stringOperator = "+";

        Operator operator = new Operator(stringOperator);

        assertAll(
                () -> assertThat(operator.getType()).isEqualTo(Operator.Type.PLUS),
                () -> {
                    String wrongOperator = "1";
                    assertThrows(IllegalArgumentException.class, () -> new Operator(wrongOperator)); //요건 테스트 용으로다가
                }
        );

    }
}