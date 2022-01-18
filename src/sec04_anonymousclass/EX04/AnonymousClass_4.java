package sec04_anonymousclass.EX04;

interface A {
    public abstract void abc();
}

class C {
    void cde(A a){
        a.abc();
    }
}

public class AnonymousClass_4 {
    public static void main(String[] args) {
        C c = new C();

        //#3. 익명이너클래스로 객체 생성 // 방법#3 클래스명 X + 참조변수명 O
        A a  = new A() {
            public void abc() {
                System.out.println("매개변수 전달");
            }
        };
        c.cde(a); // 매개변수 전달

        //#4. 방법#4 클래스명 X + 참조변수명 X => 이벤트 처리 시 굉장히 많이 사용한다.
        c.cde(new A() {
            public void abc() {
                System.out.println("매개변수 전달");
            }
        });
    }
}
