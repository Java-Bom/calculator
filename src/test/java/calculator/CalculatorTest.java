package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class CalculatorTest {

    @DisplayName("올바른 식을 넣으면 올바른 계산 결과를 리턴한다.")
    @Test
    void calcualteValueTest(){
//        2 + 3 * 4 / 2 - 2
        ArrayList<String> operatorList = (ArrayList<String>) Arrays.asList(new String[]{"+","*","/","-"});
        ArrayList<Integer> numberList = (ArrayList<Integer>) Arrays.asList(new Integer[]{2,3,4,2,2});
        Calculator calculator = new Calculator();
        assertThat(calculator.callValue(operatorList,numberList)).isEqualTo(8.0);
    }
}