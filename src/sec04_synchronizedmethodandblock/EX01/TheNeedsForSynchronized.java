package sec04_synchronizedmethodandblock.EX01;

//# 공유할 때 동기화 발생
class MyData {
    int data = 3;

    public void plusData() {
        int mydata = this.data; // 데이터를 가져오기
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 2초 뒤에 데이터가 더해진다.
        this.data = mydata + 1;
    }
}

//# 공유객체를 사용하는 쓰레드
class PlusThread extends Thread {
    // 공유필드
    MyData myData;
    public PlusThread(MyData myData) {
        this.myData = myData;
    }

    @Override
    public void run() {
        myData.plusData();
        System.out.println(this.getName() + "실행결과 : " + myData.data);
    }
}

public class TheNeedsForSynchronized {
    public static void main(String[] args) {
        //#공유객체 생성
        MyData myData = new MyData();
//        System.out.println("myData : " + myData.data);

        //#1. plusThread 1
        Thread plusThread1 = new PlusThread(myData);
        plusThread1.setName("plusThread1");
        plusThread1.start();

        // 극단적인 결과를 위해서
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //#1. plusThread 2
        Thread plusThread2 = new PlusThread(myData);
        plusThread2.setName("plusThread1");
        plusThread2.start();
    }
}
