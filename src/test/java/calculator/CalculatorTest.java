package calculator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {
    private Calculator calculator;

    @Before
    public void setup() {
        calculator = new Calculator();
    }

    @Test
    public void isEmptyOrNull() {
        assertEquals(0, calculator.calculate(""));
        assertEquals(0, calculator.calculate(null));
    }

    /*@Test
    public void split() {
        assertArrayEquals(new String[]{"1","+","4","*","5"}, calculator.split("1 + 4 * 5"));
    }*/

    /*@Test
    public void separateNumberAndOperation()
    {
        String[][] expector = new String[2][3];
        expector[0][0] = "1";
        expector[0][1] = "4";
        expector[0][2] = "5";
        expector[1][0] = "+";
        expector[1][1] = "*";
        assertArrayEquals(expector, calculator.separateNumberAndOperation(new String[]{"1", "+", "4" ,"*" ,"5"}));
    }*/

    @Test
    public void initNumberAndOperation() {
    }
}
