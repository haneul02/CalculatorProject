package example.v1;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        // 입력을 받기 위한 Scanner 객체. System.in을 사용해서 키보드 입력을 받음
        Scanner sc = new Scanner(System.in);
        // 소수점 둘째 자릮지 표시 (DecimalFormat 객체 사용)
        DecimalFormat df = new DecimalFormat("0.00");
        // 소수점 반올림 방식 내림( ex | 1.2555 -> 1.25로 표시)
        df.setRoundingMode(RoundingMode.DOWN);

        while(true){ // 계산기를 계속 실행하기 위해 무한 루프
            System.out.print("첫 번째 숫자를 입력하세요:");
            // nextDouble()처럼 숫자 입력 메서드는 숫자만 읽고 입력 후 남아 있는
            // 개행 문자(\n)를 버퍼에 남겨둬서 nextLine()를 사용해서 버퍼를 비움
            double num1 = sc.nextDouble();
            sc.nextLine();

            System.out.print("사칙연산의 기호를 입력하세요(+, -, *, /) : ");
            char operator = sc.next().charAt(0);
            sc.nextLine();

            System.out.print("두 번째 숫자를 입력하세요:");
            double num2 = sc.nextDouble();
            sc.nextLine();

            double result = 0; // 계산 결과를 저장하는 변수
            boolean validOperation = true; //연산이 유효한지 체크

            switch(operator){
                case '+': // 더하기 연산
                    result = num1 + num2;
                    break;
                case '-': // 빼기 연산
                    result = num1 - num2;
                    break;
                case '*': // 곱하기 연산
                    result = num1 * num2;
                    break;
                case '/': // 나누기 연산
                    if (num2 != 0){ // 0으로 나누기 불가
                        result = num1 / num2;
                    } else {
                        System.out.println("0으로 나눌 수 없습니다. 다시 입력하세요.");
                        validOperation = false;
                    }
                    break;
                default:
                    System.out.println("유효하지 않은 연산자입니다. 다시 입력하세요.");
                    validOperation = false;
                    break;
            }
            if(!validOperation){ // 유효하지 않은 연산이면 처음으로 돌아감(잘못된 입력을 하면 다시 숫자랑 연사자를 입력받으로 돌아가는거)
                continue;
            }

            System.out.println("결과는 : " + df.format(result)); // 계산된 결과 출력(소수점 둘째 자리까지 표시)
            System.out.print("계산기 종료(exit 입력 시 종료, Yes 입력 시 계산 계속) : ");
            String str = sc.nextLine();
            if(str.equals("exit")){
                System.out.print("계산 종료");
                break;
            } else{
                System.out.println("계산 계속"); // "exit"가 아니면 계산 계속 진행
            }
        }
        sc.close(); // Scanner 객체 닫기
    }

}
