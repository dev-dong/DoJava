package sec01_abstractclass.Ex02;

//추상클래스의 객체 생성 방법#2 (익명이너클래스를 이용하여 생성하여 객체 생성)
abstract class A {
    abstract void abc();
}

public class AbstractClass_2 {
    public static void main(String[] args) {

        //#1. 객체 생성 - 자식클래스 생성 없이 바로 구현(이벤트 쓸 때 사용한다)
        A a1 = new A() {
            @Override
            void abc() {
                System.out.println("방법#2. 익명이너클래스 방법으로 객체 생성");
            }
        };

        A a2 = new A() {
            @Override
            void abc() {
                System.out.println("방법#2. 익명이너클래스 방법으로 객체 생성");
            }
        };

        //#2. 메서드 호출
        a1.abc();
        a2.abc();
    }
}
