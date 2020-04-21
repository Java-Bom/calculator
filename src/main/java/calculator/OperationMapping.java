package calculator;

import java.util.HashMap;
import java.util.Map;

public class OperationMapping {
    private Map<String, Operation> operations = new HashMap<>();

    public void init() {
        operations.put("+", new AddOperation());
        operations.put("-", new MinusOperation());
        operations.put("*", new MultipleOperation());
        operations.put("/", new DivideOperation());
    }

    public Operation findOperation(String operation) {
        return operations.get(operation);
    }
}
