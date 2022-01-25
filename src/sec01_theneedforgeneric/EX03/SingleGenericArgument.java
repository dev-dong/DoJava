package sec01_theneedforgeneric.EX03;

// T 타입이 1개인 경우
class MyClass<T> {
    private T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}

public class SingleGenericArgument {
    public static void main(String[] args) {
        MyClass<String> mc1 = new MyClass<String>();
        mc1.setT("안녕");
        System.out.println(mc1.getT());

        MyClass<Integer> mc2 = new MyClass<>();
        mc2.setT(100);
        System.out.println(mc2.getT());

        MyClass<Integer> mc3 = new MyClass<>();
//        mc3.setT("안냥"); // 문법적인 오류 (강한타입 체크)
    }
}
