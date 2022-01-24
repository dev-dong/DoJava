package sec02_createstartthread.EX02;

//#1. 방법1(M1). Thread 클래스 상속하여 클래스 생성 case2: 3개의 쓰레드 생성
class SMIFileThread extends Thread { // Thread를 상속하면 이미 Thread 클래스가 만들어짐 run()을 정의하지 않으면 아무것도 하지 않는 run()이 돌아간다.
    @Override
    public void run() {
        //#2. 자막 번호 하나~다섯
        String[] strArray = {"하나", "둘", "셋", "넷", "다섯"};
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
        }

        //#4. 자막 번호 출력
        for (int i = 0; i < strArray.length; i++) {
            System.out.println(" - (자막번호) " + strArray[i]);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class VideoFileThread extends Thread {
    @Override
    public void run() {
        int[] intArray = {1, 2, 3, 4, 5};

        //#3. 비디오프레임 출력
        for (int i = 0; i < intArray.length; i++) {
            System.out.print("(비디오프레임) " + intArray[i]);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class CreateAndStartThread_M1C2 {
    public static void main(String[] args) {
        // SMIFileThread 객체 생성 및 시작
        Thread smiFileThread = new SMIFileThread();
        smiFileThread.start(); // start가 되어져야 run() 메서드가 실행이 된다. start 되는 시점에서는 run()이 동작한다.

        // VideoFileThread 객체 생성 및 시작
        Thread videoFileThread = new VideoFileThread();
        videoFileThread.start(); // start가 되어져야 run() 메서드가 실행이 된다. start 되는 시점에서는 run()이 동작한다.

        // 쓰레드를 별도로 2개를 각가 만들고 main는 쓰레드 start만 해준다.
        // main은 쓰레드 start()만 하고 main은 종료가 된다.
        // main은 종료가 되도 쓰레드는 자기일이 끝날 때까지 종료하지 않는다.

    }

}
