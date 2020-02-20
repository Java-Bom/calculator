package calculator;

public class ValidatorFactory {
    public TurnValidator makeTurnValidator(){
        return new TurnValidator();
    }
    public InputValidator makeInputValidator(){
        return new InputValidator();
    }
}
