
import java.util.concurrent.*;
import java.util.concurrent.locks.*;
public class AttempLocking {
    private ReentrantLock lock = new ReentrantLock();
    public void untimed(){
        boolean capture = lock.tryLock();
        try{
            System.out.println("trylock :"+capture);
        }finally {
            if(capture){
                lock.unlock();
            }
        }
    }
    public  void timed(){
        boolean capture = false;
        try{
            capture = lock.tryLock(2,TimeUnit.SECONDS);
        }catch (InterruptedException e){
            throw  new RuntimeException(e);
        }
        try{
            System.out.println("tryLock(2,TimeUnit.SECONDS) "+ capture);
        }finally {
            if(capture){
                lock.unlock();
            }
        }
    }
    public  static  void main(String [] args){
        final  AttempLocking al =new AttempLocking();
        al.untimed();
        al.timed();
        new  Thread(){
            {setDaemon(true);}
            public  void run(){
                al.lock.lock();
                System.out.println("acquired");
            }
        }.start();
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){

        }

        Thread.yield();



        al.untimed();
        al.timed();
    }
}
