package neal.java.cocurrent;

import java.util.concurrent.locks.ReentrantLock;

public class Lock {

    public static void main(String[] args) throws Exception {
        ReentrantLock reentrantLock = new ReentrantLock();
        System.out.println("test");
        reentrantLock.lock();
        System.out.println("test1");
        reentrantLock.lock();
        System.out.println("test2");
    }


}
