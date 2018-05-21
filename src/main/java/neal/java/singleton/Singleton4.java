package neal.java.singleton;


//线程安全饿汉
public class Singleton4 {

    private volatile static Singleton4 instance;

    public static Singleton4 getInstance(){
        if(instance == null){
            synchronized(Singleton4.class) {
                if(instance == null) {
                    instance = new Singleton4();
                }
            }
        }
        return instance;
    }

    private Singleton4() {
        System.out.println("init");
    }

    public static void main(String[] args) throws Exception {
        System.out.println("get");
        Singleton4 singleton4 = Singleton4.getInstance();
        singleton4 = Singleton4.getInstance();
    }
}
