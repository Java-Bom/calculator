package calculator;

public class Split {
    private static final String PLUS = "+";
    private static final String MINUS = "-";
    private static final String MULTIPLE = "*";
    private static final String DIVIDE = "/";

    private String text;

    public Split(String text) {
        this.text = text;
    }

    public String[] split() {
        String[] texts = text.split(" ");

        int idx = 0;
        while (texts.length > idx) {
            checkLength(texts);
            checkValue(texts, idx++);
        }

        return texts;
    }

    private void checkLength(String[] texts) {
        if (!isOdd(texts.length)) {
            throw new IllegalArgumentException();
        }
    }

    private void checkValue(String[] texts, int idx) {
        if (isOdd(idx)) {
            checkOperation(texts, idx);
            return;
        }
        checkOperand(texts, idx);
    }

    private boolean isOdd(int length) {
        return length % 2 == 1;
    }

    private void checkOperation(String[] texts, int idx) {
        if (isOperation(texts[idx])) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isOperation(String operation) {
        return !operation.equals(PLUS) && !operation.equals(MINUS) && !operation.equals(MULTIPLE) && !operation.equals(DIVIDE);
    }

    private void checkOperand(String[] texts, int idx) {
        try {
            Double.parseDouble(texts[idx]);
        } catch (NumberFormatException e) {
            throw new NumberFormatException();
        }
    }
}
