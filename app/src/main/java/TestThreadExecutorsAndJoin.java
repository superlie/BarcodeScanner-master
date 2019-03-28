import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Executor;
public class TestThreadExecutorsAndJoin {

    static Thread t1 = new Thread(new Runnable() {
        @Override
        public void run() {
            System.out.println("我是t1" );
        }
    });
    static Thread t2= new Thread(new Runnable() {
        @Override
        public void run() {
            System.out.println("我是t2" );
        }
    });
    static Thread t3= new Thread(new Runnable() {
        @Override
        public void run() {
            System.out.println("我是t3" );
        }
    });
    static ExecutorService executor =  Executors.newFixedThreadPool(1);
    public static void main(String [] args) throws InterruptedException{
       /* t1.start();
        t1.join();
        t2.start();
        t2.join();
        t3.start();
        t3.join();*/
        executor.submit(t1);
        executor.submit(t2);
        executor.submit(t3);
        executor.shutdown();
    }
}
