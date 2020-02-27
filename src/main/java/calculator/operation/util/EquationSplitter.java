package calculator.operation.util;

import java.util.Arrays;
import java.util.List;

public final class EquationSplitter {
    private static final String DELIMITER = " ";
    private static final String NULL_OR_EMPTY_EXCEPTION_MESSAGE = "%s : 입력식이 비어있습니다.";

    public static List<String> split(String equation) {
        validateEmpty(equation);
        return Arrays.asList(equation.split(DELIMITER));
    }

    private static void validateEmpty(String equation) {
        if (isEmpty(equation)) {
            throw new IllegalArgumentException(String.format(NULL_OR_EMPTY_EXCEPTION_MESSAGE, equation));
        }
    }

    private static boolean isEmpty(String equation) {
        return equation == null || equation.trim().isEmpty();
    }
}
