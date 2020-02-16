package view;

import java.text.DecimalFormat;

public class OutputView {
    public static void printResult(final double result) {
        DecimalFormat df=new DecimalFormat("#.##");
        System.out.println("결과: "+ df.format(result));
    }

    public static void printInputMessage() {
        System.out.println("수식을 입력 해주세요");
    }
}
