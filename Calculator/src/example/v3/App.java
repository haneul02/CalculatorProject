package example.v3;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.00");
        df.setRoundingMode(RoundingMode.DOWN);

        example.v3.ArithmeticCalculator calc = new ArithmeticCalculator();

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

            double result = calc.calculate(num1, num2, operator);

            System.out.println("결과는 : " + df.format(result));

            while (true) {
                System.out.print("계산기 종료(exit 입력 시 종료, Yes 입력 시 계산 계속, remove 입력 시 첫 번째 결과 삭제) : ");
                String str = sc.nextLine();

                if (str.equalsIgnoreCase("exit")) {
                    System.out.print("계산 종료");
                    sc.close();
                    return;
                } else if (str.equalsIgnoreCase("remove")) {
                    calc.removeFirstCalculation();
                    System.out.println("삭제 후 남은 연산 결과: " + calc.getResults());
                    break;
                } else if (str.equalsIgnoreCase("yes")) {
                    System.out.println("계산 계속");
                    break;
                } else {
                    System.out.println("다시 입력하세요");
                }
            }
        }
    }
}
