package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SpliterTest {

    @DisplayName("숫자 배열 생성 정상 동작")
    @Test
    void getNumberArrTest(){
        Spliter spliter = new Spliter("1 + 2");
        int[] numberArrExpect = {1,2};
        assertThat(spliter.getNumberArr()).isEqualTo(numberArrExpect);
    }

    @DisplayName("잘못된 수식 점검")
    @Test
    void wrongInputTest(){
        String isNumber = "%";
        boolean expectBool = false;
        assertThat(Spliter.isRightNumber(isNumber)).isEqualTo(expectBool);
//      String errorMessage = "Input valid value";
//      assertThat(Spliter.checkValidity(expectBool,errorMessage)).isEqualTo(errorMessage);
    }

    @DisplayName("연산자 배열 생성 정상 동작")
    @Test
    void getOperatorArrTest(){
        Spliter spliter = new Spliter("1 / 2 * 5");
        String[] operatorArrExpect = {"/","*"};
        assertThat(spliter.getOperatorArr()).isEqualTo(operatorArrExpect);
    }

    @DisplayName("잘못된 연산자 점검")
    @Test
    void wrongOperatorTest(){
        String isOperator = "(";
        boolean expectBool = false;
        assertThat(Spliter.isRightOperator(isOperator)).isEqualTo(expectBool);
    }
}