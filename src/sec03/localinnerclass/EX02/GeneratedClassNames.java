package sec03.localinnerclass.EX02;

// 저장 시 자동 컴파일
class A {
    void abc() {
        class B{}
        class C{}
    }
    void bcd() {
        class C{}
        class D{}
    }
}

public class GeneratedClassNames {
}
