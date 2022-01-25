package sec03_genericmethod.EX01;

//일반클래스 안에 제네릭 메서드
/*
 * 제네릭 클래스 vs 제네릭 메서드
 * 1. 제네릭 클래스 : 객체 생성 될 때 T가 정해진다.
 * 2. 제네릭 메서드 : 메서드 호출 할 때 T가 정해진다.
 * */
class GenericMethods {
    public <T> T method1(T t) {
        return t;
    }

    public <T> boolean method2(T t1, T t2) {
        return t1.equals(t2);
    }

    public <K, V> void method3(K k, V v) {
        System.out.println(k + ":" + v);
    }
}

public class GenericMethod {
    public static void main(String[] args) {
        GenericMethods gm = new GenericMethods();
        String str1 = gm.<String>method1("안녕"); // <String>은 생략가능하다. 매개변수로 T가 무엇인지 유추가 가능할 때
        String str2 = gm.method1("안녕");
        System.out.println(str1);
        System.out.println(str2);

        boolean bool1 = gm.<Double>method2(2.5, 2.5);
        boolean bool2 = gm.method2(2.5, 2.5);
        System.out.println(bool1);
        System.out.println(bool2);

        gm.<String, Integer>method3("국어", 80);
        gm.method3("국어", 80);
    }
}
