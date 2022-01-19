package sec02_exceptionhandlingsyntax.EX01;

public class TryCatchFinally {
    public static void main(String[] args) {

        //#1. try ~ catch
        // 예외처리는 catch 블록을 가지고 있는거 자체만으로도 예외처리를 했다고한다.
        try {
            System.out.println(3/0); // 실행예외 (ArithmeticException)
            System.out.println("프로그램 종료");
        }catch(ArithmeticException e) {
            System.out.println("숫자는 0으로 나눌수 없습니다.");
            System.out.println("프로그램 종료");
        }
        
        //#2. try ~ catch ~ finally
        try {
            System.out.println(3/0); // 실행예외 (ArithmeticException)
        }catch(ArithmeticException e) {
            System.out.println("숫자는 0으로 나눌수 없습니다.");
        }finally { // 정상적으로 종료하나 예외가 발생하나 finally는 무조건 실행한다.
            System.out.println("프로그램 종료");
        }
    }
}
