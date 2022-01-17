package sec02_interface.EX06;

interface A {
    void abc(); // 2020년 생성
    default void bcd(){
        System.out.println("A 인터페이스의 bcd()");
    } // 2030년 생성(추가)
}

class B implements A { // 2020년 생성 ,2030년 생성까지 해야 할 의무가 생김(클래스가 100개라면??? 생각만 해도 아찔) -> 디폴트 메서드 생성하자.
    @Override
    public void abc() {
        System.out.println("B 클래스의 abc()");
    }
}

class C implements A {
    @Override
    public void abc() {
        System.out.println("C 클래스의 abc()");
    }

    @Override
    public void bcd() {
        System.out.println("C 클래스의 bcd()"); // c 클래스는 A의 bcd()가 C class로 내려가면서 오버라이딩 되면서 C의 bcd()가 호출된다.
    }
}

public class DefaultMethod_1 {
    public static void main(String[] args) {
        //#1. 객체 생성
        A a1 = new B();
        A a2 = new C();



        //#2. 메서드 호출
        a1.abc(); // B 클래스의 abc()
        a1.bcd(); // B 클래스는 오버라이딩이 안됐으니 그대로 A의 bcd() 호출

        a2.abc(); // C 클래스의 abc()
        a2.bcd(); // C 클래스의 bcd()

    }
}
