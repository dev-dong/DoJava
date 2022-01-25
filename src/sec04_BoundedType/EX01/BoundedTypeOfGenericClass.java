package sec04_BoundedType.EX01;

class A {
}

class B extends A {
}

class C extends B {
}

class D<T extends B> { // B와 C만 올 수 있다
    private T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}

public class BoundedTypeOfGenericClass {
    public static void main(String[] args) {
//        D<A> d1 = new D<A>(); // 불가능 : B와 C만 올 수 있다
        D<B> d2 = new D<>(); // 불가능 : B와 C만 올 수 있다
        D<C> d3 = new D<>(); // 불가능 : B와 C만 올 수 있다
        D d4 = new D(); // D<B> d4 = new D<B>();

        d2.setT(new B());
        d2.setT(new C());

//        d3.setT(new B()); // 불가능
        d3.setT(new C());

        d4.setT(new B());
    }
}
