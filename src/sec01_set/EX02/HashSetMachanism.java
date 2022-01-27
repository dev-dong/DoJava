package sec01_set.EX02;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

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
        if (obj instanceof B) {
            this.data = ((B) obj).data; // (B)obj은 B타입이 될것이고, 입력 매개변수로 들어온 B타입으로 다운캐스팅한 data와 같으냐?
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

public class HashSetMachanism {
    public static void main(String[] args) {

        //#1. 어떤것도 오버라이딩 하지 않음
        Set<A> hashSet1 = new HashSet<>();
        A a1 = new A(3);
        A a2 = new A(3);
        System.out.println(a1 == a2); // false
        System.out.println(a1.equals(a2)); // equals 오버라이딩 안했으니, Object의 equals() 메서드 사용
        System.out.println(a1.hashCode() + ", " + a2.hashCode());
        hashSet1.add(a1);
        hashSet1.add(a2);
        System.out.println(hashSet1.size());

//        for(A num: hashSet1) {
//            System.out.println(num.data);
//        }
        System.out.println();

        //#2. equals 메서드만 오버라이딩
        Set<B> hashSet2 = new HashSet<>();
        B b1 = new B(3);
        B b2 = new B(3);
        System.out.println(b1 == b2); // false
        System.out.println(b1.equals(b2)); // 내용이 같은지 비교, 오버라이딩 했으니까.
        System.out.println(b1.hashCode() + ", " + b2.hashCode());
        hashSet2.add(b1);
        hashSet2.add(b2);
        System.out.println(hashSet2.size());
        System.out.println();

        //#3. equals + hashCode 메서드 오버라이딩
        Set<C> hashSet3 = new HashSet<>();
        C c1 = new C(3);
        C c2 = new C(3);
        System.out.println(c1 == c2); // false
        System.out.println(c1.equals(c2)); // 내용이 같은지 비교, 오버라이딩 했으니까.
        System.out.println(c1.hashCode() + ", " + c2.hashCode());
        hashSet3.add(c1);
        hashSet3.add(c2);
        System.out.println(hashSet2.size());

    }
}
