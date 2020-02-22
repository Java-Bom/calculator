package calculator;

public class Calculator {
    private double result;
    private int nextvalue = 1;

    //부호를 검증하고, 그에 맞는 함수를 호출하는 함수.
    //변수명 만들기.(축약하지 않기)
    //Exception handle
    //Null Pointer Exception 발생할 여지를 줄이기 : "+".equals(a[i])
    //존재가 확실한 것을 앞으로 빼는 것이 좋다.
    //+,-,*,/ 를 상수로 빼는 것도 좋음 -> Enum으로 바꿀 수도 있음.
    Calculator(String[] operatorArr, int[] numberArr){
        result = numberArr[0];
        result = callVal(operatorArr,numberArr);
    }

    public static double calculate(String[] operatorArr, int[] numberArr) {
        return callVal(operatorArr,numberArr);
    }

    private static double callVal(String[] operatorArr, int[] numberArr){
        int result = numberArr[0];
        for(int i = 0 ; i < operatorArr.length ; i++){
            result = CalculateValue(operatorArr[i], numberArr);
        }
        return result;

    }

    private double CalculateValue(int a, int b, String operator) {
        EnumCal findOperator = EnumCal.findByOperator(operator);
        return findOperator.calculate(a,b);

//        if("+".equals(operator)){
//            return plus(result,numberArr[nextvalue++]);
//        }
//        if("-".equals(operator)){
//            return minus(result,numberArr[nextvalue++]);
//        }
//        if("*".equals(operator)){
//            return multi(result,numberArr[nextvalue++]);
//        }
//        if("/".equals(operator)){
//            return divide(result,numberArr[nextvalue++]);
//        }
//        System.out.println(this.invalidValue.getMessage());
//        return 0; //수정 필요
    }

    public double getResult(){
        return result;
    }

    private double plus(double left, double right)
    {
        return left+right;
    }

    private double divide(double left, double right)
    {
        return left/right;
    }

    private double minus(double left, double right){
        return left-right;
    }

    private double multi(double left, double right)
    {
        return left*right;
    }
}
