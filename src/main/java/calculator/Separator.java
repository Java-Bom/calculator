package calculator;

import java.util.ArrayList;
import java.util.List;

public class Separator {
    public static SeparatedValue separateOperandAndOperation(String text) {
        String[] texts = Splitter.split(text);

        List<Double> operands = new ArrayList<>();
        List<String> operations = new ArrayList<>();

        for (int i = 0; i < texts.length - 1; i += 2) {
            operands.add(Double.parseDouble(texts[i]));
            operations.add(texts[i + 1]);
        }
        operands.add(Double.parseDouble(texts[texts.length - 1]));

        return new SeparatedValue(operands, operations);
    }
}
