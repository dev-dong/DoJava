package sec03_throwsexception.EX03;

//#1. 하위클래스에 직접 예외를 처리하는 경우
class A {

    void abc() {
        bcd();
    }

    void bcd() {
        try {
            Class cls = Class.forName("java.lang.Object");
            Thread.sleep(1000); // 일반예외 : InterruptedException
        } catch (InterruptedException | ClassNotFoundException e) { // or를 연결해서 예외처리
        }
    }
}

//#2. 예외를 호출 메서드로 전가하는 경우
class B {

    void bcd() throws InterruptedException, ClassNotFoundException { // 100개고 1000개고 부모한테 다 전가할 수 있다.
        Class cls = Class.forName("java.lang.Object");
        Thread.sleep(1000);
    }

    void abc() {
        try {
            bcd(); // 일반예외 : InterruptedException
        } catch (InterruptedException | ClassNotFoundException e) {
            // 예외처리 구문
        }
    }
}

public class ThrowsException_3 {
}
