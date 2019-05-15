import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class TryLockTest extends  Thread {
    public  static ReentrantLock lock = new ReentrantLock();
    public  TryLockTest(String name){
        super(name);
    }
    @Override
    public void run(){
        try{
                if(lock.tryLock(5, TimeUnit.SECONDS)){
                    sleep(6000);
                }else {
                    System.out.println(this.getName()+": get lock failed .");
                }
        }catch(Exception e){

        }finally {
                if(lock.isHeldByCurrentThread()){
                    System.out.println("lock.isHeldByCurrentThread:  "+this.getName());
                }
        }

    }
    public  static  void main(String [] args){
        TryLockTest t1 = new TryLockTest("t1");
        TryLockTest t2 = new TryLockTest("t2");
        t1.start();
        t2.start();
    }
}
