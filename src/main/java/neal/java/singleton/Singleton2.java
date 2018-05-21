package neal.java.singleton;

//饿汉
public class Singleton2 {
    private static Singleton2 instance;

    public static Singleton2 getInstance() {
        if(instance == null){
            instance = new Singleton2();
        }
        return instance;
    }

    private Singleton2() {
        System.out.println("init");
    }

    public static void main(String[] args) throws Exception {
        System.out.println("get");
        Singleton2 singleton2 = Singleton2.getInstance();
        singleton2 = Singleton2.getInstance();
    }
}
