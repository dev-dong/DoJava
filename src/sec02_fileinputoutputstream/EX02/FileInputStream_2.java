package sec02_fileinputoutputstream.EX02;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileInputStream_2 {
    public static void main(String[] args) throws IOException {
        // 입력파일 생성
        File inFile = new File("src/sec02_fileinputoutputstream/files/FileinputStream1.txt");

        //#1. 1-byte 단위 읽기 - 파일경로를 써줘야한다.
        InputStream is1 = new FileInputStream(inFile);

        int data;
        while ((data = is1.read()) != -1) {
            System.out.print((char) data);
        }
        System.out.println();
        System.out.println();

        //#2. n-byte 단위 읽기 (byte[]의 처음 위치에서 부터 읽은 데이터 저장)
        InputStream is2 = new FileInputStream(inFile);

        byte[] byteArray1 = new byte[9]; // 최대 9개씩 읽을수 있다.
        int count1;
        // count1에는 읽은 데이터 개수를 지정하고 실제 읽은 데이터는 byteArray1로 들어가게 된다.
        while ((count1 = is2.read(byteArray1)) != -1) { // byteArray1를 매개변수로 넘겨주게 되면 한번에 is2는 최대 9개씩 읽는다.
            for (int i = 0; i < count1; i++) {
                System.out.print((char) byteArray1[i]);
            }
            System.out.println(" : count1 = " + count1);
        }
        System.out.println();
        System.out.println();

        //#3. n-byte 단위 읽기(length 만큼 앞에서부터 읽어와서 byte[]의 offset 위치부터 넣어라.)
        InputStream is3 = new FileInputStream(inFile);
        byte[] byteArray2 = new byte[9]; // 최소 offset + length 보단 커야한다.

        int offset = 3;
        int length = 6;
        int count2 = is3.read(byteArray2, offset, length);

        // offset 만큼 띄워져서 나오게된다. offset은 배열의 기준이지 파일의 기준이 아니다.
        for (int i = 0; i < offset + count2; i++) {
            System.out.print((char) byteArray2[i]);
        }

        // InputStream 자원반납
        is1.close();
        is2.close();
        is3.close();

    }
}
