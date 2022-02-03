package sec03_map.EX02;

import java.util.*;

class A {
    int data;

    public A(int data) {
        this.data = data;
    }
}

class B {
    int data;

    public B(int data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof B) {
            this.data = ((B) obj).data; // (B)obj은 B타입이 될것이고, 입력 매개변수로 들어온 B타입으로 다운캐스팅한 data와 같으냐?
            return true;
        }
        return false;
    }
}

class C {
    int data;

    public C(int data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof C) {
            this.data = ((C) obj).data; // (B)obj은 B타입이 될것이고, 입력 매개변수로 들어온 B타입으로 다운캐스팅한 data와 같으냐?
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        /*
        * data 기반으로 해쉬코드를 만든다. data가 똑같으면 동일한 해쉬코드가 나온다.
        * 여러개를 받을 수 있다.
         * */
        return Objects.hash(data);
//        return data;
    }
}

public class HashMapMachanism {
    public static void main(String[] args) {

        //#1. 어떤것도 오버라이딩 하지 않음
        Map<A, String> hashMap1 = new HashMap<>();
        A a1 = new A(3);
        A a2 = new A(3);
        System.out.println(a1 == a2); // false
        System.out.println(a1.equals(a2)); // equals 오버라이딩 안했으니, Object의 equals() 메서드 사용
        System.out.println(a1.hashCode() + ", " + a2.hashCode());
        hashMap1.put(a1, "첫번째");
        hashMap1.put(a2, "두번째");
        System.out.println(hashMap1.size());
        System.out.println();

//        for(A num: hashSet1) {
//            System.out.println(num.data);
//        }
        System.out.println();

        //#2. equals 메서드만 오버라이딩
        Map<B, String> hashMap2 = new HashMap<>();
        B b1 = new B(3);
        B b2 = new B(3);
        System.out.println(b1 == b2); // false
        System.out.println(b1.equals(b2)); // 내용이 같은지 비교, 오버라이딩 했으니까.
        System.out.println(b1.hashCode() + ", " + b2.hashCode());
        hashMap2.put(b1, "첫번째");
        hashMap2.put(b2, "두번째");
        System.out.println(hashMap2.size());
        System.out.println();

        //#3. equals + hashCode 메서드 오버라이딩
        Map<C, String> hashMap3 = new HashMap<>();
        C c1 = new C(3);
        C c2 = new C(3);
        System.out.println(c1 == c2); // false
        System.out.println(c1.equals(c2)); // 내용이 같은지 비교, 오버라이딩 했으니까.
        System.out.println(c1.hashCode() + ", " + c2.hashCode());
        hashMap3.put(c1, "첫번째");
        hashMap3.put(c2, "두번째");
        System.out.println(hashMap3.size());

    }
}
