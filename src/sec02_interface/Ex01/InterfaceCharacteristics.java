package sec02_interface.Ex01;

interface  A {
    public static final int a = 3; // 반드시 인터페이스 내부의 필드는 public static final만 가질 수 있다.
    public abstract void abc(); // 미완성 메소드이니까 {} 필요없다.
}

interface  B {
    int b = 3; // public static final 생략해도 컴파일러가 자동 추가
    void bcd(); // public abstract 생략해도 컴파일러가 자동 추가
}

public class InterfaceCharacteristics {
    public static void main(String[] args) {
        //#1. static 자동추가 체크
        System.out.println(A.a);
        System.out.println(B.b);
        
        //#2. final 자동추가 체크 - final : 값을 대입하는거조차 불가능하다.
//        A.a = 5; // 값 변경 불가능
//        B.b = 5; // 값 변경 불가능 - final 특성


    }
}
