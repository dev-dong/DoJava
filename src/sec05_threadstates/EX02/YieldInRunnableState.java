package sec05_threadstates.EX02;

class MyThread extends Thread {
    boolean yieldFlag;

    @Override
    public void run() {
        while(true) {
            if(yieldFlag) {
                Thread.yield(); // CPU를 양보하겠다.
            } else {
                System.out.println(this.getName() + " 실행");
                for (long i = 0; i < 1000000000L; i++) {}  // 시간지연
            }
        }
    }
}

public class YieldInRunnableState {
    public static void main(String[] args) {
        MyThread thread1 = new MyThread();
        thread1.setName("thread1");
        thread1.yieldFlag=false;
        thread1.setDaemon(true); // main 쓰레드 죽으면 같이 죽자.
        thread1.start();

        MyThread thread2 = new MyThread();
        thread2.setName("thread2");
        thread2.yieldFlag=true;
        thread2.setDaemon(true); // main 쓰레드 죽으면 같이 죽자.
        thread2.start();

        //#1. 6초 지연(1초마다 한번씩 양보)
        for(int i = 0; i < 6; i++){
            try {
                Thread.sleep(1000);
                // 반전
                thread1.yieldFlag = !thread1.yieldFlag; 
                thread2.yieldFlag = !thread2.yieldFlag;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
