package sec03_genericmethod.EX02;

class A {
    public <T> void method(T t) {
        /*
        * String 타입으로 선언해도 String 메서드인 length()를 사용할 수 없다. 메서드에는 모든 타입이 다 올 수 있는 상황이 있기 때문에.
        * Object 모든 객체의 부모이므로 Object 메서드 호출이 가능하다.
        * */
//        System.out.println(t.length()); // 불가능
        System.out.println(t.equals("안녕"));
    }
}

public class AvailableMethodInGenericMethod {
    public static void main(String[] args) {

        A a = new A();
        a.<String>method("안녕");
    }
}
