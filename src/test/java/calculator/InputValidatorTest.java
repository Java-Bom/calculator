package calculator;

import jdk.internal.jline.internal.Log;
import org.assertj.core.internal.bytebuddy.asm.Advice;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class InputValidatorTest {

    InputValidator inputValidator;

    @BeforeEach
    void setUp() {
        inputValidator = new InputValidator();
    }

    @Test
    @DisplayName("숫자 및 연산자 이외 문자열 입력 예외 발")
    void isUnknownInputStringError() {
        Throwable throwable = Assertions.assertThrows(UnknownInputException.class, () -> {
            inputValidator.isUnknownInputStringError("1 & 3");
        });
        assertEquals(throwable.getMessage(), "입력 값을 처리할 수 없습니다. 숫자와 연산자(+, -, *, /)만 입력해주세요.");
    }

    @Test
    void isContinuousOperatorError() {
    }

    @Test
    void isNumberAndOperatorCombinationError() {
    }

    @Test
    void isOperatorLocationError() {
    }
}