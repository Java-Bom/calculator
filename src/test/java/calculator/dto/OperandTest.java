package calculator.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OperandTest {
    @DisplayName("String 피연산자가 Operand로 변환")
    @Test
    void name() {
        String stringOperand = "123";
        Operand operand = new Operand(stringOperand);

    }
}