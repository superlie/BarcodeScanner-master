import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;

public class LockInterrupt extends Thread {

    public  static ReentrantLock lock1 = new ReentrantLock();
    public static  ReentrantLock lock2 = new ReentrantLock();
    int lock ;
    public LockInterrupt(String name ,int lock){
        super(name);
        this.lock = lock;
    }

    @Override
    public void run() {

        try{
            if(lock == 1){
                lock1.lockInterruptibly();
                try{
                    Thread.sleep(500);
                }catch (Exception e){

                }
                lock2.lockInterruptibly();
            }else{
                lock2.lockInterruptibly();
                try{
                    Thread.sleep(500);
                }catch (Exception e){

                }
                lock1.lockInterruptibly();
            }

        }catch (Exception e){

        } finally {
            if(lock1.isHeldByCurrentThread()){
                lock1.unlock();
            }
            if(lock2.isHeldByCurrentThread()){
                lock2.unlock();
            }
            System.out.println(Thread.currentThread().getId()+"线程退出！");
        }
    }
    public static void main(String[] args) throws  InterruptedException{
        LockInterrupt t1 =new LockInterrupt("t1",1);
        LockInterrupt t2 =new LockInterrupt("t2",2);
        t1.start();
        t2.start();
        Thread.sleep(1000);
    }


}
