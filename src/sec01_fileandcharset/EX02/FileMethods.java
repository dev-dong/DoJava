package sec01_fileandcharset.EX02;

import java.io.File;

public class FileMethods {
    public static void main(String[] args) {

        //#0. E 드라이브내에 temp 폴더 생성(없는 경우)
        File tempDir = new File("E:/temp");
        if (!tempDir.exists())
            tempDir.mkdir();

        //#1. 파일객체 생성
        File file = new File("C:/Windows");

        //#2. 파일메서드
        System.out.println("절대경로: " + file.getAbsolutePath());
        System.out.println("폴더(?): " + file.isDirectory());
        System.out.println("파일(?): " + file.isFile());
        System.out.println("파일(?): " + file.getName()); // 파일객체가 최종적으로 가리키고 있는것 즉 제일 마지막에 있는것을 가지고온다.
        System.out.println("부모폴더(?): " + file.getParent()); // 내가 최종적으로 가리키고 있는것 빼고 나머지 위에 있는 모든것.

        File newFile1 = new File("E:/temp/abc");
        System.out.println(newFile1.mkdir()); // 이미 만들어져있는 경우는 false가 나온다.
        File newFile2 = new File("E:/temp/bcd/abc");
//        System.out.println(newFile1.mkdir()); // false가 나온다. make directory는 한단계의 폴더만 만들수있다.
        System.out.println(newFile2.mkdirs()); // 모든폴더를 작성해준다. bcd와 abc를 한방에 만들어준다.

        File[] fnames = file.listFiles(); // file이 가리키고 있는 Windows 폴더안에 있는 모든놈들을 파일별로 가지고 와서 배열로 저장
        for (File fname : fnames) {
            System.out.println((fname.isDirectory() ? "폴더: " : "파일: ") + fname.getName());
        }


    }
}
