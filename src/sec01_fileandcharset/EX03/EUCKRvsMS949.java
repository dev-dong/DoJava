package sec01_fileandcharset.EX03;

import java.io.UnsupportedEncodingException;

public class EUCKRvsMS949 {
    public static void main(String[] args) throws UnsupportedEncodingException {

        //#EUC-KR vs MS949
        byte[] b1 = "a".getBytes("EUC-KR"); // 문자열 --> byte[]
        byte[] b2 = "a".getBytes("MS949"); // 문자열 --> byte[]

        System.out.println(b1.length);
        System.out.println(b2.length);

        System.out.println(new String(b1,"EUC-KR")); // byte[] --> 문자열, 분해했던 사용했던 문자셋으로 조합을 해줘야한다.
        System.out.println(new String(b2,"MS949")); // byte[] --> 문자열, 분해했던 사용했던 문자셋으로 조합을 해줘야한다.

        // 예외 처리해줘야한다. 지원하지 않는 문자셋이 있을수도 있기때문에
//        try {
//            byte[] b2 = "a".getBytes("MS949");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }

        byte[] b3 = "가".getBytes("EUC-KR");
        byte[] b4 = "가".getBytes("MS949");

        System.out.println(b3.length); // 2
        System.out.println(b4.length); // 2

        System.out.println(new String(b3, "EUC-KR"));
        System.out.println(new String(b4, "MS949"));

        byte[] b5 = "봵".getBytes("EUC-KR"); // 맞춤법이 맞는 한글로만 구성되어있다.
        byte[] b6 = "봵".getBytes("MS949"); // 모든 조합 가능한 한글들을 다 코드화해서 가지고 있다.

        System.out.println(b5.length); // 1 ?
        System.out.println(b6.length); // 2

        System.out.println(new String(b5, "EUC-KR"));
        System.out.println(new String(b6, "MS949"));

    }
}
