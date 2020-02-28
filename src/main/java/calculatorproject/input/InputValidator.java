package calculatorproject.input;

import calculatorproject.exception.ContinuousOperatorException;
import calculatorproject.exception.NumberAndOperatorCombinationException;
import calculatorproject.exception.OperatorLocationException;
import calculatorproject.exception.UnknownInputException;

import java.util.Arrays;

public class InputValidator {


    public boolean validateInput(String input) {
        if (isUnknownInputStringError(input)) {
            return true;
        }
        if (isContinuousOperatorError(input)) {
            return true;
        }

        if (isNumberAndOperatorCombinationError(input)) {
            return true;
        }
        if (isOperatorLocationError(input)) {
            return true;
        }
        return false;
    }

    public boolean isUnknownInputStringError(String input) {
        String invalidString = input.replaceAll("[[+]-[*]/[0-9]]", "").trim();
        if (invalidString.length() > 0) {
            throw new UnknownInputException("입력 값을 처리할 수 없습니다. 숫자와 연산자(+, -, *, /)만 입력해주세요.");
        }
        return false;
    }

    public boolean isContinuousOperatorError(String input) {
        String trimString = input.replaceAll(" ", "");
        if (trimString.contains("++") || trimString.contains("+-") || trimString.contains("+*") || trimString.contains("+/")
                || trimString.contains("-+") || trimString.contains("--") || trimString.contains("-*") || trimString.contains("-/")
                || trimString.contains("*+") || trimString.contains("*-") || trimString.contains("**") || trimString.contains("*/")
                || trimString.contains("/+") || trimString.contains("/-") || trimString.contains("/*") || trimString.contains("//")
        ) {
            throw new ContinuousOperatorException("연산자를 연속하여 사용할 수 없습니다.");
        }
        return false;
    }

    public boolean isNumberAndOperatorCombinationError(String input) {
        String DELIMITER = " ";
        String[] inputArray = input.split(DELIMITER);
        for (String inputValue : inputArray) {
            String number = inputValue.replaceAll("[[+]-[*]/]", "").trim();
            String operator = inputValue.replaceAll("[0-9]", "").trim();
            if (number.length() > 0 && operator.length() > 0) {
                throw new NumberAndOperatorCombinationException("입력 값에 숫자 또는 연산자가 아닌 문자열이 포함되어 있습니다.");
            }
        }
        return false;
    }

    public boolean isOperatorLocationError(String input) {
        String trimString = input.replaceAll(" ", "");
        int START_POINT = 0;
        int END_POINT = trimString.length() - 1;

        if ((Arrays.asList('+', '-', '/', '*').contains(trimString.toCharArray()[START_POINT]))
                || (Arrays.asList('+', '-', '/', '*').contains(trimString.toCharArray()[END_POINT]))) {
            throw new OperatorLocationException("연산자의 앞, 뒤 문자열에는 숫자가 와야합니다.");
        }
        return false;
    }

}
