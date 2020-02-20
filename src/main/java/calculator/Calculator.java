package calculator;

import calculator.operation.equation.Equation;
import calculator.operation.util.EquationSplitter;
import calculator.view.InputExpressionDTO;
import calculator.view.InputView;

import java.util.List;

public class Calculator {
    private final InputView inputView;

    public Calculator(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        InputExpressionDTO inputExpressionDTO = inputView.inputEquation();
        List<String> splitEquation = EquationSplitter.split(inputExpressionDTO.getExpression());

        Equation equation = new Equation(splitEquation);
        System.out.println(equation.getResult());
    }
}
