package calculator;

import java.util.Arrays;

public class TurnValidator {

    public boolean isFirstNumber(Integer result){
        if(result==null){
            return true;
        }
        return false;
    }

    public Turn checkTurn(String inputValue, Integer result){
        if(isFirstNumber(result)){
            return Turn.FIRST_OPERAND;
        }
        if(isOperator(inputValue)){
            return Turn.OPERATOR;
        }
        return Turn.OTHER_OPERAND;
    }

    public boolean isOperator(String inputValue){
        if(Arrays.asList("+","-","/","*").contains(inputValue)){
            return true;
        }
        return false;
    }
}
