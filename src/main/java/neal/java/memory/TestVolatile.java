package neal.java.memory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestVolatile {

    public static class test {

        static volatile int a = 0;

        static void test() {
            ExecutorService executor = Executors.newFixedThreadPool(1000);
            for (int i = 0; i < 1000; i++) {
                executor.execute(new Runnable() {
                    public void run() {
                        if (a <= 1000) {
                            a++;
                        }
                    }
                });
            }
            System.out.println(a);

        }


    }

    public static void main(String[] args) {
        test.test();

    }
}




