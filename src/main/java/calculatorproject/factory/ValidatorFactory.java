package calculatorproject.factory;

import calculatorproject.input.InputValidator;

public class ValidatorFactory {
    public static InputValidator makeInputValidator(){
        return new InputValidator();
    }
}
