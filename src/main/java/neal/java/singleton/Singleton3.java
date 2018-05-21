package neal.java.singleton;


//线程安全饿汉
public class Singleton3 {

    private static Singleton3 instance;

    public synchronized static Singleton3 getInstance(){
        if(instance == null){
            instance = new Singleton3();
        }
        return instance;
    }

    private Singleton3() {
        System.out.println("init");
    }

    public static void main(String[] args) throws Exception {
        System.out.println("get");
        Singleton3 singleton3 = Singleton3.getInstance();
        singleton3 = Singleton3.getInstance();
    }
}
