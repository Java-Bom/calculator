package calculator;

import java.util.HashMap;
import java.util.Map;

public class OperationTypeMapping {
    private static Map<String, OperationType> operationType = new HashMap<>();

    static {
        operationType.put("+", OperationType.PLUS);
        operationType.put("-", OperationType.MINUS);
        operationType.put("*", OperationType.MULTIPLE);
        operationType.put("/", OperationType.DIVIDE);
    }

    public static OperationType getOperationType(String operation) {
        return operationType.get(operation);
    }

    public boolean isNotOperation(String operation) {
        return !operationType.containsKey(operation);
    }
}
