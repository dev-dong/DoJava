package chap15.EX04;

public class Quiz04 {
    public static void main(String[] args) {
        System.out.println("main 쓰레드 시작");
        Thread t = new Thread() {
            @Override
            public void run() {
                for (int i = 1; i <= 5; i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t.setDaemon(true);
        System.out.println("데몬쓰레드 시작");
        t.start();

        try {
            Thread.sleep(3500);
            System.out.println("main 쓰레드 종료");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
