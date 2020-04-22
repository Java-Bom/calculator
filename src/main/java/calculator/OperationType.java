package calculator;

public enum OperationType {
    PLUS {
        @Override
        double execute(double firstOperand, double secondOperand) {
            return firstOperand + secondOperand;
        }
    },
    MINUS {
        @Override
        double execute(double firstOperand, double secondOperand) {
            return firstOperand - secondOperand;
        }
    },
    MULTIPLE {
        @Override
        double execute(double firstOperand, double secondOperand) {
            return firstOperand * secondOperand;
        }
    },
    DIVIDE {
        @Override
        double execute(double firstOperand, double secondOperand) {
            if (bottomIsZero(secondOperand)) {
                throw new ArithmeticException("분모값이 0이면 안됩니다.");
            }
            return firstOperand / secondOperand;
        }
    };

    boolean bottomIsZero(double secondOperand) {
        return secondOperand == 0;
    }

    abstract double execute(double firstOperand, double secondOperand);
}

