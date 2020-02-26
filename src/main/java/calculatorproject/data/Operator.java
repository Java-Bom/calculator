package calculatorproject.data;


import calculatorproject.strategy.OperationGroup;

public class Operator {

    public final OperationGroup operatorGroup;

    public Operand calculate(Operand operand1, Operand operand2) {
        return operatorGroup.calculateStrategy.calculate(operand1, operand2);
    }
    public Operator(String operator) {
        this.operatorGroup = OperationGroup.of(operator);
    }
}