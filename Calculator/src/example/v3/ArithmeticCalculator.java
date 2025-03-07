package example.v3;

import java.util.ArrayList;
import java.util.List;

public class ArithmeticCalculator {
    private List<Double> results = new ArrayList<>(); // 연산 결과 저장

    // 결과 리스트를 설정하는 메서드(Setter)
    public void setResults(List<Double> newResults) {
        if(newResults != null){ // 입력된 리스트가 null이 아닌 경우만 실행
            this.results = new ArrayList<>(newResults); // 새로운 리스트를 만들어 results에 저장
        } else{
            // null이 들어오면 경고 메시지 출력
            System.out.println("잘못된 입력입니다. 결과 리스트를 null로 설정할 수 없습니다.");
        }
    }

    //결과 리스트를 가져오는 메서드(Getter)
    public List<Double> getResults() {
        return new ArrayList<>(results); // 원본 리스트를 보호하기 위해 복사본 반환
    }

    // 두 숫자와 연사자를 받아 계산을 수행하고 결과를 리스트에 저장하는 메서드
    public double calculate(double num1, double num2, char operator) {
        try{
            // 연산자를 문자에서 문자열로 변환
            String operatorStr = String.valueOf(operator);
            // OperatorType 클래스에서 계산 수행(연산자에 맞는 연산을 처리)
            double result = OperatorType.calculate(operatorStr, num1, num2);
            // 계산 결과를 결과 리스트에 추가
            results.add(result);
            //계산된 결과를 반환
            return result;
        } catch (IllegalArgumentException | ArithmeticException e){
            // 예외가 발생하면 예외 메시지를 출력하고 0을 반환
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public void removeFirstCalculation() {
        if (!results.isEmpty()) { // 결과 리스트가 비어있지 않으면
            // 결과 리스트를 복사함여 새로운 리스트에 저장
            List<Double> updatedResults = new ArrayList<>(results);
            updatedResults.remove(0); // 복사한 리스트에서 첫 번째 결과 삭제
            setResults(updatedResults); // 삭제된 리스트를 다시 설정(세터 사용)
            System.out.println("연산 결과 삭제 완료."); // 삭제 완료 메시지 출력
        } else {
            // 리스트가 비어 있을 경우 삭제할 데이터가 없다는 메시지 출력
            System.out.println("삭제할 결과가 없음");
        }
    }
}
