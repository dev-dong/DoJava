package sec01_lambdaexpression.EX04;

interface A {
    void abc(int k);
}

public class RefOfIntanceMethod_Type1_2 {
    public static void main(String[] args) {

        //#1. 인스턴스 메서드 참조 type1 익명이너클래스

        A a1 = new A() {
            @Override
            public void abc(int k) {
                System.out.println(k); // System.out 객체에 println() 인스턴스 메서드가 있다.
            }
        };

        // 람다식
        A a2 = (int k) -> {
            System.out.println(k);
        };

        //#.3 인스턴스 메서드 참조 type1
        // abc()는 println() 인스턴스 메서드를 참조하면 된다.
//        A a3 = 객체이름::println;
        A a3 = System.out::println;

    }
}
