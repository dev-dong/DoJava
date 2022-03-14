package sec02_fileinputoutputstream.EX03;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

public class FileInputStream_3 {
    public static void main(String[] args) throws IOException {

        // 입력파일 생성
        File inFile = new File("src/sec02_fileinputoutputstream/files/FileInputStream2.txt");

        //#2. n-byte 단위 읽기 (byte[]의 처음 위치에서 부터 읽은 데이터 저장)
        InputStream is2 = new FileInputStream(inFile); // 한글을 분해해서 가지고 온다.

        byte[] byteArray1 = new byte[9]; // 최대 9개씩 읽을수 있다.
        int count1;
        // count1에는 읽은 데이터 개수를 지정하고 실제 읽은 데이터는 byteArray1로 들어가게 된다.
        while ((count1 = is2.read(byteArray1)) != -1) { // byteArray1를 매개변수로 넘겨주게 되면 한번에 is2는 최대 9개씩 읽는다.
            // 한글을 출력하기 위해서는 조합을 해야한다. - byteArray1의 0번째부터 시작해서 count1번째 해당하는 위치에 대한 내용들을 조립을 다시해라 정해진 문자셋 기준으로
            String str = new String(byteArray1, 0, count1, Charset.forName("UTF-8"));
            System.out.print(str);
            System.out.println(" : count = " + count1);
        }
        System.out.println();
        System.out.println();

        //#3. n-byte 단위 읽기(length 만큼 앞에서부터 읽어와서 byte[]의 offset 위치부터 넣어라.)
        InputStream is3 = new FileInputStream(inFile);
        byte[] byteArray2 = new byte[9]; // 최소 offset + length 보단 커야한다.

        int offset = 3;
        int length = 6;
        int count2 = is3.read(byteArray2, offset, length);

        // 0부터 시작해서 9까지 데이터를 출력한다. 앞의 3칸은 offset이므로 비워져있다.
//        String str = new String(byteArray2, 0, offset+count2, Charset.defaultCharset());

        // offset부터 시작하게 되면 count2까지 문자셋을 조합하게 되면 안녕만 조합이 된다.
        String str = new String(byteArray2, offset, count2, Charset.defaultCharset());
        System.out.println(str);

        // InputStream 자원반납
        is2.close();
        is3.close();
    }
}
