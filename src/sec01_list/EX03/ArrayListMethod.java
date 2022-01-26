package sec01_list.EX03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListMethod {
    public static void main(String[] args) {

        List<Integer> aList1 = new ArrayList<Integer>();

        //#1. add(E element)
        aList1.add(3);
        aList1.add(4);
        aList1.add(5);
        System.out.println(aList1.toString()); //= ~.println(aList1)

        //#2. add(int index, E element)
        aList1.add(1, 6);
        System.out.println(aList1.toString());

        //#3. addAll(또 다른 리스트 객체)
        List<Integer> aList2 = new ArrayList<>();
        aList2.add(1);
        aList2.add(2);
        aList2.addAll(aList1);
        System.out.println(aList2);

        //#4. addAll(int index, 또 다른 리스트 객체)
        List<Integer> aList3 = new ArrayList<>();
        aList3.add(1);
        aList3.add(2); // [1, 2]
        aList3.addAll(1, aList3);
        System.out.println(aList3);

        //#5. set(int index, E element)
        aList3.set(1, 5);
        aList3.set(3, 6);
//        aList3.set(4, 7); // 실행예외 : 인덱스가 넘어가버렸다. IndexOutOfBoundsException
        System.out.println(aList3);

        //#6. remove(int index)
        /*
         * 모든 제네릭은 반드시 클래스 객체 타입으로 정해줘야한다.
         * */
        aList3.remove(1); // 1번 인덱스를 삭제해라
        System.out.println(aList3);

        //#7. remove(Object o)
        aList3.remove(new Integer(2)); // deprecated - 곧 사라질 객체
//        aList3.remove(Integer.valueOf(2));
        System.out.println(aList3);

        //#8. clear() - 모든 데이터 한번에 싹 지우기
        aList3.clear();
        System.out.println(aList3);

        //#9. isEmpty()
        System.out.println(aList3.isEmpty()); // true

        //#10. size()
        System.out.println(aList3.size());
        aList3.add(1);
        aList3.add(2);
        aList3.add(3);
        System.out.println(aList3.size());

        //#11. get(int index)
        System.out.println("0번째: " + aList3.get(0));
        System.out.println("1번째: " + aList3.get(1));
        System.out.println("2번째: " + aList3.get(2));
        for (int i = 0; i < aList3.size(); i++) {
            System.out.println(i + "번째: " + aList3.get(i));
        }

        //#12. toArray() List --> Array Object[] 타입 배열
        Object[] object = aList3.toArray();
        System.out.println(Arrays.toString(object));
        
        //#13-1. toArray(T[] t) --> T[] 타입 배열
        Integer[] integer1 = aList3.toArray(new Integer[5]);
        System.out.println(Arrays.toString(integer1));

        //#13-2.
        // List 데이터보다 작은 사이즈를 배열 크기로 만들어주면 자기가 알아서 List 데이터의 개수만큼 늘려서 다시 만든다.
        Integer[] integer2 = aList3.toArray(new Integer[1]);
        System.out.println(Arrays.toString(integer2));
    }
}
