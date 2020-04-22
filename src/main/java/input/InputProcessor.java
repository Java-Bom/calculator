package input;

import java.util.ArrayList;
import java.util.List;

public class InputProcessor {

    public List<String> operators;

    public List<Double> numbers;

    public void validInputString(String[] values) {
        if (values.length == 1 && values[0].equals("")) {
            throw new IllegalArgumentException("입력값이 없습니다.");
        }
    }

    public void splitOperatorsAndNumbers(String[] values) {
        numbers = new ArrayList<>();
        operators = new ArrayList<>();

        for (String value : values) {
            if (isNumeric(value)) { numbers.add(Double.parseDouble(value)); }
            else if (!isNumeric(value)) { operators.add(value); }
        }
    }

    public boolean isNumeric(String value) {
        try {
            Double.parseDouble(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
