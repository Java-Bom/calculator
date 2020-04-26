package input;

import java.util.ArrayList;
import java.util.List;

public class Split {

    private static final String BLANK = " ";
    private List<String> expression = new ArrayList<>();

    public Split(String input) {
        removeBlank(input);
    }

    private void removeBlank(String input) {
        String[] inputValues = splitStringAll(input);
        for (String value : inputValues) {
            if (value.equals(BLANK)) { continue; }
            expression.add(value);
        }
    }

    private String[] splitStringAll(String input) {
        return input.split("");
    }

    public List<String> getExpression() {
        return new ArrayList<>(expression);
    }
}
