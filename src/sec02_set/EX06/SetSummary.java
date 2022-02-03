package sec02_set.EX06;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetSummary {
    public static void main(String[] args) {

        // 입력순서와 출력순서가 가장 큰 차이점이다.
        //#1. HashSet
        Set<String> hashSet = new HashSet<>();
        hashSet.add("다");
        hashSet.add("마");
        hashSet.add("나");
        hashSet.add("가");
        System.out.println(hashSet.toString()); // 출력순서는 모른다.
        System.out.println();

        //#2. LinkedHashSet - 입력순서와 동일하게 나온다.
        Set<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("다");
        linkedHashSet.add("마");
        linkedHashSet.add("나");
        linkedHashSet.add("가");
        System.out.println(linkedHashSet.toString()); // [다, 마, 나, 가]
        System.out.println();

        //#3. TreeSet - 입력순서가 어떻게 되던지간에 오름차순으로 정렬이 된다. 따라서 반드시 크기비교가 가능해야한다.
        Set<String> treeSet = new TreeSet<>();
        treeSet.add("다");
        treeSet.add("마");
        treeSet.add("나");
        treeSet.add("가");
        System.out.println(treeSet.toString()); // [가 나 다 마]
        System.out.println();
    }
}
