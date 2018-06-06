package neal.java.cocurrent;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicTest {

    public static void main(String[] args) {

        AtomicInteger atomicInteger = new AtomicInteger(0);
        System.out.println(atomicInteger.get());
        System.out.println(atomicInteger.compareAndSet(0,1));
        System.out.println(atomicInteger.compareAndSet(0,2));
        System.out.println(atomicInteger.get());
        System.out.println(atomicInteger.addAndGet(1));

    }


}
