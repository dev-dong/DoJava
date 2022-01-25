package sec05_inheritanceofgeneric.EX01;

class Parent<T> {
    T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}

class Child1<T> extends Parent<T> { // 부모가 제네릭이면 자식클래스도 어쩔수 없이 제네릭이 되어야한다. 왜? 부모의 내용이 자식으로 그대로 내려가기 때문에
}

class Child2<T, V> extends Parent<T> {
    V v;

    public V getV() {
        return v;
    }

    public void setV(V v) {
        this.v = v;
    }
}

public class InheritanceGenericClass {
    public static void main(String[] args) {
        //#1. 부모제네릭클래스
        Parent<String> p = new Parent<>();
        p.setT("부모제네릭클래스");
        System.out.println(p.getT());

        //#2. 자식클래스1
        Child1<String> c1 = new Child1<>();
        c1.setT("자식1 제네릭클래스");
        System.out.println(c1.getT());

        //#2. 자식클래스2
        Child2<String, Integer> c2 = new Child2<>();
        c2.setT("자식2 제네릭클래스");
        c2.setV(100);
        System.out.println(c2.getT());
        System.out.println(c2.getV());
    }
}
