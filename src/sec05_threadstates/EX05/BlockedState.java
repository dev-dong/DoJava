package sec05_threadstates.EX05;

class MyBlockTest {
    //#1. 공유객체
    MyClass mc = new MyClass();

    //#2. 세개의 쓰레드 객체 생성
    Thread t1 = new Thread("thread1") { // ()안에 쓰레드 이름을 넣게되면 setName()이 자동호출된다.
        @Override
        public void run() {
            mc.syncMethod();
        }
    };

    Thread t2 = new Thread("thread2") { // ()안에 쓰레드 이름을 넣게되면 setName()이 자동호출된다.
        @Override
        public void run() {
            mc.syncMethod();
        }
    };

    Thread t3 = new Thread("thread3") { // ()안에 쓰레드 이름을 넣게되면 setName()이 자동호출된다.
        @Override
        public void run() {
            mc.syncMethod();
        }
    };

    void startAll() {
        t1.start();
        t2.start();
        t3.start();
    }

    class MyClass {
        synchronized void syncMethod() {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } // 쓰레드 시작 준비시간
            
            System.out.println("====" + Thread.currentThread().getName() + "====");
            System.out.println("thread1 -> " + t1.getState());
            System.out.println("thread2 -> " + t2.getState());
            System.out.println("thread3 -> " + t3.getState());

            for (long i = 0; i < 100000000L; i++) {
            } // 시간지연
        }
    }
}

public class BlockedState {
    public static void main(String[] args) {
        MyBlockTest mbt = new MyBlockTest();
        mbt.startAll();
    }
}
