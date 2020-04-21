package calculator;

public class Separator {
    private String text;
    private double[] operand;
    private String[] operation;

    public Separator(String text) {
        this.text = text;
    }

    public void separate() {
        Split split = new Split(text);
        String[] texts = split.split();
        init(texts);
        separateNumberAndOperation(texts);
    }

    public double[] getArrayOperand() {
        return operand;
    }

    public String[] getArrayOperation() {
        return operation;
    }

    private void init(String[] texts) {
        int length = texts.length;
        int operationSize = length / 2;
        int operandSize = operationSize + 1;

        operand = new double[operandSize];
        operation = new String[operationSize];
    }

    private void separateNumberAndOperation(String[] texts) {
        int idx = 0;
        for (int i = 0; i < texts.length - 1; i += 2) {
            operand[idx] = Integer.parseInt(texts[i]);
            operation[idx++] = texts[i + 1];
        }
        operand[idx] = Integer.parseInt(texts[texts.length - 1]);
    }
}
