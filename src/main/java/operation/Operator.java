package operation;

public class Operator {

    public static boolean isOperator(String value) {
        return Operation.getType(value) != null;
    }
}
