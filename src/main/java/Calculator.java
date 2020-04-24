import operation.OperationType;

import java.util.Iterator;
import java.util.List;

public class Calculator {

    public double calculate(List<Double> numbers, List<String> operators) {
        Iterator<Double> numbersIter = numbers.listIterator();
        Iterator<String> operatorsIter = operators.listIterator();
        double result = numbersIter.next();
        while (operatorsIter.hasNext()) {
            String operator = operatorsIter.next();
            double y = numbersIter.next();
            result = OperationType.getType(operator).operate(result, y);
        }
        return result;
    }
}
