package sec02_interface.EX07;

interface A {
    default void abc() {
        System.out.println("A 인터페이스의 abc()");
    }
}

class B implements A {
    @Override
    public void abc() {
        // 부모 interface의 디폴트 메서드 호출
        A.super.abc(); // super.abc() 이건 부모 클래스의 abc() 메서드를 호출하라 부모클래스는 Object이므로 Object의 abc() 메서드를 찾는다... 오류!!
        System.out.println("B 클래스의 abc()");
    }
}

public class DefaultMethod_2 {
    public static void main(String[] args) {
        //#1. 객체생성
        B b = new B();

        //#2. 메서드 호출
        b.abc(); // A 인터페이스의 abc(), B 클래스의 abc() 2줄로 나온다.
    }
}
