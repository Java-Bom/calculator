package calculator.operation.equation;

import calculator.operation.strategy.OperationGroup;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class OperatorBundleTest {

    @DisplayName("연산자만 모아서 저장")
    @Test
    void create() {
        //given
        List<String> splitEquation = Arrays.asList("1", "+", "2", "*", "6", "/", "9");
        List<String> operators = Arrays.asList("+", "*", "/");

        //when
        OperatorBundle operatorBundle = new OperatorBundle(splitEquation);

        //then
        assertThat(operatorBundle).isEqualTo(new OperatorBundle(operators));
    }

    @Test
    void isNotEmpty() {
        //given
        List<String> splitEquation = Arrays.asList("1", "+", "2");

        //when
        OperatorBundle operatorBundle = new OperatorBundle(splitEquation);

        //then
        assertThat(operatorBundle.isNotEmpty()).isTrue();
        assertThat(operatorBundle.getNextStrategy()).isEqualTo(OperationGroup.PLUS);
        assertThat(operatorBundle.isNotEmpty()).isFalse();
    }
}