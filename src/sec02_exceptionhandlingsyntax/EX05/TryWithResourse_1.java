package sec02_exceptionhandlingsyntax.EX05;

import java.io.IOException;
import java.io.InputStreamReader;

public class TryWithResourse_1 {
    public static void main(String[] args) {
        
        // 참고. System.in 리소스를 해제하면 더이상 콘솔입력이 불가
        //# 자동리소스 해제
        // try ~ catch 문이 종료될 때 모든 리소스를 자동으로 해제해준다.
        // try() - ()안에 만든 모든 객체는 자동으로 해제해주겠다. try ~ catch가 끝나면 사라지게 해주겠다.
        try(InputStreamReader isr1 = new InputStreamReader(System.in);) {
            char input = (char)isr1.read();
            System.out.println("입력글자 = " + input);
        }catch(IOException e) {
            e.printStackTrace();
        }

        //#2. 수동리소스 해제
        // 여기서는 오류가 뜬다. Stream closed 발생 = 왜? System.in이 자동반납 돼서 객체가 사라졌기 때문에 값을 읽을 수가 없다.
        InputStreamReader isr2 = null;
        try {
            isr2 = new InputStreamReader(System.in);
            char input = (char)isr2.read();
            System.out.println("입력글자 = " + input);
        }catch(IOException e) {
            e.printStackTrace();
        }finally {
            //리소스 해제 구문
            if(isr2 != null) {
                try {
                    isr2.close(); // 리소스 해제
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
