package sec01_lambdaexpression.EX09;

interface A {
    public abstract B abc();
}

class B {
    B() {
        System.out.println("첫번째 생성자");
    }

    B(int k) {
        System.out.println("두번째 생성자");
    }
}

public class RefOfClassConstructor_1 {
    public static void main(String[] args) {

        // 클래스 생성자 참조
        //@1. 익명이너클래스
        A a1 = new A() {
            @Override
            public B abc() {
                return new B(3);
            }
        };

        //@2. 람다식
        A a2 = () -> {
            return new B(3);
        };

        //@3. 클래스 생성자 참조
        /*
        * abc() 메서드에 abc(int k)가 선언되어있으면 숫자를 받을수 있는 생성자가 호출이 된다.
        * */
        A a3 = B::new; // 미완성메서드에 B라고하는 객체를 new라는 생성자를 만들어서 완성해라.

        a1.abc(); //첫번째 생성자
        a2.abc(); //첫번째 생성자
        a3.abc(); //첫번째 생성자

    }
}
