package chap15.EX03;

public class Quiz03 {
    public static void main(String[] args) {

        // 현재 쓰레드 객체 가져오기 + 쓰레드 이름 가져오기 + 쓰레드의 개수
        Thread curThread = Thread.currentThread();
        System.out.println(curThread.getName());
        System.out.println(curThread.activeCount()); // 쓰레드 개수

        // 새로운 쓰레드 생성 + 쓰레드 이름 가져오기
        Thread t1 = new Thread();
        System.out.println(t1.getName());

        // 두 번째 쓰레드 생성 + 쓰레드 이름 설정 + 쓰레드 이름 가져오기
        Thread t2 = new Thread();
        t2.setName("두 번째 쓰레드");
        System.out.println(t2.getName());
    }
}
