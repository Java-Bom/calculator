package calculator;

import calculator.operation.equation.Equation;
import calculator.operation.util.EquationSplitter;
import calculator.view.InputExpressionDTO;
import calculator.view.InputView;

import java.util.List;
import java.util.Scanner;

public class Calculator {
    private static final InputView inputView = new InputView(new Scanner(System.in));

    public void run() {
        InputExpressionDTO inputExpressionDTO = inputView.inputEquation();
        List<String> splitEquation = EquationSplitter.split(inputExpressionDTO.getExpression());

        Equation equation = new Equation(splitEquation);
        System.out.println(equation.getResult());
    }
}
