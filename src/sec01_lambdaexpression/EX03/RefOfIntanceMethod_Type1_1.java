package sec01_lambdaexpression.EX03;

/*
* static 메서드나 인스턴스 메서드는 매개변수 타입과 매개변수 갯수가 정확하게 일치해야한다.
* */
interface A {
    void abc();
}

class B {
    void bcd() {
        System.out.println("메서드");
    }
}

public class RefOfIntanceMethod_Type1_1 {
    public static void main(String[] args) {

        //#1. 인스턴스 메서드 참조 type1 익명이너클래스
        // 인스턴스 메서드는 객체를 만들어야 사용할 수 있다.
        A a1 = new A() {
            @Override
            public void abc() {
                B b = new B();
                b.bcd();
            }
        };
        
        //#2. 람다식
        A a2 = () -> {
            B b = new B();
            b.bcd();
        };
        
        //#3. 인스턴스 참조 Type1의 표현
        B b = new B();
        A a3 = b::bcd; // b 객체배속에 bcd() 인스턴스 메서드가 있거든 누군가가 a3라고 하는 객체 배속에 있는 abc를 호출하게 되면 bcd를 호출해라.

        a1.abc();
        a2.abc();
        a3.abc();

    }
}
