package sec05_threadstates.EX01;

public class NewRunnableTerminated {
    public static void main(String[] args) {
        //# 쓰레드 상태 저장 클래스
        Thread.State state;

        //#1. 객체 생성 (NEW)
        Thread thread = new Thread() {
            @Override
            public void run() {
                for (long i = 0; i < 10000000000L; i++) {
                } // 아무짓도 안하면서 for문을 돌린것(시간지연) - 돌아가는 시간을 만들어주기위해서 sleep은 안된다.
            }
        };

        state = thread.getState();
        System.out.println("thread state = " + state); // NEW

        //#2. Thread 시작
        thread.start();
        state = thread.getState();
        System.out.println("thread state = " + state); // Runnable

        //#3. Thread 종료
        try {
            thread.join(); // thread 끝날때까지 main 쓰레드는 일시정지하고 있다.
        } catch (InterruptedException e) {
        }

        state = thread.getState();
        System.out.println("thread state = " + state); // Runnable
    }
}
