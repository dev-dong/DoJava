package chap15.EX02;

class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i + "초");
        }
    }
}

public class Quiz02 {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new MyRunnable());
        thread1.start(); // 스레드 시작
    }
}
