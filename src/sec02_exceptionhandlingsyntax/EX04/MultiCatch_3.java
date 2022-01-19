package sec02_exceptionhandlingsyntax.EX04;

public class MultiCatch_3 {
    public static void main(String[] args) {
        
        //#1. catch블록을 각각 처리한 경우
        try {
            System.out.println(3/0);
            int num = Integer.parseInt("10A"); // 실행예외 (NumberFormatException)
        }catch(ArithmeticException e) {
            System.out.println("예외가 발생했습니다.");
        }catch(NumberFormatException e) {
            System.out.println("예외가 발생했습니다.");
        }

        //#2. catch 블록을 하나로 통일한 경우
        // 2개의 예외를 or 처리를 했기 때문에 어떤 Exception이 생기던 다 예외처리를 할 수 있다.
        try {
            System.out.println(3/0);
            int num = Integer.parseInt("10A"); // 실행예외 (NumberFormatException)
        }catch(ArithmeticException | NumberFormatException e) {
            System.out.println("예외가 발생했습니다.");
        }
    }
}
