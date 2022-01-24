package sec02_createstartthread.EX05;

class SMIFileRunnable implements  Runnable {
    @Override
    public void run() {

    }
}

public class CreateAndStartThread_M2C3 {
    public static void main(String[] args) {

        // Thread 객체 생성 - 자바API에서 제공하는 Thread객체이다.
        // run()이라는걸 정의하기 위해서 Runnable 객체를 만들어서 써주는데 이걸 안에서 써서 만들겠다.
        // Thread 객체 생성 자막번호
        Thread thread1 = new Thread(new SMIFileRunnable(){
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
        });

        // Thread 객체 생성 비디오 번호
        Thread thread2 = new Thread(new Runnable() {
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
        });
        
        // Thread 실행
        thread1.start();
        thread2.start();
    }
}
