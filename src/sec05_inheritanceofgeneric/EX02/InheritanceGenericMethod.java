package sec05_inheritanceofgeneric.EX02;

class Parent {
    // Number : boolean, char을 제외한 숫자를 저장하는 클래스들을 wrapping
    <T extends Number> void print(T t) {
        System.out.println(t);
    }
}

// Parent 클래스의 모든 내용이 Child 클래스안에 고대로 다 들어간다.
class Child extends Parent {

}

public class InheritanceGenericMethod {
    public static void main(String[] args) {

        //#1. 부모클래스 제네릭메서드 이용
        Parent p = new Parent();
        p.<Integer>print(10);
        p.print(10);
        p.print(2.5);

        //#2. 자식클래스 제네릭메서드 이용
        Child c = new Child();
        c.<Integer>print(10);
        c.print(10);
        c.<Double>print(5.9);
        c.print(5.9);
    }
}
