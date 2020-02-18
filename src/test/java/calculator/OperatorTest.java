package calculator;

import calculator.dto.Operator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class OperatorTest {

    @DisplayName("연산자를 체크하는 이넘")
    @Test
    void checkOperator(){
        String plus = "+";
        Expression expression = Operator.getExpress(plus);
        double result = expression.expression(6,3);

        assertThat(result).isEqualTo(9);
    }


}
