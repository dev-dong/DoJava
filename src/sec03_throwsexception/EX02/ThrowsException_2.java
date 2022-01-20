package sec03_throwsexception.EX02;

public class ThrowsException_2 {
    public static void main(String[] args) throws ClassNotFoundException { // JVM이 예외처리 하는 상황이면 프로그램 강제 종료시키고 왜 종료시키는지 메시지 띄우고 종료
        Class cls = Class.forName("java.lang.Object2");
    }
}
