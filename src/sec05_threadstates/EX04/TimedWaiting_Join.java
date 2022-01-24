package sec05_threadstates.EX04;

class MyThread1 extends Thread {
    @Override
    public void run() {
        for (long i = 0; i < 10000000000L; i++) {
        }
    }
}

class MyThread2 extends Thread {
    MyThread1 myThread1;

    public MyThread2(MyThread1 myThread1) {
        this.myThread1 = myThread1;
    }

    @Override
    public void run() {
        try {
            myThread1.join(3000); // 3초동안 myThread1한테 일만 하게 하겠다. MyThread2는 쉬고있다. 1초만에 myThread1가 끝나면 바로 넘어간다. 무조건 3초를 기다리는게 아니고 최대 3초를 기다리겠다.
        } catch (InterruptedException e) {
            System.out.println(" -- join() 진행중 interrupt 발생"); // interrupt - 자고있는넘 깨운다.
            for (long i = 0; i < 1000000000L; i++) {
            } //시간지연
        }
    }
}

public class TimedWaiting_Join {
    public static void main(String[] args) {
        MyThread1 myThread1 = new MyThread1();
        MyThread2 myThread2 = new MyThread2(myThread1);
        myThread1.start();
        myThread2.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } // 쓰레드 준비시간

        System.out.println("MyThread1 State = " + myThread1.getState());
        System.out.println("MyThread2 State = " + myThread2.getState());

        myThread2.interrupt(); // TIMED_WAITING 상태일 때만 interrupt가 가능하다.
        System.out.println("MyThread1 State = " + myThread1.getState());
        System.out.println("MyThread2 State = " + myThread2.getState());
    }
}
