package sec01_instanceinnerclass.EX01;

class A {
    public int a = 3;
    protected int b = 4;
    int c = 5;
    private int d = 6;

    void abc() {
        System.out.println("A 클래스 메서드 abc()");
    }

    // 인스턴스 이너클래스
    class B {
        void bcd() {
            //#1. outer class의 필드 사용
            System.out.println(a);
            System.out.println(b);
            System.out.println(c);
            System.out.println(d);

            //#2. outer class의 메서드 호출
            abc();
        }
    }
}

public class CreateObjectAndAccessMember {
    public static void main(String[] args) {
        //#1. 객체생성 단계 1. outer class 객체 생성
        A a = new A();
        
        //#2. 멤버 사용
//        B b = new B(); // 이너클래스이기 때문에 이렇게 선언할 수 없다.
        A.B b = a.new B(); // a라는 객체 뱃속에 가면 B 클래스가 있다.
        b.bcd();
    }
}
