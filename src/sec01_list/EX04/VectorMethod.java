package sec01_list.EX04;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class VectorMethod {
    public static void main(String[] args) {

        List<Integer> vector1 = new Vector<>();

        //#1. add(E element)
        vector1.add(3);
        vector1.add(4);
        vector1.add(5);
        System.out.println(vector1.toString()); //= ~.println(aList1)

        //#2. add(int index, E element)
        vector1.add(1, 6);
        System.out.println(vector1.toString());

        //#3. addAll(또 다른 리스트 객체)
        List<Integer> vector2 = new Vector<>();
        vector2.add(1);
        vector2.add(2);
        vector2.addAll(vector1);
        System.out.println(vector2);

        //#4. addAll(int index, 또 다른 리스트 객체)
        List<Integer> vector3 = new Vector<>();
        vector3.add(1);
        vector3.add(2); // [1, 2]
        vector3.addAll(1, vector3);
        System.out.println(vector3);

        //#5. set(int index, E element)
        vector3.set(1, 5);
        vector3.set(3, 6);
//        vector3.set(4, 7); // 실행예외 : 인덱스가 넘어가버렸다. IndexOutOfBoundsException
        System.out.println(vector3);

        //#6. remove(int index)
        /*
         * 모든 제네릭은 반드시 클래스 객체 타입으로 정해줘야한다.
         * */
        vector3.remove(1); // 1번 인덱스를 삭제해라
        System.out.println(vector3);

        //#7. remove(Object o)
        vector3.remove(new Integer(2)); // deprecated - 곧 사라질 객체
//        vector3.remove(Integer.valueOf(2));
        System.out.println(vector3);

        //#8. clear() - 모든 데이터 한번에 싹 지우기
        vector3.clear();
        System.out.println(vector3);

        //#9. isEmpty()
        System.out.println(vector3.isEmpty()); // true

        //#10. size()
        System.out.println(vector3.size());
        vector3.add(1);
        vector3.add(2);
        vector3.add(3);
        System.out.println(vector3.size());

        //#11. get(int index)
        System.out.println("0번째: " + vector3.get(0));
        System.out.println("1번째: " + vector3.get(1));
        System.out.println("2번째: " + vector3.get(2));
        for (int i = 0; i < vector3.size(); i++) {
            System.out.println(i + "번째: " + vector3.get(i));
        }

        //#12. toArray() List --> Array Object[] 타입 배열
        Object[] object = vector3.toArray();
        System.out.println(Arrays.toString(object));
        
        //#13-1. toArray(T[] t) --> T[] 타입 배열
        Integer[] integer1 = vector3.toArray(new Integer[5]);
        System.out.println(Arrays.toString(integer1));

        //#13-2.
        // List 데이터보다 작은 사이즈를 배열 크기로 만들어주면 자기가 알아서 List 데이터의 개수만큼 늘려서 다시 만든다.
        Integer[] integer2 = vector3.toArray(new Integer[1]);
        System.out.println(Arrays.toString(integer2));
    }
}
