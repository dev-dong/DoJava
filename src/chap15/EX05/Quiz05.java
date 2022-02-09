package chap15.EX05;

class MyData {
    int data;

    synchronized void modifyData() {
        data++;
    }
}

class MyThread extends Thread {
    MyData myData;

    public MyThread(MyData myData) {
        this.myData = myData;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            myData.modifyData();
        }
        System.out.println(myData.data);
    }
}

public class Quiz05 {
    public static void main(String[] args) {
        MyData md = new MyData();
        MyThread mt1 = new MyThread(md);
        mt1.start();
        // 쓰레드 준비 과정 + 동기화 준비 과정을 위한 짧은 시간
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        MyThread mt2 = new MyThread(md);
        mt2.start();
    }
}
