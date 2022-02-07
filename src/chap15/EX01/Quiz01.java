package chap15.EX01;

class MyThread extends Thread {
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

public class Quiz01 {
    public static void main(String[] args) {
        MyThread thread1 = new MyThread();
        thread1.start();
    }
}
