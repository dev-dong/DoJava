package sec01_fileandcharset.EX01;

import java.io.File;
import java.io.IOException;

public class CreateFileObject {
    public static void main(String[] args) throws IOException { // JVM에게 예외처리하겠다고 보내겠다.

        //#1-1. E 드라이브내에 temp 폴더 생성(없는 경우)
        File tempDir = new File("E:/temp");
        if (!tempDir.exists())
            tempDir.mkdir();
        
        System.out.println(tempDir.exists());
        
        //#1-2. 파일 객체 생성 (실제파일 생성)
        File newFile = new File("E:/temp/newFile.txt");
        if (!newFile.exists()) {
                newFile.createNewFile(); // 파일 만들고자 할 때 IOException이 발생한다. 예외처리 필수
        }

        System.out.println(newFile.exists());
    }
}
