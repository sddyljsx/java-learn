package neal.java.singleton;


//线程安全饿汉
public class Singleton5 {

    private static class InstanceHolder{
        private static Singleton5 instance = new Singleton5();
    }

    private Singleton5(){
        System.out.println("init");
    }

    public static Singleton5 getInstance(){
        return InstanceHolder.instance;
    }
    public static void main(String[] args) throws Exception {
        System.out.println("get");
        Singleton5 singleton5 = Singleton5.getInstance();
        singleton5 = Singleton5.getInstance();
    }

}
