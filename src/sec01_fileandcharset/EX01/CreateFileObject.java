package sec01_fileandcharset.EX01;

import java.io.File;
import java.io.IOException;

public class CreateFileObject {
    public static void main(String[] args) throws IOException { // JVM에게 예외처리하겠다고 보내겠다. - createNewFile을 할 경우 예외가 발생

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

        //#2. 파일구분자
        File newFile2 = new File("E:\\temp\\newFile.txt"); // Windows
        File newFile3 = new File("E:/temp/newFile.txt"); // Mac
        File newFile4 = new File("E:" + File.separator + "temp" + File.separator + "newFile.txt"); // OS에 맞게 바꿔서 돌아간다
        System.out.println(newFile2.exists());
        System.out.println(newFile3.exists());
        System.out.println(newFile4.exists());

        //#3-1. 절대경로
        File newFile5 = new File("E:/abc/newFile.txt");
        File newFile6 = new File("E:/abc/bcd/newFile.txt");
        System.out.println(newFile5.getAbsolutePath());
        System.out.println(newFile6.getAbsolutePath());

        //#3-2. 상대경로
        //현재위치
        System.out.println(System.getProperty("user.dir")); // 현재작업폴더 위치
        File newFile7 = new File("../../newFile1.txt"); // 객체 생성시 실제파일이 있는지 상관이 없다. 만약 파일이 없다면 이 파일을 사용할때 문제가 된다.
        File newFile8 = new File("../../bcd/newFile2.txt");
    }
}
