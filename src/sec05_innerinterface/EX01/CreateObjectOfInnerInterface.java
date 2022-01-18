package sec05_innerinterface.EX01;

class A {
    // 이너인터페이스는 static이 무조건 붙는다! 생략해도 붙음
    interface B {
        public abstract void bcd();
    }
}

// 껍데기를 통해서 들어가야한다. 껍데기가 A니까 A.B 타입은 A.B 즉 선언된 타입을 정의 하기 위해서는 외부에서 안으로 들어와야한다.
class C implements A.B {
    @Override
    public void bcd() {
        System.out.println("이너이터페이스 구현 클래스 생성");
    }
}

public class CreateObjectOfInnerInterface {
    public static void main(String[] args) {
        // 객체생성 방법 #1 (자식클래스 직접 생성)
        A.B ab = new C();
        C c = new C();

        // 객체생성 방법 #2 (익명이너클래스 생성)
        // 이너인터페이스는 static이 붙기때문에 바로 A.B() 사용이 가능하다
        // 이너클래스 선언할 때에는 A a = new A(); -> a.new B();
        A.B b = new A.B(){
            public void bcd() {
                System.out.println("이너이터페이스 구현 클래스 생성");
            }
        };

    }
}
