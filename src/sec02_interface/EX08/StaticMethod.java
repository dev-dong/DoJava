package sec02_interface.EX08;

interface A {
    // 완성된 메서드(static)
    public static void abc() {
        System.out.println("A 인터페이스의 정적 메서드 abc()");
    }
}

public class StaticMethod {
    public static void main(String[] args) {
        //#1. 정적메서드 호출
        A.abc();
    }
}
