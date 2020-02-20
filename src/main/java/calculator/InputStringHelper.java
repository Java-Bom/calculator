package calculator;

import java.util.Scanner;

public class InputStringHelper {
    private static final String BLANK_DELIMITER = " ";

    public static String[] splitStringArray() {
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();
        return inputString.split(BLANK_DELIMITER);
    }
}
