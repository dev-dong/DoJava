package sec01_set.EX01;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetMethod {
    public static void main(String[] args) {

        Set<String> hSet1 = new HashSet<>();

        //#1. add(E element)
        hSet1.add("가");
        hSet1.add("나");
        hSet1.add("가"); // 중복
        System.out.println(hSet1.toString()); // [가 나]

        //#2. addAll(다른 set 객체)
        Set<String> hSet2 = new HashSet<>();
        hSet2.add("나");
        hSet2.add("다");
        hSet2.addAll(hSet1);
        System.out.println(hSet2.toString());

        //#3. remove(Object o)
        hSet2.remove("나");
        System.out.println(hSet2.toString());

        //#4. clear()
        hSet2.clear();

        //#5. isEmpty()
        System.out.println(hSet2.isEmpty()); //true
        
        //#6. contains (Object o) - 포함이 되어있는지 없는지 체크
        Set<String> hSet3 = new HashSet<>();
        hSet3.add("가");
        hSet3.add("나");
        hSet3.add("다");
        System.out.println(hSet3.contains("나")); // true
        System.out.println(hSet3.contains("라")); // false

        //#7. size()
        System.out.println(hSet3.size());

        //#8. iterator()
        /*
        * iterator() 메서드를 호출하게 되면 return 값으로 Iterator 타입의 객체를 return
        * 하나씩 읽을수 있는 기능을 가짐
        * */
        Iterator<String> iterator = hSet3.iterator();
        while (iterator.hasNext()) { // 총 3바퀴, 순서는 맘대로 돌아감
            System.out.println(iterator.next());
        }

        //#9. toArray()
        Object[] objArray = hSet3.toArray(); // Object 타입으로 나옴
        System.out.println(Arrays.toString(objArray));

        //#10-1. toArray(T[] t)
        String[] strArray1 = hSet3.toArray(new String[0]); // new String[0]을 넣으면 컴파일 할 때 알아서 배열크기를 잡아줌.
        System.out.println(Arrays.toString(strArray1));

        //#10-2. toArray(T[] t)
        String[] strArray2 = hSet3.toArray(new String[5]); // new String[0]을 넣으면 컴파일 할 때 알아서 배열크기를 잡아줌.
        System.out.println(Arrays.toString(strArray2));
    }
}
