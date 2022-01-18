package sec04_anonymousclass.EX03;

interface A {
    public abstract void abc();
}

//#1. 자식클래스를 직접 생성 - 인터페이스 A를 매개변수로 받는 cde() 메서드를 실행시키기 위해서 A 객체를 만들어야하고 그러다 보니까 자식클래스를 만들어서 자식클래스 생성자로 A 객체를 만드는 경우
class B implements A {
    @Override
    public void abc() {
        System.out.println("매개변수 전달");
    }
}

class C {
    void cde(A a){
        a.abc();
    }
}

public class AnonymousClass_3 {
    public static void main(String[] args) {
        C c = new C();

        //#1. A(인터페이스)타입의 객체 생성 : //#1. 방법#1 클래스명 O + 참조변수명 O
        A a  = new B();
        c.cde(a); // 매개변수 전달

        //#2. 방법#2 클래스명 O + 참조변수명 X
        c.cde(new B()); // 매개변수 전달
    }
}
