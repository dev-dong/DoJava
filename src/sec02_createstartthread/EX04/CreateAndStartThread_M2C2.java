package sec02_createstartthread.EX04;

//#1. 방법2(M2). Runnable 인터페이스 상속하여 클래스 생성 case2: 3개의 쓰레드 생성
class SMIFileRunnable implements Runnable { // 미완성메서드 run() - 의무적으로 만들어야한다.
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

class VideoFileRunnable implements Runnable { // Runnable 클래스를 만든다.
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

public class CreateAndStartThread_M2C2 {
    public static void main(String[] args) {

        //SMIFileRunnable 객체 생성
        Runnable smiFileRunnable = new SMIFileRunnable();
//        SMIFileRunnable smiFileRunnable = new SMIFileRunnable();
        Thread thread1 = new Thread(smiFileRunnable);
        thread1.start();

        //VideoRunnable 객체 생성
        Runnable videoFileRunnable = new VideoFileRunnable();
        Thread thread2 = new Thread(videoFileRunnable);
        thread2.start();
    }
}
