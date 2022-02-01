package sec01_set.EX04;

import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;

public class TreeSetMethod_1 {
    public static void main(String[] args) {

        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 50; i > 0; i -= 2) {
            treeSet.add(i);
        }
        // 입력이 어떤식으로 되던지 간에 오름차순으로 크기대로 정렬이 된다.
        System.out.println(treeSet.toString()); // [2, 4, 6, ..., 50]

        //#1. first() - 첫번째 데이터 확인
        System.out.println(treeSet.first());

        //#2. last()
        System.out.println(treeSet.last());

        //#3. lower(E element)
        System.out.println(treeSet.lower(26)); // 26미만

        //#4. higher(E element)
        System.out.println(treeSet.higher(26)); // 26초과

        //#5. floor(E element)
        System.out.println(treeSet.floor(25)); // 25이하
        System.out.println(treeSet.floor(26)); // 26이하

        //#6 ceiling(E element)
        System.out.println(treeSet.ceiling(25)); // 25이상
        System.out.println(treeSet.ceiling(26)); // 26이상
        System.out.println();

        //#7 pollFirst() - 꺼낸다.
        int treeSetSize = treeSet.size();
        System.out.println(treeSetSize);

        for (int i = 0; i < treeSetSize; i++) {
            System.out.print(treeSet.pollFirst() + " "); // 데이터를 꺼낸다. poll이 붙으면 실제로 데이터를 꺼내서 보겠다. -> 데이터 size를 확인해보면 된다.
        }
        System.out.println();
        System.out.println(treeSet.size()); // 0이 나온다. poll로 데이터를 꺼냈으니까

        //#8. pollLast()
        for (int i = 50; i > 0; i -= 2) {
            treeSet.add(i);
        }
        treeSetSize = treeSet.size();
        for (int i = 0; i < treeSetSize; i++) {
            System.out.print(treeSet.pollLast() + " "); // 뒤에서부터 데이터가 하나씩 꺼내진다.
        }
        System.out.println(treeSet.size()); // 0이 나온다. poll로 데이터를 꺼냈으니까

        //#9. SortedSet<E> - boolean 없을때, headSet(E element)
        for (int i = 50; i > 0; i -= 2) {
            treeSet.add(i);
        }
        SortedSet<Integer> sSet = treeSet.headSet(20); // 20번까지 20번은 포함이 안된다. boolean 값이 없는경우는 SortedSet 타입이 나온다
        System.out.println(sSet.toString());

        //#10. NavigableSet<E> - boolean 있으면, headSet(E element, boolean inclusive)
        // Default - 시작값은 포함, 끝 값은 포함하지않음
        NavigableSet<Integer> nSet = treeSet.headSet(20, true); // boolean - true, 20 값을 포함시켜라, boolean 이 있으면 navigableSet
        System.out.println(nSet.toString());
        nSet = treeSet.headSet(20, false); // boolean - true, 20 값을 포함시켜라, boolean 이 있으면 navigableSet
        System.out.println(nSet.toString());

        //#11. SortedSet<E> tailSet(E element)
        for (int i = 50; i > 0; i -= 2) {
            treeSet.add(i);
        }
        sSet = treeSet.tailSet(20); // 20보다 같거나 큰 것. 20을 포함하면서 끝까지
        System.out.println(sSet.toString());

        //#12. NavigableSet<E> tailSet(E element, boolean inclusive)
        // Default - 시작값은 포함, 끝 값은 포함하지않음
        nSet = treeSet.tailSet(20, true); // 20포함
        System.out.println(nSet.toString());
        nSet = treeSet.tailSet(20, false); // 20포함하지말아라
        System.out.println(nSet.toString());

        //#13. SortedSet<E> subSet(E element, E element) - 시작과 끝 값을 다 정의해야한다.
        for (int i = 50; i > 0; i -= 2) {
            treeSet.add(i);
        }
        sSet = treeSet.subSet(10,20); // 10부터 20까지, 10은 포함하고 20은 포함하지 않음
        System.out.println(sSet.toString());

        //#14. NavigableSet<E> subSet(E element, boolean inclusive, E element, boolean inclusive)
        // Default - 시작값은 포함, 끝 값은 포함하지않음
        nSet = treeSet.subSet(10, true, 20, false); // 10은 포함하고 20은 포함하지 말아라
        System.out.println(nSet.toString());
        nSet = treeSet.subSet(10, false, 20, true); // 10은 포함하지 말고 20은 포함해라
        System.out.println(nSet.toString());

        //#15. NavigableSet<E> descendingSet() - 내림차순
        System.out.println(treeSet);
        NavigableSet<Integer> descendingSet = treeSet.descendingSet(); // NavigableSet 타입으로 return
        System.out.println(descendingSet);
        descendingSet = descendingSet.descendingSet(); // 오름차순
        System.out.println(descendingSet);
    }
}
