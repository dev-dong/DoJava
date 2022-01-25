package sec01_theneedforgeneric.EX05;

class Apple {
}

class Pencil {
}

class Goods<T> {
    private T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}

public class Solution2_UsingObject {
    public static void main(String[] args) {
        Goods<Apple> goods1 = new Goods<>();
        goods1.setT(new Apple());
        Apple apple = goods1.getT(); // 다운캐스팅 필요 없음

        Goods<Pencil> goods2 = new Goods<>();
        goods2.setT(new Pencil());
        Pencil pencil = goods2.getT();

        //#3. 잘못된 캐스팅( 약한 타입체크)
        Goods<Apple> goods3 = new Goods<>();
        goods3.setT(new Apple());
//        Pencil pencil1 = goods3.getT(); // 강한타입체크
    }
}
