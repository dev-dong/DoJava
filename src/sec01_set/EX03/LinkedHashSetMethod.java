package sec01_set.EX03;

import java.util.*;

/*
* HashSet과 LinkedHashSet의 차이점은 입력순서다. 입력순서대로 나오느냐 그렇치 않느냐.
* LinkedHashSet은 입력한 순서대로 나온다.
* */
public class LinkedHashSetMethod {
    public static void main(String[] args) {

        Set<String> linkedSet1 = new LinkedHashSet<>();

        //#1. add(E element)
        linkedSet1.add("가");
        linkedSet1.add("나");
        linkedSet1.add("가"); // 중복
        System.out.println(linkedSet1.toString()); // [가 나]

        //#2. addAll(다른 set 객체)
        Set<String> linkedSet2 = new LinkedHashSet<>();
        linkedSet2.add("나");
        linkedSet2.add("다");
        linkedSet2.addAll(linkedSet1);
        System.out.println(linkedSet2.toString()); // [나 다 가] - 입력한 순서대로 들어간다.

        //#3. remove(Object o)
        linkedSet2.remove("나");
        System.out.println(linkedSet2.toString());

        //#4. clear()
        linkedSet2.clear();

        //#5. isEmpty()
        System.out.println(linkedSet2.isEmpty()); //true
        
        //#6. contains (Object o) - 포함이 되어있는지 없는지 체크
        Set<String> linkedSet3 = new LinkedHashSet<>();
        linkedSet3.add("가");
        linkedSet3.add("나");
        linkedSet3.add("다");
        System.out.println(linkedSet3.contains("나")); // true
        System.out.println(linkedSet3.contains("라")); // false

        //#7. size()
        System.out.println(linkedSet3.size());

        //#8. iterator()
        /*
        * iterator() 메서드를 호출하게 되면 return 값으로 Iterator 타입의 객체를 return
        * 하나씩 읽을수 있는 기능을 가짐
        * */
        Iterator<String> iterator = linkedSet3.iterator();
        while (iterator.hasNext()) { // 총 3바퀴, 순서는 맘대로 돌아감
            System.out.println(iterator.next());
        }

        //#9. toArray()
        Object[] objArray = linkedSet3.toArray(); // Object 타입으로 나옴
        System.out.println(Arrays.toString(objArray));

        //#10-1. toArray(T[] t)
        String[] strArray1 = linkedSet3.toArray(new String[0]); // new String[0]을 넣으면 컴파일 할 때 알아서 배열크기를 잡아줌.
        System.out.println(Arrays.toString(strArray1));

        //#10-2. toArray(T[] t)
        String[] strArray2 = linkedSet3.toArray(new String[5]);
        System.out.println(Arrays.toString(strArray2));
    }
}
