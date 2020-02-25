package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class CalculatorTest {

    @DisplayName("계산 결과값 점검")
    @Test
    void calcualteValueTest(){
//        2 + 3 * 4 / 2 - 2
        String[] operatorArr = {"+","*","/","-"};
        int[] numberArr = {2,3,4,2,2};
//        Calculator calculator = new Calculator(operatorArr,numberArr);
//        assertThat(calculator).isEqualTo(8.0);
    }

//    @ParameterizedTest
//    @CsvSource("1,2,-,-1")
//

}