package calculator;


public class Spliter {
    private static final String DELIMITER = " ";

    public static void isBlank(String value) {
        if (value != null) {
            return;
        }
        System.out.println("Error : Input right value");
        throw new IllegalArgumentException();
    }

    public static int[] splitNumbers(String value) {
        String[] splitedValue = value.split(DELIMITER);
        int[] numberArr = new int[getAnNumberIndex1(splitedValue)];
        int numberIndex = 0;
        for (int i = 0; i < splitedValue.length; i+=2) {
             numberArr[numberIndex++] = checkValidity(splitedValue[i]);
        }
        return numberArr;
    }

    //Exception 터뜨리는 걸로
    public static int checkValidity(String stringToInt) {
        int toInt=0;
        try{
            toInt = Integer.parseInt(stringToInt);
        }
        catch(IllegalArgumentException parsingFail){
            System.out.println("숫자를 입력하세요");
        }
        return toInt;
    }

    public static String[] splitOperators(String value) {
        String[] splitedValue = value.split(DELIMITER);
        String[] operatorArr = new String[getOperatorIndex1(splitedValue)];
        int operatorIndex = 0;
        for (int i = 1; i < splitedValue.length; i+=2) {
            isRightOperator(splitedValue[i]);
            operatorArr[operatorIndex++] = splitedValue[i];
        }
        return operatorArr;

    }

    private static int getAnNumberIndex1(String[] splitedValue) {
        return (getOperatorIndex1(splitedValue)) + 1;
    }

    //Exception으로
    public static void isRightOperator(String operator){
        if("+".equals(operator)||"-".equals(operator)||"*".equals(operator)||"/".equals(operator)){
            return;
        }
        throw new IllegalArgumentException("사칙 연산자를 입력하세요.");
    }

    private static int getOperatorIndex1(String[] splitedValue) {
        return splitedValue.length / 2;
    }
}