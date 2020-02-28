package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputStringHelper {
    private static final String BLANK_DELIMITER = " ";

    public static List<String> splitString() {
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();
        return Arrays.stream(inputString.split(BLANK_DELIMITER))
                .collect(Collectors.toList());
    }
}
