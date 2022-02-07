package sec03_map.EX05;

import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.SortedMap;
import java.util.TreeMap;

public class TreeMapMethod_1 {
    public static void main(String[] args) {

        TreeMap<Integer, String> treeMap = new TreeMap<Integer, String>();

        for (int i = 20; i > 0; i -= 2) {
            treeMap.put(i, i + "번째 데이터");
        }
        System.out.println(treeMap.toString());

        // 데이터를 읽는것이지, 데이터를 꺼내지는 않는다. -> 데이터의 개수가 변함이 없다.
        //#1. firstKey()
        System.out.println(treeMap.firstKey()); // 2
        //#2. firstEntry()
        System.out.println(treeMap.firstEntry()); // 2=2번째 데이터
        //#3. lastKey()
        System.out.println(treeMap.lastKey()); // 20
        //#4. lastEntry()
        System.out.println(treeMap.lastEntry()); // 20=20번째 데이터
        //#5. lowerKey(K key)
        System.out.println(treeMap.lowerKey(11)); // 11에서 바로 왼쪽에 있는 데이터 -> 10
        System.out.println(treeMap.lowerKey(10)); // 10보다 작은것 - 10은 포함하지않는다. -> 8
        //#6. higherKey(K key)
        System.out.println(treeMap.higherKey(11)); // 12
        System.out.println(treeMap.higherKey(10)); // 10은 포함하지 않는다. -> 12

        // 데이터를 꺼내온다. -> 데이터의 개수가 변함이 있다.
        //#7. pollFirstEntry() - 데이터를 꺼내면서 실제 데이터는 없어진다.
        System.out.println(treeMap.pollFirstEntry()); // 2=2번째 데이터
        System.out.println(treeMap.toString()); // 2=2번째 데이터가 꺼내짐

        //#8. pollLastEntry()
        System.out.println(treeMap.pollLastEntry()); // 20=20번째 데이터
        System.out.println(treeMap.toString()); // 2=2번째 데이터가 꺼내짐

        /*
        * 오버로딩 : 매개변수가 다르면서, 매개변수 타입이 다르거나, 매개변수 크기가 다를 때 같은공간의 존재할 수 있으면 오버로딩
        * 다만 같은공간에 존재하기 위해서는 return 타입이 같아야한다. but return 타입이 다르다. -> headMap은 오버로딩이 아니다.
        * headMap은 다른공간에 정의가 되어있다. 각각 SortedMap쪽과 NavigableMap쪽에 각각 정의되어 있다.
        * */
        //#9. SortedMap<K, V> headMap(K toKey) - Key 끝값 -> 포함x, Key까지 앞에 부분을 따다가 쓰겠다.
        SortedMap<Integer, String> sortedMap = treeMap.headMap(8);
        System.out.println(sortedMap.toString());

        //#10. NavigableMap<K, V> headMap(K toKey, boolean inclusive)
        // SortedMap의 자식 클래스가 NavigableMap이다.
        NavigableMap<Integer, String> navigableMap = treeMap.headMap(8, true);
        System.out.println(navigableMap.toString());

        //#11. SortedMap<K, V> tailMap(K toKey) - Key 시작 포함
        sortedMap = treeMap.tailMap(14);
        System.out.println(sortedMap.toString());

        //#12. NavigableMap<K, V> tailMap(K toKey, boolean inclusive)
        // SortedMap의 자식 클래스가 NavigableMap이다.
        navigableMap = treeMap.tailMap(14, false);
        System.out.println(navigableMap.toString());

        //#13. SortedMap<K, V> subMap(K fromKey, K toKey) - fromKey포함, toKey는 포함x
        sortedMap = treeMap.subMap(6, 10);
        System.out.println(sortedMap.toString());

        //#14. NavigableMap<K, V> subMap(K fromKey, boolean inclusive, K toKey, boolean inclusive)
        // SortedMap의 자식 클래스가 NavigableMap이다.
        navigableMap = treeMap.subMap(6, false, 10, true);
        System.out.println(navigableMap.toString());

        //#15. NavigableSet<K> descendingKeySet() - Set을 뽑아다가 Set을 반대로 정렬
        NavigableSet<Integer> navigableSet =  treeMap.descendingKeySet();
        System.out.println(navigableSet.toString()); // [18, 16, 14, 12, 10, 8, 6, 4]
        System.out.println(navigableSet.descendingSet().toString()); // [4, 6, 8, 10, 12, 14, 16, 18]

        //#16. NavigableMap<K, V> descendingMap() - Map 자체 통째로 반대로 바꿔라
        navigableMap = treeMap.descendingMap();
        System.out.println(navigableMap.toString());
        System.out.println(navigableMap.descendingMap().toString());

    }
}
