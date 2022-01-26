package sec01_list.EX01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayVsList {
    public static void main(String[] args) {

        //#1. 배열
        String[] array = new String[] {"가", "나", "다", "라", "마", "바", "사"};

        array[2] = null;
        array[5] = null;

        System.out.println(array.length);
        System.out.println(Arrays.toString(array)); // array의 배열을 그대로 출력시켜준다.
        System.out.println();

        //#2. List
        /*
        * List는 얼마든지 데이터를 추가, 삭제가 가능하다. 실제로 size()가 바뀐다.
        * 반면 배열은 만들어지고나면 객체가 사라지고 날때까지 length는 고정이다.
        * */
        List<String> aList = new ArrayList<String>(); // 처음에 만들고 나면 size는 0이다.
        System.out.println(aList.size()); // 데이터의 개수 구하기
        aList.add("가");
        aList.add("나");
        aList.add("다");
        aList.add("라");
        aList.add("마");
        aList.add("바");
        aList.add("사");
        System.out.println(aList.size()); // 데이터의 개수 구하기

        aList.remove("다");
        aList.remove("바");
        System.out.println(aList.size()); // 데이터의 개수 구하기
        System.out.println(aList); // toString()이 오버라이딩 되어있어서 출력이 가능하다.
    }
}
