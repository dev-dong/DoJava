package sec04_stackandqueue.EX02;

import java.util.LinkedList;
import java.util.Queue;

public class QueueMethod {
    public static void main(String[] args) {

        //#1. 예외처리기능 미포함 메서드 첫번째 세트
        // Queue는 인터페이스이기 때문에 객체를 만들수 있는 자식클래스를 이용해서 생성
        Queue<Integer> queue1 = new LinkedList<Integer>();
//        System.out.println(queue1.element()); // 다음 나올 데이터 출력 - 데이터없을 때 오류(NoSuchElementException)
        
        //@1-1. add(E item)
        queue1.add(3);
        queue1.add(4);
        queue1.add(5);

        //@1-2. element()
        System.out.println(queue1.element()); // 3

        //@1-3. remove() - 데이터 꺼내기
        System.out.println(queue1.remove()); // 3
        System.out.println(queue1.remove()); // 4
        System.out.println(queue1.remove()); // 5
//        System.out.println(queue1.remove()); // 오류 발생(NoSuchElementException)

        //#2. 예외처리기능 포함 메서드 두번째 세트
        Queue<Integer> queue2 = new LinkedList<Integer>();
        System.out.println(queue1.peek()); // 에러발생x -> null 리턴

        //@2-1. offer(E item)
        queue2.offer(3);
        queue2.offer(4);
        queue2.offer(5);

        //@2-2. E peek()
        System.out.println(queue2.peek()); // 3

        //@2-3. E poll() - 데이터 순서대로 꺼내기
        System.out.println(queue2.poll()); // 3
        System.out.println(queue2.poll()); // 4
        System.out.println(queue2.poll()); // 5
        System.out.println(queue2.poll()); // null

    }
}
