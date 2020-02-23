package calculator;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum OperatorGroup {
    PLUS("+",(a,b)->a+b),
    MINUS("-",(a,b)->a-b),
    MULTIPLE("*",(a,b)->a*b),
    DIVIDE("/",(a,b)->a/b);

    private final String operator;
    private final OperateStrategy operateStrategy;

    OperatorGroup(String operator, OperateStrategy operateStrategy){
        this.operator = operator;
        this.operateStrategy = operateStrategy;
    }

    public static OperatorGroup findByOperator(String operator){
        return Arrays.stream(OperatorGroup.values())
                .filter(aOperatorGroup->aOperatorGroup.operator.equals((operator)))
                .findFirst()
                //Exception도 controll해야함.
                .orElseThrow(NoSuchElementException::new); //매개변수 필요 없으면 ::으로 표현 가능.
//        만약 매개변수 필요 있으묜 ()->new NoSuchElementException("Message")로 하면 됨.

//        for(EnumCal enumCal:EnumCal.values()){
//            if(enumCal.operator.equals(operator)){
//                return enumCal;
//            }
//        }
//        throw new NoSuchElementException();
    }

    public double calculate(double a, double b){
        return this.operateStrategy.operate(a,b);
        //operate에 대한 정의는  a+b라고 되어있는 것!
    }

}

//전략의 큰 틀을 만들어 놓음.
interface OperateStrategy{
    double operate(double a, double b);
}
