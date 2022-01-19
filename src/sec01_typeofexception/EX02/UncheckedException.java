package sec01_typeofexception.EX02;

class A{}
class B extends A{}

public class UncheckedException {
    public static void main(String[] args) {

        //#. UncheckedException (실행예외) = RuntimeException

        //#1. ArithmeticException - 수학적으로 문제가 있을 때 발생하는 Exception
//        System.out.println(3/0);

        //#2. ClassCastException - 클래스 캐스팅 예외
//        A a = new A();
//        B b = (B)a; // 불가능

        //#3. ArrayIndexOutOfBoundsException - 배열 인덱스를 넘어서는 예외
//        int[] array= {1, 2, 3};
//        System.out.println(array[3]);

        //#4. NumberFormatException - 포맷 예외
//        int num = Integer.parseInt("10!");

        //#5. NullPointerException -
//        String str = null; // 객체를 가리키지 않겠다. 아무것도 가리키지 않는다라는 의미가 null
//        System.out.println(str.charAt(2)); // 호출이 가능한 이유는 str는 String 타입이기 때문에 String 타입안에 있는 메서드는 보이지만 호출 하는 시점에서 객체를 가리키고 있지 않아서 예외발생
    }
}
