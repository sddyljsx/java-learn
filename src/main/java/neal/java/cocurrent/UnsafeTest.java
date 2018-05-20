package neal.java.cocurrent;

import java.util.ArrayList;
import java.util.List;

public class UnsafeTest {
    int a = 0;

    public void test() {
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {

            Thread thread = new Thread(() -> {
                try {
                    Thread.sleep(10);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                a++;
                System.out.println(a);
            });
            threads.add(thread);
        }

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(1000);

        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("----------------");
        System.out.println(a);


    }
}
