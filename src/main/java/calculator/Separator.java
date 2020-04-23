package calculator;

import java.util.ArrayList;
import java.util.List;

public class Separator {
    private String text;
    private Splitter splitter;

    public Separator(String text) {
        this.text = text;
        init();
    }

    private void init() {
        splitter = new Splitter(text);
    }

    public SeparatedValue separateOperandAndOperation() {
        String[] texts = splitter.split();

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
