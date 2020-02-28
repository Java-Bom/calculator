package calculator;


import java.util.ArrayList;

public class Spliter {
    private static final String DELIMITER = " ";

    public ArrayList splitNumbers(String value) {
        String[] splitedValue = value.split(DELIMITER);
        ArrayList numberList = new ArrayList();

        for (int i = 0; i < splitedValue.length; i+=2) {
             numberList.add(Parser.stringToInteger(splitedValue[i]));
        }
        return numberList;
    }

    public ArrayList splitOperators(String value) {
        String[] splitedValue = value.split(DELIMITER);
        ArrayList operatorList = new ArrayList();

        for (int i = 1; i < splitedValue.length; i+=2) {
            operatorList.add(splitedValue[i]);
        }
        return operatorList;
    }
}