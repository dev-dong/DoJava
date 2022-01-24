package sec02_createstartthread.EX03;

//#1. 방법2(M2). Runnable 인터페이스 상속하여 클래스 생성 case1: 2개의 쓰레드 생성
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

public class CreateAndStartThread_M2C1 {
    public static void main(String[] args) {

        // SMIRunnable 객체 생성, 쓰레드 객체 생성X
        Runnable smiFileRunnable = new SMIFileRunnable();
//        smiFileRunnable.start() // 오류, Runnable객체에는 start() 메서드가 없다.

        /*
         * Thread 기본생성자를 호출하게 되면 아무짓도 않나는 run() 메서드가 돌아간다.
         * smiFileRunnable을 Thread안에 넣어주면 smiFileRunnable의 run()이 오버라이딩이 돼서 돌아간다.
         * */
        Thread thread = new Thread(smiFileRunnable);
        thread.start();

        // main쓰레드는 비디오프레임을 실행시킨다.
        //#.1 비디오프레임 1 ~ 5
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
