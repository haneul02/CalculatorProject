package example.v2;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private List<Double> results = new ArrayList<>(); // 연산 결과 저장

    // 결과 리스트를 설정하는 메서드(Setter)
    public void setResults(List<Double> newResults) {
        if(newResults != null){ // 입력된 리스트가 null이 아닌 경우만 실행
            this.results = new ArrayList<>(newResults); // 새로운 리스트를 만들어 results에 저장
        } else{
            // null이 들어오면 경고 메시지 출력
            System.out.println("잘못딘 입력입니다. 결과 리스트를 null로 설정할 수 없습니다.");
        }
    }

    //결과 리스트를 가져오는 메서드(Getter)
    public List<Double> getResults() {
        return new ArrayList<>(results); // 원본 리스트를 보호하기 위해 복사본 반환
    }

    // 사칙연산을 수행하는 메서드
    public double calculate(double num1, double num2, char operator) {
        double result = 0; // 계산 결과를 저장할 변수

        // 입력된 연산자(operator)에 따라 계산 수행
        switch (operator) {
            case '+': // 덧셈
                result = num1 + num2;
                break;
            case '-': // 뺄셈
                result = num1 - num2;
                break;
            case '*': // 곱하기
                result = num1 * num2;
                break;
            case '/': // 나눗셈
                if (num2 != 0) { // 0으로 나누는 경우 방지
                    result = num1 / num2;
                } else {
                    // 0으로 나누면 오류 메시지 출력 후 0반환
                    System.out.println("0으로 나눌 수 없습니다.");
                    return 0;
                }
                break;
            default:
                // 잘못된 연산자 입력 시 오류 메시지 출력 후 0 반환
                System.out.println("잘못된 연산자입니다.");
                return 0;
        }
        results.add(result); // 계산 결과를 리스트에 저장
        return result; // 계산 결과 반환
    }

    // 저장된 첫 번째 연산 결과를 삭제하는 메서드
    public void removeFirstCalculation() {
        if (!results.isEmpty()) { // 리스트에 값이 있는 경우만 실행
            List<Double> updatedResults = new ArrayList<>(results); // 현재 리스트 복사
            updatedResults.remove(0); // 복사한 리스트에서 첫 번째 결과 삭제
            setResults(updatedResults); // 삭제된 리스트를 다시 설정(세터 사용)
            System.out.println("연산 결과 삭제 완료.");
        } else {
            // 리스트가 비어 있을 경우 삭제할 데이터가 없다는 메시지 출력
            System.out.println("삭제할 결과가 없음");
        }
    }
}