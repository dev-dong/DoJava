package sec01_set.EX05;

import java.util.TreeSet;

class MyClass {
    int data1;
    int data2;

    public MyClass(int data1, int data2) {
        this.data1 = data1;
        this.data2 = data2;
    }
}

//#1. 대소비교가 가능한 방법1 - Comparable 인터페이스 상속
class MyComparableClass implements Comparable<MyComparableClass> {
    int data1;
    int data2;

    public MyComparableClass(int data1, int data2) {
        this.data1 = data1;
        this.data2 = data2;
    }

    @Override
    public int compareTo(MyComparableClass o) { // 크기비교의 기준을 여기서 설정 (음수, 0, 양수)
        /*
         * 음수 = data1 작으면 -1
         * 0 = data1 같으면 0
         * 양수 = data1 크면 1
         * */
        if (this.data1 < o.data1) return -1;
        else if (this.data1 == o.data1) return 0;
        else return 1;
    }
}

public class TreeSetMethod_2 {
    public static void main(String[] args) {

        //#1. Integer 크기 비교 - Integer은 이미 벌써 크기 비교가 가능하다
        TreeSet<Integer> treeSet1 = new TreeSet<Integer>();
        Integer intValue1 = new Integer(20);
        Integer intValue2 = new Integer(10);
        treeSet1.add(intValue1);
        treeSet1.add(intValue2);
        System.out.println(treeSet1.toString());

        //#2. String 크기 비교 - String도 사전순서대로 크고 작음이 정의되어있다.
        TreeSet<String> treeSet2 = new TreeSet<String>();
        String str1 = "가나";
        String str2 = "다라";
        treeSet2.add(str1);
        treeSet2.add(str2);
        System.out.println(treeSet2.toString());

//        //#3. MyClass 객체 크기 비교 - 크기비교를 할 수 없는 객체는 treeSet에 저장할 수 없다.
//        TreeSet<MyClass> treeSet3 = new TreeSet<MyClass>();
//        MyClass myClass1 = new MyClass(2, 5);
//        MyClass myClass2 = new MyClass(3, 3);
//        treeSet3.add(myClass1); // myClass1이 Comparable인지를 체크한다. 그래서 Comparable을 캐스팅을 해보고 안되면 ClassCastException 예외발생.
//        treeSet3.add(myClass2);
//        System.out.println(treeSet3.toString()); // ClassCastException 예외발생 - 데이터를 추가하는 과정에서 오류가 발생. treeSet에서 add할 때 크기대로 데이터를 넣는데 myClass1에서 크기비교를 못하기 때문에 예외발생

        //#4. MyComparableClass 객체 크기 비교 - 크기비교를 할 수 없는 객체는 treeSet에 저장할 수 없다.
        TreeSet<MyComparableClass> treeSet4 = new TreeSet<MyComparableClass>();
        MyComparableClass mycomparableClass1 = new MyComparableClass(2, 5);
        MyComparableClass mycomparableClass2 = new MyComparableClass(3, 3);
        treeSet4.add(mycomparableClass1);
        treeSet4.add(mycomparableClass2);

        for (MyComparableClass mcc : treeSet4) {
            System.out.println(mcc.data1);
        }
        System.out.println(treeSet4.toString());
    }
}
