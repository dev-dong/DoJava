package sec02_exceptionhandlingsyntax.EX03;

public class MultiCatch_2 {
    public static void main(String[] args) {
        
        //#1. catch 블럭의 순서가 잘못된 경우
        // catch() 블럭은 항상 위에서부터 확인을 한다.
//        try {
//            System.out.println(3/0);
//            int num = Integer.parseInt("10A"); // 실행예외 (NumberFormatException)
//        }catch(Exception e) { // Exception은 예외이다. Exception은 최상위 부모
//            System.out.println("숫자는 0으로 나눌수 없습니다.");
//        }catch(NumberFormatException e) {
//            System.out.println("숫자로 바꿀 수 없습니다.");
//        }finally {
//            System.out.println("프로그램 종료");
//        }

        //#2. catch 블록의 올바른 순서
        try {
            System.out.println(3/0);
            int num = Integer.parseInt("10A"); // 실행예외 (NumberFormatException)
        }catch(NumberFormatException e) {
            System.out.println("숫자로 바꿀 수 없습니다.");
        }catch(Exception e) { // Exception은 예외이다. Exception은 최상위 부모
            System.out.println("숫자는 0으로 나눌수 없습니다.");
        }finally {
            System.out.println("프로그램 종료");
        }
    }
}
