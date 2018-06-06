package neal.java.singleton;


/**
 * 枚举实现单例
 */
public enum Singleton6 {
    INSTANCE;

    private Singleton6() {
        System.out.println("init");
    }
}
