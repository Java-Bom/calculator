package calculator;

public class Validator {
    public static void isBlank(String value) {
        if (value != null) {
            return;
        }
        System.out.println("Error : Input right value");
        throw new IllegalArgumentException();
    }

    //Exception으로 //Enum으로 빼기
    public static void isRightOperator(String operator){
        if("+".equals(operator)||"-".equals(operator)||"*".equals(operator)||"/".equals(operator)){
            return;
        }
        throw new IllegalArgumentException("사칙 연산자를 입력하세요.");
    }
}
