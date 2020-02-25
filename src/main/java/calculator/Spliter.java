package calculator;


import java.util.ArrayList;

public class Spliter {
    private static final String DELIMITER = " ";

    public ArrayList splitNumbers(String value) {
        String[] splitedValue = value.split(DELIMITER);
        ArrayList numberArr = new ArrayList();

        for (int i = 0; i < splitedValue.length; i+=2) {
             numberArr.add(Parser.stringToInteger(splitedValue[i]));
        }
        return numberArr;
    }

    public ArrayList splitOperators(String value) {
        String[] splitedValue = value.split(DELIMITER);
        ArrayList operatorArr = new ArrayList();

        for (int i = 1; i < splitedValue.length; i+=2) {
            Validator.isRightOperator(splitedValue[i]);
            operatorArr.add(splitedValue[i]);
        }
        return operatorArr;
    }
}