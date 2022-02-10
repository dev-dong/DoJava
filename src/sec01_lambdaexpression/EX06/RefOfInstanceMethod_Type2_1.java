package sec01_lambdaexpression.EX06;

interface A {
    void abc(B b, int k);
}

class B {
    void bcd(int k){
        System.out.println(k);
    }
}

public class RefOfInstanceMethod_Type2_1 {
    public static void main(String[] args) {
        //#1. 인스턴스 메서드 참조 Type2
        //@1. 익명이너클래스
        A a1 = new A() {
            @Override
            public void abc(B b, int k) {
                /*
                * bcd()는 인스턴스 메서드니까 객체를 만들어줘야 한다.
                * 하지만 객체를 첫번째 매개변수로 넘겨주니까 객체를 안만들어도 된다. abc()를 호출할 때 객체를 만들어서 주기 때문이다.
                * 첫번째 매개변수로 객체가 만들어져서 넘어온 case 이므로 객체를 생성할 필요가 없다.
                * */
                b.bcd(k);
            }
        };

        //@2. 람다식
        A a2 = (B b, int k) -> {
            b.bcd(k);
        };

        //@3. 인스턴스 메서드 참조 Type2
        /*
        * 클래스 이름이 나왔다. 둘중에 하나이다.
        * 1. static 메서드
        * 2. 인스턴스 메서드 참조 - 첫번째 매개변수로 객체가 넘어오기 때문에 객체 만드는 과정이 없다.
        * */
        A a3 = B::bcd;
        a3.abc(new B(), 10);
    }
}
