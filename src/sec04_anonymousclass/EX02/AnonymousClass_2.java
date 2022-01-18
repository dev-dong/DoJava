package sec04_anonymousclass.EX02;

class A {
    // 익명 이너클래스 -> 클래스 이름을 몰라. 컴파일러가 알아서 만들어주기 때문에 그래서 익명이다.
    C c = new C(){
        @Override
        public void bcd() {
            System.out.println("익명 이너클래스");
        }
    };

    void abc() {
        c.bcd();
    }
}

interface C {
    public abstract void bcd();
}

public class AnonymousClass_2 {
    public static void main(String[] args) {
        //#1. 객체 생성 및 메서드 호출
        A a = new A();
        // 익명 이너클래스
        a.abc();
    }
}
