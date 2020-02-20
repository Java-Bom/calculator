package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BasicCalculatorTest {
    CalculatorFactory basicCalculatorFactory;
    BasicCalculator basicCalculator;

    @BeforeEach
    void setUp() {
        basicCalculatorFactory = new BasicCalculatorFactory();
        basicCalculator = basicCalculatorFactory.makeBasicCalculator();
    }

    @Test
    void plus() {
        int result = basicCalculator.plus(1,1);
        assertEquals(result,2);
    }

    @Test
    void minus() {
        int result = basicCalculator.minus(1,1);
        assertEquals(result,0);
    }

    @Test
    void multiply() {
        int result = basicCalculator.multiply(7,1);
        assertEquals(result,7);
    }

    @Test
    void divide() {
        int result = basicCalculator.divide(3,2);
        assertEquals(result,1);
    }

}