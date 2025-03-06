package example.v2;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // 사용자 입력을 받기 위한 Scanner 객체 생성

        // 소수점 둘째 자리까지 표시(예 : 2.8577 → 2.85)
        DecimalFormat df = new DecimalFormat("0.00");
        df.setRoundingMode(RoundingMode.DOWN); // 반올림 방식: Down (버림)

        Calculator calc = new Calculator();// Calculator 객체 생성(연산 기능 사용)

        while (true) { // 계산기를 계속 실행하기 위해 무한 루프
            System.out.print("첫 번째 숫자를 입력하세요:");
            double num1 = sc.nextDouble();
            sc.nextLine();

            System.out.print("사칙연산의 기호를 입력하세요(+, -, *, /) : ");
            char operator = sc.next().charAt(0);
            sc.nextLine();

            System.out.print("두 번째 숫자를 입력하세요:");
            double num2 = sc.nextDouble();
            sc.nextLine();

            //Calculator클래스의 'calculate' 메서드 호출하여 연산 수행
            double result = calc.calculate(num1, num2, operator);

            // 연산 결과 소수점 둘째 자리까지 출력
            System.out.println("결과는 : " + df.format(result));

            while (true) {
                System.out.print("계산기 종료(exit 입력 시 종료, Yes 입력 시 계산 계속, remove 입력 시 첫 번째 결과 삭제) : ");
                String str = sc.nextLine();

                if (str.equalsIgnoreCase("exit")) {
                    System.out.print("계산 종료");
                    sc.close(); // scanner 닫기
                    return; // main 종료
                } else if (str.equalsIgnoreCase("remove")) { // remove 입력 시 첫 번째 연산 결과 삭제
                    calc.removeFirstCalculation(); // calculator 클래스의 'removeFirstCalculation' 메서드 호출
                    System.out.println("삭제 후 남은 연산 결과: " + calc.getResults()); // 삭제 후 남은 연산 결과 출력
                    break;
                } else if (str.equalsIgnoreCase("yes")) {
                    System.out.println("계산 계속");
                    break;
                } else {
                    System.out.println("다시 입력하세요"); // 잘못된 입력 시 다시 입력 요청
                }
            }
        }
    }
}
