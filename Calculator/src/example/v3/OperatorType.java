package example.v3;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum OperatorType {
    // 연산자 유형을
    PLUS("+", (num1, num2) -> num1 + num2), // 더하기
    MINUS("-", (num1, num2) -> num1 - num2), // 빼기
    MULTIPLY("*", (num1, num2) -> num1 * num2), // 곱하기
    DIVIDE("/", (num1, num2) -> { // 나누기
        if (num2 == 0) throw new ArithmeticException("0으로 나눌 수 없습니다."); // 0으로 나누면 예외 발생
        return num1 / num2; // 나누기 연산 결과 반환
    });

    private final String symbol; // 연산자 기호(+, -, *, /)를 저장하는 변수
    private final BiFunction<Double, Double, Double> expression; // 두 숫자를 받아서 연산을 수행하는 함수

    // 생성자: 각 연산자(기호)와 계산 방법(람다식)을 초기화
    OperatorType(String symbol, BiFunction<Double, Double, Double> expression) {
        this.symbol = symbol; // 기호 초기화
        this.expression = expression; // 계산 함수 초기화
    }

    // 사용자가 입력한 연산자에 맞는 계산을 하는 메서드
    public static double calculate(String operator, double num1, double num2) {
        // 연산자에 맞는 OperatorType을 찾아서 그에 맞는 계산을 실행
        return getOperatorType(operator).expression.apply(num1, num2); // 연산 실행
    }

    // 연산자 기호(+, -, *, /)에 맞는 OperatorType 찾아주는 메서드
    private static OperatorType getOperatorType(String operator) {
        // OperatorType 모든 값을 하나씩 확인하면서 전달된 operator와 일치하는 연산자를 찾음
        return Arrays.stream(values()) // 모든 연산자 값을 배열로 가져와서 처리
                .filter(o -> o.symbol.equals(operator)) // 기호가 일치하는 연산자 찾기
                .findFirst() // 첫 번째로 일치하는 연산자 변환
                .orElseThrow(() -> new IllegalArgumentException("올바른 연산자가 아닙니다.")); // 없으면 예외를 던짐
    }
}
