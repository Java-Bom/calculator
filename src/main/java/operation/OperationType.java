package operation;

import java.util.HashMap;
import java.util.Map;

public enum     OperationType {
    PLUS("+") {
        public double operate(double x , double y) { return x + y; }
    },
    MINUS("-") {
        public double operate(double x, double y) { return x - y; }
    },
    TIMES("*") {
        public double operate(double x, double y) { return x * y; }
    },
    DIVIDE("/") {
        public double operate(double x, double y) {
            if (y == 0) {
                throw new ArithmeticException("0으로 나눌 수 없습니다.");
            }
            return x / y;
        }
    };

    private String symbol;
    private static final Map<String, OperationType> BY_SYMBOL = new HashMap<>();

    OperationType(String symbol) {
        this.symbol = symbol;
    }

    static {
        for (OperationType operationType : values()) {
            BY_SYMBOL.put(operationType.symbol, operationType);
        }
    }

    public static boolean isOperator(String symbol) {
        return BY_SYMBOL.containsKey(symbol);
    }

    public static OperationType getType(String symbol) {
        return BY_SYMBOL.get(symbol);
    }

    public abstract double operate(double x, double y);
}
