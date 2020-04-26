package operation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public enum Operation {
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
    private static final Map<String, Operation> BY_SYMBOL = new HashMap<>();

    Operation(String symbol) {
        this.symbol = symbol;
    }

    static {
        for (Operation operation : values()) {
            BY_SYMBOL.put(operation.symbol, operation);
        }
    }

    public static Operation getType(String symbol) {
        return BY_SYMBOL.get(symbol);
    }

    public abstract double operate(double x, double y);
}
