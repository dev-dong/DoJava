package sec01_instanceinnerclass.EX02;

class A {
    int a = 3;
    int b = 4;
    void abc() {
        System.out.println("A 클래스 메서드");
    }

    // 인스턴스 이너클래스 정의
    class B {
        int a = 5;
        int b = 6;
        // 상속이 아니다 -> 오버라이딩이 아니다.
        void abc() {
            System.out.println("B 클래스 메서드");
        }
        void bcd() {
            // #1. inner class의 멤버 호출 또는 사용
            System.out.println(a); // 모든 필드와 메서드는 반드시 "this."가 자동추가 된다.
            System.out.println(b); // this. 자동추가
            abc(); // this. 자동추가 B 클래스 메서드

            // #2. outer class의 멤버 호출 또는 사용
            System.out.println(A.this.a);
            System.out.println(A.this.b);
            A.this.abc(); // A 클래스 메서드
        }
    }
}

public class UseMembersOfOuterClass {
    public static void main(String[] args) {
        //#1. outer class 객체 생성
        A a = new A();

        //#2. inner class 객체 생성
        A.B b = a.new B();
        b.bcd();
    }
}
