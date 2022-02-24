package sec01_fileandcharset.EX04;

import java.io.UnsupportedEncodingException;

public class UTF16vsUTF8 {
    public static void main(String[] args) throws UnsupportedEncodingException {

        //#UTF-16 vs. UTF-8
        byte[] b1 = "abc".getBytes("UTF-16"); // 영문자, 한글은 2byte
        byte[] b2 = "abc".getBytes("UTF-8"); // 영문자는 1byte, 한글은 3byte

        System.out.println(b1.length); // 8 -> 고정적으로 BOM코드가 붙기 때문에 6byte가 아닌 8byte가 된다. FF FF + 6byte = 8
        System.out.println(b2.length); // 3

        for(byte b : b1) {
            System.out.printf("%02X ", b);
        }
        System.out.println();

        for(byte b : b2) {
            System.out.printf("%02X ", b);
        }
        System.out.println();

        System.out.println(new String(b1, "UTF-16"));
        System.out.println(new String(b2, "UTF-8"));

        byte[] b3 = "가나다".getBytes("UTF-16"); // 영문자, 한글은 2byte
        byte[] b4 = "가나다".getBytes("UTF-8"); // 영문자는 1byte, 한글은 3byte

        System.out.println(b3.length); // 8 -> 고정적으로 BOM코드가 붙기 때문에 6byte가 아닌 8byte가 된다. FF FF + 6byte = 8
        System.out.println(b4.length); // 3

        for(byte b : b3) {
            System.out.printf("%02X ", b);
        }
        System.out.println();

        for(byte b : b4) {
            System.out.printf("%02X ", b);
        }
        System.out.println();

        System.out.println(new String(b3, "UTF-16"));
        System.out.println(new String(b4, "UTF-8"));
    }
}
