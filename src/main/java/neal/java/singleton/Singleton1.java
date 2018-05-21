package neal.java.singleton;


// 饿汉
public class Singleton1 {
    private static Singleton1 instance = new Singleton1();

    public static Singleton1 getInstance() {
        return instance;
    }

    private Singleton1() {
        System.out.println("init");
    }

    public static void main(String[] args) throws Exception {
        System.out.println("get");
        Singleton1 singleton1 = Singleton1.getInstance();
        singleton1 = Singleton1.getInstance();
    }
}
