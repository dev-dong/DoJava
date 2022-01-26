package sec01_list.EX02;

import java.util.*;

public class CreateListObject {
    public static void main(String[] args) {

        //#방법1. List 구현 클래스의 생성자를 사용하여 객체 생성
        /*
        * List는 인터페이스니까 자식을 통해서 생성자를 사용해서 객체를 만들겠다.
        * 다형적인 표현을 이용해서 List로 통일
        * capacity는 size()와는 전혀 다른 것. 정작 알아야 할 것은 size()이다.
        * */
        List<Integer> aList1 = new ArrayList<>(); // 기본적인 capacity = 10
        List<Integer> aList2 = new ArrayList<>(30); // capacity(메모리저장공간) : 미리 메모리를 동적으로 잡아놓는것

        List<Integer> aList3 = new Vector<>();
        List<Integer> aList4 = new Vector<>(30);

        List<Integer> aList5 = new LinkedList<>();
//        List<Integer> aList6 = new LinkedList<>(30); // LinkedList는 저장용량을 지정하는 생성자 없음
        
        //#방법2. Arrays 클래스의 정적 메서드 활용
        /*
        * asList는 제네릭 메서드이며, <제네릭>.asList()이다. 매개변수로 받는 타입으로 제네릭타입이 결정 되기 때문에 생략이 가능하다.
        * 한정적인 제한조건 : 데이터의 크기를 바꿀 수 없다.
        * Arrays는 배열을 관리하는 클래스이기 때문에 껍대기를 List로 감싸주고 리턴, 실제로 내부적으론 배열을 가지고 있다.
        * 데이터의 크기를 변경 할수없고, 값은 변경이 가능하다.
        * */
        List<Integer> aList7 = Arrays.asList(1,2,3,4); // 4개를 Integer로 가지고 있는 List 생성
        List<String> aList8 = Arrays.asList("안녕", "방가"); // 100개고 1000개가 들어갈 수 있다.
        aList7.set(1, 7);
        aList8.set(0, "감사");
//        aList7.add(5); // 크기를 변경할 수 없다.
//        aList8.remove(0); // 크기를 변경할 수 없다.
        System.out.println(aList7);
        System.out.println(aList8);


    }
}
