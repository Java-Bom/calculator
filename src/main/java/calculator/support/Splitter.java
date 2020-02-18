package calculator.support;


public class Splitter {

    private static final String BLANK = " ";
    public static String[] split(String input){
        return input.split(BLANK);
    }
}
