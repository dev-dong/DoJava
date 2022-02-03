package sec03_map.EX01;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapMethod {
    public static void main(String[] args) {
        Map<Integer, String> hMap1 = new HashMap<Integer, String>();

        //#1. put (K key, V value)
        hMap1.put(2, "나다가");
        hMap1.put(1, "가나다");
        hMap1.put(3, "다라마");
        System.out.println(hMap1.toString()); // key 자체가 set으로 관리 되기 때문에 hashSet으로 관리된다.

        //#2. putAll(다른 맵객체)
        Map<Integer, String> hMap2 = new HashMap<Integer, String>();
        hMap2.putAll(hMap1);
        System.out.println(hMap2.toString());

        //#3. replace(K key, V value)
        hMap2.replace(1, "가가가");
        hMap2.replace(4, "라라라"); // 동작안함 - 해당하는 Key값이 없기 때문에
        System.out.println(hMap2.toString());

        //#4. replace(K key, V oldValue, V newValue) - 해당 key와 해당 value가 완벽하게 일치해야 동작
        hMap2.replace(1, "가가가", "나나나");
        hMap2.replace(2, "다다다", "라라라"); // 동작안함 - 해당하는 Key값과 value값이 없기 때문에
        System.out.println(hMap2.toString());

        //#5. V get(Object key) - key에 해당하는 특정 value값을 가지고 오기
        System.out.println(hMap2.get(1)); // 1, 2, 3은 인덱스 정보가 아니다. -> key정보이다.
        System.out.println(hMap2.get(2));
        System.out.println(hMap2.get(3));

        //#6. containsKey(Object key) - key가 있는지 물어보는것
        System.out.println(hMap2.containsKey(1)); // true
        System.out.println(hMap2.containsKey(5)); // false

        //#7. containsValue(Object value) - value가 있는지 물어보는것
        System.out.println(hMap2.containsValue("나나나")); // true
        System.out.println(hMap2.containsValue("다다다")); // false

        //#8. Set<K> keySet()
        Set<Integer> keySet = hMap2.keySet();
        System.out.println(keySet.toString()); // [1, 2, 3]

        //#9. Set<Map.Entry<K,V>> entrySet()
        Set<Map.Entry<Integer, String>> entrySet = hMap2.entrySet(); // Map안의 Entry 인터페이스가 있다. Entry도 제네릭 타입이기 때문에 K, V를 만들 때 지정해줘야한다.
        System.out.println(entrySet.toString()); // [1=나나나, 2=나다가, 3=다라마], Map은 중괄호로 출력되고, Set은 []로 출력된다.

        //#10. size() - Entry가 몇개이냐?
        System.out.println(hMap2.size()); // Entry가 3개이므로 3개

        //#11. remove(Object key)
        hMap2.remove(1);
        hMap2.remove(4); // 4번 키가 없으므로 동작안함
        System.out.println(hMap2.toString()); // {2=나다가, 3=다라마}

        //#12. remove(Object key, Object value)
        hMap2.remove(2, "나다가");
        hMap2.remove(3, "다다다"); // 동작안함 3번키가 있지만 다다다 value을 가지고 있지 않기 때문에
        System.out.println(hMap2.toString()); // {3=다라마}

        //#13. clear()
        hMap2.clear();
        System.out.println(hMap2.toString());
    }
}
