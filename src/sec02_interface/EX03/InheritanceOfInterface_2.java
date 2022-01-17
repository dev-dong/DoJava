package sec02_interface.EX03;

// 접근지정자
interface A {
    public abstract void abc();
}

interface B {
    void bcd(); // 생략 시 public abstract
}

class C implements  A {
    @Override
    public void abc() {
        // 완성 메서드와 미완성 메서드 구분점은 {}(중괄호)이다.
    }
}

//class D implements B {
//    @Override
//    // 오버라이딩은 부모보다 접근지정자가 같거다 커야한다!!!
//    public void bcd() { // public -> default 불가능
//
//    }
//}

public class InheritanceOfInterface_2 {
}
