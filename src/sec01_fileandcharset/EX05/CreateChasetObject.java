package sec01_fileandcharset.EX05;

import java.nio.charset.Charset;

public class CreateChasetObject {
    public static void main(String[] args) {

        Charset cs1 = Charset.defaultCharset(); // 현재 설정되어져있는 default 캐릭터셋
        Charset cs2 = Charset.forName("MS949"); // MS949 지정
        Charset cs3 = Charset.forName("UTF-8"); // MS949 지정

        System.out.println(cs1); // UTF-8
        System.out.println(cs2);
        System.out.println(cs3);

        System.out.println(Charset.isSupported("MS949")); // MS949를 지원하나요?? -> True
        System.out.println(Charset.isSupported("UTF-8")); // UTF-8을 지원하나요?? -> True
    }
}
