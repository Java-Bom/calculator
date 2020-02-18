package service;

import calculator.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CalculateServiceTest {

    @DisplayName("수식 문자열을 입력받아 순서대로 계산하는 서비스 테스트")
    @Test
    void calculate() {
        String formula = "1 + 2 / 3";
        Calculator calculator = new Calculator();
        CalculateService calculateService = new CalculateService(calculator);

        assertThat(calculateService.calculate(formula)).isEqualTo(1D);
    }

}
