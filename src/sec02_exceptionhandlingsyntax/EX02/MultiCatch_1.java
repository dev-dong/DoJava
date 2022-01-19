package sec02_exceptionhandlingsyntax.EX02;

public class MultiCatch_1 {
    public static void main(String[] args) {

        //#1. 단일 try~catch
        try {
            System.out.println(3/0); // 실행예외 (ArithmeticException)
        }catch(ArithmeticException e) {
            System.out.println("숫자는 0으로 나눌수 없습니다.");
        }finally {
            System.out.println("프로그램 종료");
        }

        try {
            int num = Integer.parseInt("10A"); // 실행예외 (NumberFormatException)
        }catch(NumberFormatException e) {
            System.out.println("숫자로 바꿀 수 없습니다.");
        }finally {
            System.out.println("프로그램 종료");
        }

        //#2. 다중 try~catch, try, finally는 1개 catch는 여러개 쓸 수 있다. if else if랑 비슷하다고 생각하기
        // catch() 블럭은 반드시 1개만 실행 할 수 있다. 가장 먼저 발생하는 catch() 블럭 1개가 실행된다.
        try {
            System.out.println(3/0);
            int num = Integer.parseInt("10A"); // 실행예외 (NumberFormatException)
        }catch(ArithmeticException e) {
            System.out.println("숫자는 0으로 나눌수 없습니다.");
        }catch(NumberFormatException e) {
            System.out.println("숫자로 바꿀 수 없습니다.");
        }finally {
            System.out.println("프로그램 종료");
        }
    }
}
