package sec03_threadproperties.EX01;

// 쓰레드 객체 가져오기/ 이름설정/ 쓰레드 수

public class ThreadProperties_1 {
    public static void main(String[] args) {

        //#1. 객체 가져오기 (currentThread()) - 정적메서드 / 쓰레드 수 (activeCount())
        Thread curThread = Thread.currentThread(); // main 쓰레드의 정보를 가져올 수 있다.
        System.out.println("현재쓰레드의 이름 = " + curThread.getName());
        System.out.println("동작하는 쓰레드 수 = " + Thread.activeCount()); // 정적메서드

        //#2. 쓰레드 이름 지정 (자동지정)
        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread();
            System.out.println(thread.getName());
            thread.start();
        }

        //#3. 쓰레드 이름 직접 지정
        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread();
            thread.setName(i + "번째 쓰레드");
            System.out.println(thread.getName());
            thread.start();
        }

        //#4. 쓰레드 이름 지정 (자동지정)
        // 한번이라도 쓰레드가 만들어지면 번호는 카운터 증가한다.
        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread();
            System.out.println(thread.getName());
            thread.start();
        }

        //#5. 쓰레드 수 - 실제로 쓰레드가 돌아가고 있는 수이다. cpu에 access하고 있는 수, 한번이라도 생성 된 쓰레드 수가 아니다.
        System.out.println(Thread.activeCount());
    }
}
