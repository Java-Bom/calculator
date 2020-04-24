package operation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OperationTest {

    @DisplayName("Operation Enum 객체에서 실제 연산이 잘 수행되는지 확인!")
    @Test
    public void testApply() throws Exception {
        // given
        double x = 1.0;
        double y = 2.0;

        // when
        double resultPlus = Operation.PLUS.apply(x, y);
        double resultMinus = Operation.MINUS.apply(x, y);
        double resultTimes = Operation.TIMES.apply(x, y);
        double resultDivide = Operation.DIVIDE.apply(x, y);

        // then
        assertThat(x+y).isEqualTo(resultPlus);
        assertThat(x-y).isEqualTo(resultMinus);
        assertThat(x*y).isEqualTo(resultTimes);
        assertThat(x/y).isEqualTo(resultDivide);
    }

    @DisplayName("Operation Enum 객체에서 0으로 나눌시 예외 처리 되는지 확인!")
    @Test
    public void testZeroDivide() throws Exception {
        // given
        double x = 1.0;
        double y = 0.0;

        // then
        Assertions.assertThrows(ArithmeticException.class, () -> Operation.DIVIDE.apply(x, y));
    }

}