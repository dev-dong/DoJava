package sec02_interface.Ex02;

interface A {}
interface B {}

//#1. 단일인터페이스 상속
class C implements A {

}

//#2. 다중인터페이스 상속
class D implements A, B { // ,(콤마)를 가지고 구분을 한다.

}

//#3. 클래스와 인터페이스를 한번에 상속(extends와 implements의 순서는 변경 불가)
// 클래스와 클래스를 상속 할 때는 - extends (반드시 1개만 가능)
// 클래스와 인터페이스를 상속 할 때는 - implements
class E extends D implements A, B {
    
}

public class InheritanceOfInterface_1 {
}
