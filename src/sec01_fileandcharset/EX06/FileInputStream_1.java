package sec01_fileandcharset.EX06;

import java.io.*;

public class FileInputStream_1 {
    public static void main(String[] args) throws IOException {
        // 입력파일 생성 - 입력파일의 경로 넣기
        File inFile = new File("src/sec02_fileinputoutputstream/files/FileinputStream1.txt");

        // InputStream 객체 생성 - InputStream는 추상클래스니까 객체를 못만든다. 하위클래스에서 구현되어있는 FileInputStream으로 구현
        InputStream is = new FileInputStream(inFile); // 만약에 File이 없으면 어떻게 할래 -> 에러처리 해줘야 한다.

        // byte단위로 읽은것들이 int에 담아서 return
        int data;
        while ((data = is.read()) != -1) { // 읽을 때 예외 발생할수 있으니 예외처리해줘야한다.
            System.out.println("읽은 데이터: " + (char)data + "남은 바이트수: " + is.available());
        }

        // InputStream 자원반납
        is.close();
    }
}
