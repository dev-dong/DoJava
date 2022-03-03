package sec01_fileandcharset.EX06;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public class ByteArrayToFromString {
    public static void main(String[] args) throws UnsupportedEncodingException {

        //#1 String getBytes() String --> byte[] 분해
        byte[] array1 = "안녕".getBytes(); // 기본적으로 설정되어져있는 캐릭터셋을 사용하겠다.
        byte[] array2 = "땡큐".getBytes(Charset.defaultCharset()); // array1과 array2는 기본으로 설정되어있는 캐릭터셋을 사용하겠다.
        byte[] array3 = "베리".getBytes(Charset.forName("MS949")); // 베리를 byte 단위로 분해해라
        byte[] array4 = "감사".getBytes("UTF-8"); // 문자열을 그대로 집어넣는것도 가능하다. 단 예외처리를 해줘야한다.(UTF-8)가 존재하지 않으면 어떻게 할래??

        System.out.println(array1.length); // 6 -> 한글은 3byte(UTF-8) 영문은 1byte
        System.out.println(array2.length); // 6
        System.out.println(array3.length); // 4 -> 한글은 2byte(MS949)
        System.out.println(array4.length); // 6
        
        //#2 new String(.)을 이용 : byte[] --> String 조합(문자열 생성)
        String str1 = new String(array1); // default 캐릭터셋이 적용
        String str2 = new String(array2, Charset.defaultCharset());
        String str3 = new String(array3, Charset.forName("MS949")); // 분해할 때 사용했던 Charset을 동일하게 맞춰줘야한다. MS949로 분해했으면 조합도 MS949로 조합해야한다.
        String str4 = new String(array4, "UTF-8");

        String str5= new String(array3, "UTF-8");
        String str6= new String(array4, "MS949");

        System.out.println(str1); // defaultCharset -> defaultCharset
        System.out.println(str2); // defaultCharset -> defaultCharset
        System.out.println(str3); // MS949 -> MS949
        System.out.println(str4); // UTF-8 -> UTF-8

        // 분해할때 사용한 Charset을 조합할때도 동일한 Charset을 사용해야한다.
        System.out.println(str5);
        System.out.println(str6);
    }
}
