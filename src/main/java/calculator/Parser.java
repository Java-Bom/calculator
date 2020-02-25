package calculator;

public class Parser {
    public static int stringToInteger(String stringToInt) {
        int toInt = 0;
        try {
            toInt = Integer.parseInt(stringToInt);
        } catch (IllegalArgumentException parsingFail) {
            System.out.println("숫자를 입력하세요");
        }
        return toInt;
    }
}
