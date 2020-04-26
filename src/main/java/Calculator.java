import operation.NumberPack;
import operation.Operation;
import operation.OperatorPack;

public class Calculator {

    public double calculate(NumberPack numberPack, OperatorPack operatorPack) {
        double result = numberPack.pollNumber();
        int operateCount = operatorPack.getOperatorPackCounts();
        for (int i = 0; i < operateCount; i++) {
            String operator = operatorPack.pollOperator();
            double y = numberPack.pollNumber();
            result = Operation.getType(operator).operate(result, y);
        }
        return result;
    }
}
