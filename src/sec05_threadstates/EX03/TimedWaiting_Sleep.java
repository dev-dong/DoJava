package sec05_threadstates.EX03;

class MyThread extends Thread {
    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println(" -- sleep() 진행중 interrupt 발생"); // interrupt - 자고있는넘 깨운다.
            for (long i = 0; i < 1000000000L; i++) {}
        }
    }
}

public class TimedWaiting_Sleep {
    public static void main(String[] args) {

        MyThread myThread = new MyThread();
        myThread.start(); // 1. cpu를 사용하기 위한 메모리 할당부터 시작해서 기본적인 준비하는것 + 2. run() 메서드를 호출하는것.
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("MyThread State = " + myThread.getState()); // TIMED_WAITING

        myThread.interrupt();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("MyThread State = " + myThread.getState()); // RUNNABLE
    }
}
