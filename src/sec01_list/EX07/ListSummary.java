package sec01_list.EX07;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class ListSummary {
    public static void main(String[] args) {

        //#1. ArrayList
        List<String> arrayList = new ArrayList<>();
        arrayList.add("다");
        arrayList.add("마");
        arrayList.add("나");
        arrayList.add("다");
        System.out.println(arrayList.toString()); // toString() 생략가능

        //#2. Vector - 모든 메서드가 동기화 되어있어서 멀티쓰레드에 유리하다.
        List<String> vector = new Vector<>();
        vector.add("다");
        vector.add("마");
        vector.add("나");
        vector.add("다");
        System.out.println(vector.toString()); // toString() 생략가능

        //#3. LinkedList
        List<String> linkedList = new LinkedList<>();
        linkedList.add("다");
        linkedList.add("마");
        linkedList.add("나");
        linkedList.add("다");
        System.out.println(linkedList.toString()); // toString() 생략가능
    }
}
