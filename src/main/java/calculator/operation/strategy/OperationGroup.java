package calculator.operation.strategy;

import java.util.Arrays;

public enum OperationGroup {
    PLUS("+", Double::sum),
    MINUS("-", (firstOperand, secondOperand) -> firstOperand - secondOperand),
    MULTIPLE("*", (firstOperand, secondOperand) -> firstOperand * secondOperand),
    DIVIDE("/", (firstOperand, secondOperand) -> firstOperand / secondOperand);

    private static final String NOT_FOUND_TOKEN_EXCEPTION_MESSAGE = "%s : 존재하지 않는 토큰입니다.";

    private final String token;
    private final OperationStrategy strategy;

    OperationGroup(String token, OperationStrategy strategy) {
        this.token = token;
        this.strategy = strategy;
    }

    public static OperationGroup findByToken(String token) {
        return Arrays.stream(values())
                .filter(aOperation -> aOperation.isEqualToken(token))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format(NOT_FOUND_TOKEN_EXCEPTION_MESSAGE, token)));
    }

    private boolean isEqualToken(String token) {
        return this.token.equals(token);
    }

    public double operate(double firstOperand, double secondOperand) {
        return this.strategy.operate(firstOperand, secondOperand);
    }
}
