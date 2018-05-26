package neal.java.cocurrent.Test;

import java.util.concurrent.locks.ReentrantLock;

public class InterruptTest {

    ReentrantLock reentrantLock = new ReentrantLock();

    public void getLock() {
        System.out.println("begin");
        reentrantLock.lock();
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.interrupted());
        System.out.println(Thread.currentThread().isInterrupted());
        Thread.currentThread().interrupt();
        System.out.println(Thread.interrupted());
        System.out.println(Thread.currentThread().isInterrupted());

        InterruptTest interruptTest = new InterruptTest();
        Thread thread1 = new Thread(
                interruptTest::getLock
        );
        thread1.start();
        Thread thread2 = new Thread(
                interruptTest::getLock
        );
        thread2.start();
//        System.out.println(thread2.isInterrupted());
       thread2.interrupt();
//        System.out.println(thread2.isInterrupted());
        thread1.join();
        thread2.join();
    }
}
