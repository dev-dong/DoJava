package sec03_map.EX03;

import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

// HashMap과 완전하게 동일하다. 차이점은 Hashtable은 멀티쓰레드에 안전하다. 내부적으로 중요 메소드들이 동기화(synchronize) 되어져 있기 때문에.
// 입력이 어떻게 들어가던지 간에 출력이 마음대로 나온다. key가 HashSet으로 관리되기 때문이다.
public class HashTableMethod {
    public static void main(String[] args) {
        Map<Integer, String> hTable1 = new Hashtable<>();

        //#1. put (K key, V value)
        hTable1.put(2, "나다가");
        hTable1.put(1, "가나다");
        hTable1.put(3, "다라마");
        System.out.println(hTable1.toString()); // key 자체가 set으로 관리 되기 때문에 hashSet으로 관리된다.

        //#2. putAll(다른 맵객체)
        Map<Integer, String> hTable2 = new Hashtable<Integer, String>();
        hTable2.putAll(hTable1);
        System.out.println(hTable2.toString());

        //#3. replace(K key, V value)
        hTable2.replace(1, "가가가");
        hTable2.replace(4, "라라라"); // 동작안함 - 해당하는 Key값이 없기 때문에
        System.out.println(hTable2.toString());

        //#4. replace(K key, V oldValue, V newValue) - 해당 key와 해당 value가 완벽하게 일치해야 동작
        hTable2.replace(1, "가가가", "나나나");
        hTable2.replace(2, "다다다", "라라라"); // 동작안함 - 해당하는 Key값과 value값이 없기 때문에
        System.out.println(hTable2.toString());

        //#5. V get(Object key) - key에 해당하는 특정 value값을 가지고 오기
        System.out.println(hTable2.get(1)); // 1, 2, 3은 인덱스 정보가 아니다. -> key정보이다.
        System.out.println(hTable2.get(2));
        System.out.println(hTable2.get(3));

        //#6. containsKey(Object key) - key가 있는지 물어보는것
        System.out.println(hTable2.containsKey(1)); // true
        System.out.println(hTable2.containsKey(5)); // false

        //#7. containsValue(Object value) - value가 있는지 물어보는것
        System.out.println(hTable2.containsValue("나나나")); // true
        System.out.println(hTable2.containsValue("다다다")); // false

        //#8. Set<K> keySet()
        Set<Integer> keySet = hTable2.keySet();
        System.out.println(keySet.toString()); // [1, 2, 3]

        //#9. Set<Map.Entry<K,V>> entrySet()
        Set<Map.Entry<Integer, String>> entrySet = hTable2.entrySet(); // Map안의 Entry 인터페이스가 있다. Entry도 제네릭 타입이기 때문에 K, V를 만들 때 지정해줘야한다.
        System.out.println(entrySet.toString()); // [1=나나나, 2=나다가, 3=다라마], Map은 중괄호로 출력되고, Set은 []로 출력된다.

        //#10. size() - Entry가 몇개이냐?
        System.out.println(hTable2.size()); // Entry가 3개이므로 3개

        //#11. remove(Object key)
        hTable2.remove(1);
        hTable2.remove(4); // 4번 키가 없으므로 동작안함
        System.out.println(hTable2.toString()); // {2=나다가, 3=다라마}

        //#12. remove(Object key, Object value)
        hTable2.remove(2, "나다가");
        hTable2.remove(3, "다다다"); // 동작안함 3번키가 있지만 다다다 value을 가지고 있지 않기 때문에
        System.out.println(hTable2.toString()); // {3=다라마}

        //#13. clear()
        hTable2.clear();
        System.out.println(hTable2.toString());
    }
}
