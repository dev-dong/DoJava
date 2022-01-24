package sec05_threadstates.EX07;

// 공유객체
class DataBox {
    boolean isEmpty = true;
    int data;

    synchronized void inputData(int data) {
        if (!isEmpty) {
            try {
                this.wait();
            } catch (InterruptedException e) {
            }
        }
        this.data = data;
        isEmpty = false;
        System.out.println("입력데이터 : " + this.data);
        this.notify();
    }

    synchronized void outputData() {
        if (isEmpty) {
            try {
                this.wait();
            } catch (InterruptedException e) {
            }
        }
        isEmpty = true;
        System.out.println("출력데이터 : " + this.data);
        notify();
    }
}

public class Waiting_WaitNotify_2 {
    public static void main(String[] args) {
        DataBox dataBox = new DataBox();
        Thread t1 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 9; i++) {
                    dataBox.inputData(i);
                }
            }
        };
        t1.start();

        Thread t2 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 9; i++) {
                    dataBox.outputData();
                }
            }
        };
        t2.start();
    }
}
