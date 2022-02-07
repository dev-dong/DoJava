package sec03_map.EX04;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class LinkedHashMapMethod {
    public static void main(String[] args) {
        Map<Integer, String> lhMap1 = new LinkedHashMap<>();

        //#1. put (K key, V value)
        // LinkedHashSet으로 Key를 관리한다. 실제로 Key 순서대로 출력된다. 따라서 입력순서와 출력순서가 동일하다.
        lhMap1.put(2, "나다가");
        lhMap1.put(1, "가나다");
        lhMap1.put(3, "다라마");
        System.out.println(lhMap1.toString());

        //#2. putAll(다른 맵객체)
        Map<Integer, String> lhMap2 = new LinkedHashMap<>();
        lhMap2.putAll(lhMap1);
        System.out.println(lhMap2.toString());

        //#3. replace(K key, V value)
        lhMap2.replace(1, "가가가");
        lhMap2.replace(4, "라라라"); // 동작안함 - 해당하는 Key값이 없기 때문에
        System.out.println(lhMap2.toString());

        //#4. replace(K key, V oldValue, V newValue) - 해당 key와 해당 value가 완벽하게 일치해야 동작
        lhMap2.replace(1, "가가가", "나나나");
        lhMap2.replace(2, "다다다", "라라라"); // 동작안함 - 해당하는 Key값과 value값이 없기 때문에
        System.out.println(lhMap2.toString());

        //#5. V get(Object key) - key에 해당하는 특정 value값을 가지고 오기
        System.out.println(lhMap2.get(1)); // 1, 2, 3은 인덱스 정보가 아니다. -> key정보이다.
        System.out.println(lhMap2.get(2));
        System.out.println(lhMap2.get(3));

        //#6. containsKey(Object key) - key가 있는지 물어보는것
        System.out.println(lhMap2.containsKey(1)); // true
        System.out.println(lhMap2.containsKey(5)); // false

        //#7. containsValue(Object value) - value가 있는지 물어보는것
        System.out.println(lhMap2.containsValue("나나나")); // true
        System.out.println(lhMap2.containsValue("다다다")); // false

        //#8. Set<K> keySet()
        Set<Integer> keySet = lhMap2.keySet();
        System.out.println(keySet.toString()); // [2, 1, 3]

        //#9. Set<Map.Entry<K,V>> entrySet()
        Set<Map.Entry<Integer, String>> entrySet = lhMap2.entrySet(); // Map안의 Entry 인터페이스가 있다. Entry도 제네릭 타입이기 때문에 K, V를 만들 때 지정해줘야한다.
        System.out.println(entrySet.toString()); // [2=나다가, 1=나나나, 3=다라마], Map은 중괄호로 출력되고, Set은 []로 출력된다.

        //#10. size() - Entry가 몇개이냐?
        System.out.println(lhMap2.size()); // Entry가 3개이므로 3개

        //#11. remove(Object key)
        lhMap2.remove(1);
        lhMap2.remove(4); // 4번 키가 없으므로 동작안함
        System.out.println(lhMap2.toString()); // {2=나다가, 3=다라마}

        //#12. remove(Object key, Object value)
        lhMap2.remove(2, "나다가");
        lhMap2.remove(3, "다다다"); // 동작안함 3번키가 있지만 다다다 value을 가지고 있지 않기 때문에
        System.out.println(lhMap2.toString()); // {3=다라마}

        //#13. clear()
        lhMap2.clear();
        System.out.println(lhMap2.toString());
    }
}
