package sec05_innerinterface.EX02;

class Button {
    onClickListener ocl;

    // 외부에서 객체를 받아서 사용한다. 내부에서 객체를 초기화하는 영역을 두지 않고 외부에서 받겠다.
    // 외부에서 onClickListener 객체를 받고 ocl를 초기화 한 후(onClick() 메서드도 초기화가 될 것이다.(완성))
    // 이해가 안될때는 천천히 로직을 타면서 이해하면 된다.
    void setOnClickListener(onClickListener ocl) {
        this.ocl = ocl;
    }

    interface onClickListener {
        public abstract void onClick();
    }

    void onClick() {
        ocl.onClick();
    }
}

public class ButtonAPIExample {
    public static void main(String[] args) {

        //#1. 개발자 1. 클릭했을때 음악재생
        Button btn1 = new Button();
        // Button 밑에 있는 onClickListener이다.
        btn1.setOnClickListener(new Button.onClickListener() {
            @Override
            public void onClick() {
                System.out.println("개발자1 : 음악재생");
            }
        });
        btn1.onClick(); // 개발자1 : 음악재생

        //#2. 개발자 2. 네이버 접속
        Button btn2 = new Button();
        btn2.setOnClickListener(new Button.onClickListener() {
            @Override
            public void onClick() {
                System.out.println("개발자2 : 네이버 접속");
            }
        });
        btn2.onClick();
    }
}
