package calculator.support;

import static sun.tools.jconsole.Messages.BLANK;

public class Splitter {

    private static final String BLANK = " ";
    public static String[] split(String input){
        return input.split(BLANK);
    }
}
