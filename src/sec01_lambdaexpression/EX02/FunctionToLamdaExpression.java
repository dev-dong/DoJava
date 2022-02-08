package sec01_lambdaexpression.EX02;

interface A { // 입력X 리턴X
    void method1();
}

interface B { // 입력O 리턴X
    void method2(int a);
}

interface C { // 입력X 리턴O
    int method3();
}

interface D { // 입력O 리턴O
    double method4(int a, double b);
}


public class FunctionToLamdaExpression {
    public static void main(String[] args) {

        //인터페이스의 함수 구현 --> 람다식
        //#1. 입력X 리턴X
        //@1-1 익명이너클래스 방식
        A a1 = new A() {
            @Override
            public void method1() {
                System.out.println("입력x 리턴x 함수");
            }
        };

        //@1-2 람다식 표현
        A a2 = () -> {
            System.out.println("입력X 리턴X 함수");
        };
        A a3 = () -> System.out.println("입력X 리턴X 함수"); // 중괄호 삭제 가능(한줄 명령일때만 가능)

        //#2. 입력O 리턴X
        //@2-1 익명이너클래스 방식
        B b1 = new B() {
            @Override
            public void method2(int a) {
                System.out.println("입력O 리턴X 함수");
            }
        };

        //@2-2 람다식 표현 - 타입은 생략이 가능하다
        B b2 = (int a) -> {
            System.out.println("입력O 리턴X 함수");
        };
        B b3 = (a) -> {
            System.out.println("입력O 리턴X 함수");
        }; // 입력매개변수 생략 가능
        B b4 = (a) -> System.out.println("입력O 리턴X 함수"); // 중괄호 삭제 가능(한줄 명령일때만 가능)
        B b5 = a -> System.out.println("입력O 리턴X 함수"); // 입력 매개변수가 하나인 경우 소괄호도 생략가능

        //#3. 입력X 리턴O
        //@3-1 익명이너클래스 방식
        C c1 = new C() {
            @Override
            public int method3() {
                return 4;
            }
        };
        //@3-2 람다식 표현
        C c2 = () -> {
            return 4;
        };
        C c3 = () -> 4; // 하나의 명령밖에 없고 하나의 명령어 안에 return을 포함하는경우 return과 중괄호를 같이 생략

        //#4. 입력O 리턴O
        //@4-1 익명이너클래스 방식
        D d1 = new D() {
            @Override
            public double method4(int a, double b) {
                return a + b;
            }
        };
        //@4-2 람다식 표현
        D d2 = (int a, double b) -> {
            return a + b;
        };
        D d3 = (a, b) -> {
            return a + b;
        };
        D d4 = (a, b) -> a + b;
    }
}
