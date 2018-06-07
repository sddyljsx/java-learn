package neal.java.cocurrent;

import java.util.concurrent.*;

public class ThreadPoolTest {

    static class Task implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            System.out.println("子线程在进行计算");
            Thread.sleep(3000);
            int sum = 0;
            for (int i = 0; i < 100; i++)
                sum += i;
            return sum;
        }
    }

    public static void main(String[] args) throws Exception{

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Task task = new Task();
        Future<Integer> futureTask = executorService.submit(task);
        System.out.println(futureTask.get());
        //executorService.shutdown();

        ExecutorCompletionService<Integer> executorCompletionService = new ExecutorCompletionService<Integer>(executorService);
        executorCompletionService.submit(task);
        executorCompletionService.submit(task);

        System.out.println(executorCompletionService.take().get());
        System.out.println(executorCompletionService.take().get());



    }
}
