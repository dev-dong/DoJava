package sec04_anonymousclass.EX01;

class A {
//    C c; // C type -> 쓰기 위해서는 객체를 만들어야 하는데 인터페이스는 객체를 만들 수가 없다.
    C c = new B();

    void abc() {
        c.bcd();
    }

    // 인스턴스 이너 클래스
    // B는 C이다. C는 객체를 못만든다. C라고 하는것을 초기화하기 위해서 이너클래스를 사용했다. A 클래스의 필드 초기화를 위해서 정의한 클래스
    // 외부 클래스와 상당히 연관이 있을 때 이너클래스를 사용한다.
    class B implements C {
        @Override
        public void bcd() {
            System.out.println("인스턴스 이너클래스");
        }
    }
}

interface C {
    public abstract void bcd();
}

public class AnonymousClass_1 {
    public static void main(String[] args) {
        //#1. 객체 생성 및 메서드 호출
        A a = new A();
        // 인스턴스 이너클래스
        a.abc(); // A의 abc() 메서드 호출 -> bcd() 호출 -> C 인터페이스의 bcd()로 가고 -> 오버라이딩이 됐으니 B의 bcd()로 간다.
    }
}
