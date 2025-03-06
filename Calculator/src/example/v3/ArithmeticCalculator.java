package example.v3;

import java.util.ArrayList;
import java.util.List;

public class ArithmeticCalculator {
    private List<Double> results = new ArrayList<>(); // 연산 결과 저장

    //Setter
    public void setResults(List<Double> newResults) {
        if(newResults != null){
            this.results = new ArrayList<>(newResults);
        } else{
            System.out.println("잘못된 입력입니다. 결과 리스트를 null로 설정할 수 없습니다.");
        }
    }

    //Getter
    public List<Double> getResults() {
        return new ArrayList<>(results);
    }

    public double calculate(double num1, double num2, char operator) {
        try{
            String operatorStr = String.valueOf(operator);
            double result = OperatorType.calculate(operatorStr, num1, num2);
            results.add(result);
            return result;
        } catch (IllegalArgumentException | ArithmeticException e){
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public void removeFirstCalculation() {
        if (!results.isEmpty()) {
            List<Double> updatedResults = new ArrayList<>(results);
            updatedResults.remove(0); // ✅ 삭제는 복사한 리스트에서 수행
            setResults(updatedResults); // ✅ 세터를 통해 업데이트
            System.out.println("연산 결과 삭제 완료.");
        } else {
            System.out.println("삭제할 결과가 없음");
        }
    }
}
