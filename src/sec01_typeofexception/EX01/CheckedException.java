package sec01_typeofexception.EX01;

import java.io.FileInputStream;
import java.io.InputStreamReader;

class A { // extends Object가 생략되어 있다. clone() 메서드도 Object안에 있다.
    // clone를 사용하기 위해서는 오버라이딩 해야한다.
    // protected는 상속받은 자식은 사용할 수 있다. 다른패키지의 clone()을 호출하더라도 A는 상속을 받았기 때문에 clone()을 사용할 수 있다.
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

public class CheckedException {
    public static void main(String[] args) {
        //# Checked Exception(일반예외)

        //#1. InterruptedException
//        Thread.sleep(1000); // 예외처리를 하지 않으면 실행조차 할 수 없다.

        //#2. ClassNotFoundException - 클래스가 없을 때 발생할 수 있는 예외
//        Class cls = Class.forName("java.lang.Object"); // Class라고 하는 클래스가 있다. forName()은 동적으로 클래스를 클래스로더에 의해서 메모리에 로딩을 하는 메서드

        //#3. IOException - 입력/출력 시 발생할 수 있는 예외
//        InputStreamReader in = new InputStreamReader(System.in); // System.in은 콘솔
//        in.read();

        //#4. FileNotFoundException - 파일이 없을 때 발생하는 예외
//        FileInputStream fis = new FileInputStream("text.txt");

        //#5. CloneNotSupportedException
        A a1 = new A();
        // a1의 clone()을 찾아간다. A클래스에 없다? -> Object안의 clone()을 호출한다. Object 클래스는 A가 자식이니까 A는 clone()을 쓸 수 있는데 a1는 아무 관계가 없으므로 사용하지 못한다.
        // CheckedException도 Object를 상속받는데 쓸 수 있는거 아니냐? 맞다. 하지만 CheckedException을 clone() 할 수 있는 clone()을 쓸 수 있다. A를 clone()을 하는 clone()는 A 클래스안에서만 사용 가능
//        A a2 = (A)a1.clone(); // 오브젝트 타입을 리턴 -> 다운캐스팅
    }
}
