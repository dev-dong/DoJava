package sec04_BoundedType.EX02;

class A {
    public <T extends String> void method1(T t) { // String은 final Class - 자식 클래스 만들수 없다.
        System.out.println(t.charAt(0));
    }
}

interface MyInterface {
    public abstract void print();
}

class B {
    public <T extends MyInterface> void method1(T t) { // extends : "상속해라"가 아니다.
        t.print();
    }
}

class C implements MyInterface {
    @Override
    public void print() {
        System.out.println("print() 구현2");
    }
}

public class BoundedTypeOfGenericMethod {
    public static void main(String[] args) {
        A a = new A();
        a.<String>method1("안녕");

        B b = new B();
        b.<MyInterface>method1(new MyInterface() {
            @Override
            public void print() {
                System.out.println("print() 구현");
            }
        });

        B b1 = new B();
        MyInterface c = new C();
        b1.<MyInterface>method1(c);

    }
}
