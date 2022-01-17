package sec01_abstractclass.Ex01;

// 추상클래스의 객체 생성 방법 #1 (자식클래스 생성 + 자식클래스 생성자를 가지고 객체 생성)
abstract class A {
    abstract void abc();
}

// 다형성 : B 는 A다.
class B extends A {
    @Override
    public void abc() {
        System.out.println("방법#1. 자식클래스 생성 및 추상메서드 구현");
    }
}

public class AbstractClass_1 {
    public static void main(String[] args) {

        //#1. 객체생성
//        A a = new A(); // 불가능 -> 미완성 메서드가 있기 때문에
        B b1 = new B();
        B b2 = new B();

        //#2. 메서드 호출
        b1.abc(); //방법#1. 자식클래스 생성 및 추상메서드 구현
        b2.abc(); //방법#1. 자식클래스 생성 및 추상메서드 구현
        
    }
}
