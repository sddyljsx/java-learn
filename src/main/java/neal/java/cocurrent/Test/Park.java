package neal.java.cocurrent.Test;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.locks.LockSupport;

public class Park {

    public static void main(String[] args) throws Exception {
        System.out.println("test-0");
        Thread thread = Thread.currentThread();
        Timer timer = new Timer();//实例化Timer类
        timer.schedule(new TimerTask() {
            public void run() {
                System.out.println("run");
                LockSupport.unpark(thread);
                this.cancel();
            }
        }, 5000);


        LockSupport.park();

        System.out.println("test-1");
    }
}
