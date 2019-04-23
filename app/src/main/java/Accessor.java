import java.util.Random;

public class Accessor implements  Runnable
{
    private  final int id;
    public Accessor(int idnn){
        id=idnn;
    }
    public void run(){
        while(!Thread.currentThread().isInterrupted()){
           // ThreadLocalVariableHolder.inc
        }
    }
    public  class ThreadLocalVariableHolder{
        private  ThreadLocal<Integer> value = new ThreadLocal<Integer>(){
            private Random rand =new Random(47);
            protected  synchronized  Integer initialValue(){
                return rand.nextInt();
            }
        };
    }
    public  static  void increment(){
       // value.set(value.get()+1);

    }
    public static  int get(){
      //  return  value.get();
        return 0;
    }

}
