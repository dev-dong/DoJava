package sec03_localinnerclass.EX01;

/**
 * 클래스안에 정의되는 변수는 필드
 * 메서드안에 정의되는 변수는 지역변수
 * 클래스안에 들어가있는것을 인스턴스 이너클래스
 * 메서드안에 들어가있는것을 지역 이너클래스
 * */
class A {
    int a = 3; // 필드
    void abc() {
        int b = 5; // 지역변수

        // 지역이너클래스
        class B{
            void bcd() {
                System.out.println(a); // 필드
                System.out.println(b); // 지역변수, 값을 사용하는 순간에 자동으로 final int b = 5;가 붙는다.

                // 값 변경
                a = 5;
//                b = 7; // 지역이너클래스에서 지역변수를 사용 할 때는 반드시 final일 때만 사용가능하다.
            }
        }

        // 한번 사용하고 말 것.
        B bb = new B();
        bb.bcd();
    }
}

public class AccessMemberAndLocalVariable {
    public static void main(String[] args) {
        //#1. 객체 생성 및 메서드 호출
        A a = new A();
        a.abc();
    }
}
