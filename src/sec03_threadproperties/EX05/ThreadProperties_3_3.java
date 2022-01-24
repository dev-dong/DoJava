package sec03_threadproperties.EX05;

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println(this.getName() + " : " + (this.isDaemon() ? "데몬쓰레드" : "일반쓰레드"));
        for (int i = 0; i < 6; i++) {
            System.out.println(this.getName() + " : " + i + "초");
            try {
                // 1초만 재웠다
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ThreadProperties_3_3 {
    public static void main(String[] args) {
        
        //#1. 일반쓰레드 - 메인 쓰레드가 종료 된 이후에도 계속 쓰레드가 수행된다.
        Thread thread1 = new MyThread();
        thread1.setDaemon(false); // 디폴트
        thread1.setName("thread1");
        thread1.start();

        //#2. 데몬쓰레드
        Thread thread2 = new MyThread();
        thread2.setDaemon(true); // 데몬
        thread2.setName("thread2");
        thread2.start();
        
        //#3. 3초후 main Thread 종료
        try {
            Thread.sleep(3000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("main Thread 종료");
    }
}
