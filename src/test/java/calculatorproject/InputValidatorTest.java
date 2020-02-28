package calculatorproject;

import calculatorproject.exception.ContinuousOperatorException;
import calculatorproject.exception.NumberAndOperatorCombinationException;
import calculatorproject.exception.OperatorLocationException;
import calculatorproject.exception.UnknownInputException;
import calculatorproject.input.InputValidator;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidatorTest {

    InputValidator inputValidator;

    @BeforeEach
    void setUp() {
        inputValidator = new InputValidator();
    }

    @Test
    @DisplayName("숫자 및 연산자 이외 문자열 입력 예외 발생")
    void isUnknownInputStringError() {
        String input = "1 + 2 & 3";
        assertThatThrownBy(() -> inputValidator.isUnknownInputStringError(input))
                .isInstanceOf(UnknownInputException.class)
                .hasMessage("입력 값을 처리할 수 없습니다. 숫자와 연산자(+, -, *, /)만 입력해주세요.");
    }
    @Test
    @DisplayName("연산자를 연속 사용")
    void isContinuousOperatorError() {
        String input = "1 + + 3";
        assertThatThrownBy(() -> inputValidator.isContinuousOperatorError(input))
                .isInstanceOf(ContinuousOperatorException.class)
                .hasMessage("연산자를 연속하여 사용할 수 없습니다.");
    }

    @Test
    @DisplayName("1+233 과 같이 연산자와 숫자가 조합되어 있는 문자열 사용")
    void isNumberAndOperatorCombinationError() {
        String input = "1+233 + 5689";
        assertThatThrownBy(() -> inputValidator.isNumberAndOperatorCombinationError(input))
                .isInstanceOf(NumberAndOperatorCombinationException.class)
                .hasMessage("입력 값에 숫자 또는 연산자가 아닌 문자열이 포함되어 있습니다.");
    }

    @Test
    @DisplayName("연산자 위치 에러")
    void isOperatorLocationError() {
        String input = "2 + 1 -";
        assertThatThrownBy(() -> inputValidator.isOperatorLocationError(input))
                .isInstanceOf(OperatorLocationException.class)
                .hasMessage("연산자의 앞, 뒤 문자열에는 숫자가 와야합니다.");
    }
}