package sec03_throwsexception.EX01;

//#1. 하위클래스에 직접 예외를 처리하는 경우
class A {

    void abc() {
        bcd();
    }

   void bcd() {
       try {
           Thread.sleep(1000); // 일반예외 : InterruptedException
       } catch (InterruptedException e) {
       }
   }
}

//#2. 예외를 호출 메서드로 전가하는 경우
class B {

    void abc() {
        try {
            bcd(); // 일반예외 : InterruptedException
        } catch (InterruptedException e) {
            // 예외처리 구문
        }
    }
    void bcd() throws InterruptedException{ // 예외전가 bcd를 호출한 애보고 예외처리해라~
        Thread.sleep(1000);
    }
}

public class ThrowsException_1 {
}
