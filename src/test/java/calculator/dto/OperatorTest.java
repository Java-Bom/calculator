package calculator.dto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

class OperatorTest {


    @Test
    void StringToOperator(String input, String actual) {
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
