package sec02_staticinnerclass.EX01;

class A {
    int a = 3;
    static int b = 4;
    void method1() {
        System.out.println("instance method");
    }
    static void method2() {
        System.out.println("static method");
    }

    // static inner class
    // static은 객체를 사용하지 않아도 사용할 수 있다. 즉 static 클래스 내부안에 객체를 사용하지 않아도 사용할 수 있는것들로 구성돼야한다.
    static class B {
        void bcd() {
            // #1.
//            System.out.println(a); // static은 static만 포함 가능
            System.out.println(b);

            // #2. 메서드 호출
//            method1(); // // static은 static만 포함 가능
            method2();
        }
    }
}

public class CreateObjectAndAccessMember {
    public static void main(String[] args) {
        //#1. static inner class의 객체 생성
        // 껍데기부터 시작해서 들어가야한다. 생성자를 바로 호출 가능하지만 호출할 때도 바깥을 통해서 들어가야한다.
        A.B b = new A.B();
        b.bcd();
    }
}
