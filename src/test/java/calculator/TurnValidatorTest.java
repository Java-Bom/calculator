package calculator;

import org.assertj.core.api.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TurnValidatorTest {
    TurnValidator turnValidator;
    @BeforeEach
    void setUp() {
        turnValidator = new TurnValidator();
    }

    @Test
    void isFirstNumber() {
        boolean result = turnValidator.isFirstNumber(null);
        assertEquals(result, true);
    }

    @Test
    void isOperator() {
        boolean result = turnValidator.isOperator("*");
        assertEquals(result, true);
    }
}