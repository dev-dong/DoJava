package sec04_synchronizedmethodandblock.EX04;

class MyData {
    synchronized void abc() { // 동기화 메서드는 항상 this 키를 사용한다.
        for (int i = 0; i < 3; i++) {
            System.out.println(i + "sec");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    synchronized void bcd() { // 동기화 메서드는 항상 this 키를 사용한다.
        for (int i = 0; i < 3; i++) {
            System.out.println(i + "초");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    void cde() {
        synchronized (this) {
            for (int i = 0; i < 3; i++) {
                System.out.println(i + "번째");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

public class KeyObject_1 {
    public static void main(String[] args) {
        //# 공유객체
        MyData myData = new MyData();

        //# 세개의 쓰레드가 각각의 메서드 호출
        // 익명이너클래스
        new Thread() {
            @Override
            public void run() {
                myData.abc();
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                myData.bcd();
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                myData.cde();
            }
        }.start();

    }
}
