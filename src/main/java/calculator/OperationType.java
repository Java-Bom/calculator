package calculator;

import java.util.HashMap;
import java.util.Map;

public enum OperationType {
    PLUS("+") {
        @Override
        double execute(double firstOperand, double secondOperand) {
            return firstOperand + secondOperand;
        }
    },
    MINUS("-") {
        @Override
        double execute(double firstOperand, double secondOperand) {
            return firstOperand - secondOperand;
        }
    },
    MULTIPLE("*") {
        @Override
        double execute(double firstOperand, double secondOperand) {
            return firstOperand * secondOperand;
        }
    },
    DIVIDE("/") {
        @Override
        double execute(double firstOperand, double secondOperand) {
            if (bottomIsZero(secondOperand)) {
                throw new ArithmeticException("분모값이 0이면 안됩니다.");
            }
            return firstOperand / secondOperand;
        }
    };

    private static final Map<String, OperationType> BY_OPERATION = new HashMap<>();

    static {
        for (OperationType type : values()) {
            BY_OPERATION.put(type.operation, type);
        }
    }

    public final String operation;

    OperationType(String operation) {
        this.operation = operation;
    }

    public static OperationType valueOfOperation(String operation) {
        return BY_OPERATION.get(operation);
    }

    public static boolean hasNotContain(String operation) {
        return !BY_OPERATION.containsKey(operation);
    }

    boolean bottomIsZero(double secondOperand) {
        return secondOperand == 0;
    }

    abstract double execute(double firstOperand, double secondOperand);
}

