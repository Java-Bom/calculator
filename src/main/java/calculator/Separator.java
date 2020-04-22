package calculator;

import java.util.ArrayList;
import java.util.List;

public class Separator {
    private Splitter splitter;
    private List<Double> operand;
    private List<String> operation;

    public Separator(String text) {
        init(text);
        separateOperandAndOperation(splitter.split());
    }

    public List<Double> getOperand() {
        return operand;
    }

    public List<String> getOperation() {
        return operation;
    }

    private void init(String text) {
        splitter = new Splitter(text);
        operand = new ArrayList<>();
        operation = new ArrayList<>();
    }

    private void separateOperandAndOperation(String[] texts) {
        for (int i = 0; i < texts.length - 1; i += 2) {
            operand.add(Double.parseDouble(texts[i]));
            operation.add(texts[i + 1]);
        }
        operand.add(Double.parseDouble(texts[texts.length - 1]));
    }
}
