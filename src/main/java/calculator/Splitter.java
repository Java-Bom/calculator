package calculator;

public class Splitter {
    public static String[] split(String text) {
        String[] texts = text.split(" ");
        checkLength(texts);

        int idx = 0;
        while (texts.length > idx) {
            checkValue(texts, idx++);
        }

        return texts;
    }

    private static void checkLength(String[] texts) {
        if (!isOdd(texts.length)) {
            throw new IllegalArgumentException("연산자와 피연산자의 수가 맞지않습니다.");
        }
    }

    private static void checkValue(String[] texts, int idx) {
        if (isOdd(idx)) {
            checkOperation(texts, idx);
            return;
        }
        checkOperand(texts, idx);
    }

    private static boolean isOdd(int length) {
        return length % 2 == 1;
    }

    private static void checkOperation(String[] texts, int idx) {
        if (OperationType.hasNotContain(texts[idx]))
            throw new IllegalArgumentException("정의되지 않은 연산자가 입력됐습니다.");
    }

    private static void checkOperand(String[] texts, int idx) {
        try {
            Double.parseDouble(texts[idx]);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("피연산자가 아닌 다른값이 입력됐습니다.");
        }
    }
}
