package neal.java.cocurrent;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ReferenceQueueTest {
    private static boolean isRun = true;

    public static void main(String[] args) throws Exception {
        Object abc = new Object();
        System.out.println(abc.getClass() + "@" + abc.hashCode());
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        new Thread(() -> {
            while (isRun) {
                Object obj = referenceQueue.poll();
                // System.out.println("ref queue");
                if (obj != null) {
                    try {
                        Field ref = Reference.class
                                .getDeclaredField("referent");
                        ref.setAccessible(true);
                        Object result = ref.get(obj);
                        System.out.println("gc will collect："
                                + result.getClass() + "@"
                                + result.hashCode() + "\t"
                                + result);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        ).start();
        List<Object> list = new ArrayList<>();
        list.add(abc);
        PhantomReference<Object> abcPhantomReference = new PhantomReference<>(abc,
                referenceQueue);
        Thread.sleep(3000);
        list.remove(0);
        list = null;
        abc = null;
        System.out.println("start gc ...");
        System.gc();
        Thread.sleep(3000);
        isRun=false;
    }
}
