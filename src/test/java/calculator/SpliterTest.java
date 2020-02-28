package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.opentest4j.AssertionFailedError;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SpliterTest {
    private final Spliter spliter = new Spliter();

    @DisplayName("올바른 식을 넣으면 연산자와 숫자를 분리해준다.")
    @Test
    void shouldSplitValueTest(){
        //given
        String inputValue = "1 + 2 / 3 * 4 + 5";

        //when
        ArrayList<Integer> numberList = (ArrayList<Integer>) Arrays.asList(new Integer[]{1,2,3,4,5});
        ArrayList<String> operatorList = (ArrayList<String>) Arrays.asList(new String[]{"+","/","*","+"});

        //then
        assertThat(spliter.splitNumbers(inputValue)).isEqualTo(numberList);
        assertThat(spliter.splitOperators(inputValue)).isEqualTo(operatorList);

    }

    @DisplayName("잘못된 수식을 넣으면 에러를 보이며 종료한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1 2 + 3", "1 % 2", "1 * / 1"})
    void shouldReturnErrorTest(String value){
        assertThat(value.equals(new AssertionFailedError()));
    }
}