package sec02_exceptionhandlingsyntax.EX06;

class A implements AutoCloseable {
    String resource;

    A(String resource) {
        this.resource = resource;
    }

    void abc() throws Exception {

    }

    @Override
    // AutoCloseable 상속한 모든 클래스는 close()가 있다.
    public void close() throws Exception {
        if(resource != null) {
            resource = null;
            System.out.println("리소스가 해제되었습니다.");
        }
    }
}

public class TryWithResource_2 {
    public static void main(String[] args) {

        // 리소스를 사용하고 finally에서 리소스 수동해제하기
        A a1 = null;
        try {
            a1 = new A("특정파일");
            a1.abc();
        }catch(Exception e) {
            System.out.println("예외처리");
        }finally {
            //리소스 수동 해제
            if(a1.resource != null) {
                try {
                    a1.close(); // close()를 호출하기 위해서는 A 클래스를 찾아가는데 A 클래스안에 close() 메서스가 반드시 있어야한다. close() 메서드를 생성하기 위해 반드시 AutoCloseable 인터페이스를 상속해야한다.
                } catch (Exception e) {
                }
            }
        }
        
        // 자동 리소스 해제 - 엄청 간결해진다.
        // try() - ()안에 들어가기 위해서는 close() 메서드를 가져야한다. 즉 AutoCloseable을 상속해야한다.
        // AutoCloseable을 상송한 클래스만 try() 안에 들어갈수 있다.
        try(A a2 = new A("특정파일")) {
            a2.abc();
        }catch(Exception e) {
            System.out.println("예외처리");
        }
    }
}
