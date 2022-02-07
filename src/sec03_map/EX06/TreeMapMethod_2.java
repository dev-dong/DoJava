package sec03_map.EX06;

import java.util.Comparator;
import java.util.TreeMap;

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

//        if(this.data2<o.data2) return 1; // data2가 작은 값을 가지는 객체일수록 더 큰 책체야

    }

    @Override
    public String toString() {
        return "data1=" + data1 + "을 가지고 있는 클래스";
    }
}

public class TreeMapMethod_2 {
    public static void main(String[] args) {

        //#1. Integer 크기 비교 - Key는 중복될수 없다. Key 자체가 TreeSet으로 관리되기 때문이다.
        TreeMap<Integer, String> treeMap1 = new TreeMap<Integer, String>();
        Integer intValue1 = new Integer(20);
        Integer intValue2 = new Integer(10);
        treeMap1.put(intValue1, "가나다");
        treeMap1.put(intValue2, "나라다");
        System.out.println(treeMap1.toString());

        //#2. String 크기 비교 - String도 사전순서대로 크고 작음이 정의되어있다.
        TreeMap<String, Integer> treeMap2 = new TreeMap<String, Integer>();
        String str1 = "가나";
        String str2 = "다라";
        treeMap2.put(str1, 10);
        treeMap2.put(str2, 20);
        System.out.println(treeMap2.toString()); // {가나=10, 다라=20}

        //#3. MyClass 객체 크기 비교 - 크기비교가 없기때문에 오류발생!!
//        TreeMap<MyClass, String> treeMap3 = new TreeMap<MyClass, String>();
//        MyClass myClass1 = new MyClass(2, 5);
//        MyClass myClass2 = new MyClass(3, 3);
//        treeMap3.put(myClass1, "가나다");
//        treeMap3.put(myClass2, "나다라");
//        System.out.println(treeMap3.toString()); // ClassCastException발생 - 데이터 추가할 때 크기비교를 하면서 데이터를 추가하는데 크기비교 기준을 제공하지 않아서 오류가 발생

        //#4. MyComparableClass 객체 크기 비교 방법#1
        TreeMap<MyComparableClass, String> treeMap4 = new TreeMap<MyComparableClass, String>();
        MyComparableClass mycomparableClass1 = new MyComparableClass(2, 5);
        MyComparableClass mycomparableClass2 = new MyComparableClass(3, 3);
        treeMap4.put(mycomparableClass1, "가나다");
        treeMap4.put(mycomparableClass2, "나다라");
        System.out.println(treeMap4.toString()); // {data1=2을 가지고 있는 클래스=가나다, data1=3을 가지고 있는 클래스=나다라}

        //#5. MyClass 객체 크기 비교 방법#2
        TreeMap<MyClass, String> treeMap5 = new TreeMap<MyClass, String>(new Comparator<MyClass>() { // Comparator 인터페이스
            @Override
            public int compare(MyClass o1, MyClass o2) { // MyClass o1이 기준, MyClass o2는 비교대상
                System.out.println("o1.data1 = " + o1.data1);
                System.out.println("o2.data1 = " + o2.data1);
                if (o1.data1 < o2.data1) return -1;
                else if (o1.data1 == o2.data1) return 0;
                else return 1;
            }
        });

        MyClass myClass1 = new MyClass(2, 5);
        MyClass myClass2 = new MyClass(3, 3);
        treeMap5.put(myClass1, "가나다");
        treeMap5.put(myClass2, "나다라");
        System.out.println(treeMap5.toString());
    }
}
