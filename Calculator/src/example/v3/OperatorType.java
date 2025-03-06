package example.v3;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum OperatorType {
    PLUS("+", (num1, num2) -> num1 + num2),
    MINUS("-", (num1, num2) -> num1 - num2),
    MULTIPLY("*", (num1, num2) -> num1 * num2),
    DIVIDE("/", (num1, num2) -> {
        if (num2 == 0) throw new ArithmeticException("0으로 나눌 수 없습니다.");
        return num1 / num2;
    });

    private final String symbol;
    private final BiFunction<Double, Double, Double> expression;

    OperatorType(String symbol, BiFunction<Double, Double, Double> expression) {
        this.symbol = symbol;
        this.expression = expression;
    }

    public static double calculate(String operator, double num1, double num2) {
        return getOperatorType(operator).expression.apply(num1, num2);
    }

    private static OperatorType getOperatorType(String operator) {
        return Arrays.stream(values())
                .filter(o -> o.symbol.equals(operator))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("올바른 연산자가 아닙니다."));
    }
}
