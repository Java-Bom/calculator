package operation;

public enum Operation {
    PLUS("+") {
        public double apply(double x , double y) { return x + y; }
    },
    MINUS("-") {
        public double apply(double x, double y) { return x - y; }
    },
    TIMES("*") {
        public double apply(double x, double y) { return x * y; }
    },
    DIVIDE("/") {
        public double apply(double x, double y) {
            if (y == 0) {
                throw new ArithmeticException("0으로 나눌 수 없습니다.");
            }
            return x / y;
        }
    };

    private final String symbol;

    Operation(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return this.symbol;
    }

    public abstract double apply(double x, double y);

    public static void main(String[] args) {
        double x = 1.0;
        double y = 2.0;

    }
}
