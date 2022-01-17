package sec02_interface.EX04;

//#방법1. 자식클래스 생성 + 자식클래스 생성자로 객체 생성
interface A {
    int a = 3;
    void abc(); // 생략시 public abstract
}

class B implements A {
    @Override
    public void abc() {
        System.out.println("방법#1. 자식클래스 생성 + 자식클래스 생성자로 객체 생성");
    }
}

public class CreateObjectOfInterface_1 {
    public static void main(String[] args) {
//        A a = new A(); // 인터페이스는 객체 생성 불가능. heap 메모리에는 완성 된 애들만 들어갈 수 있다.
        //#1. 객체 생성
        A b1 = new B(); // A 타입으로 선언되어도 오버라이딩 된 메서드가 호출된다.
        A b2 = new B();

        //#2. 메서드 호출
        b1.abc();
        b2.abc();
    }
}
