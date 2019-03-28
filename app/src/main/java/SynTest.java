public class SynTest {

    static  void method (Thread thread) {

        System.out.println("begin :" + thread.getName());
        try{
            Thread.sleep(2000);
        }catch(Exception e){
            e.printStackTrace();

        }
        System.out.println("end: "+thread.getName());
    }

//同步方法
     synchronized  static  void method1(Thread thread){
         System.out.println("begin :" + thread.getName());
         try{
             Thread.sleep(2000);
         }catch(Exception e){
             e.printStackTrace();

         }
         System.out.println("end: "+thread.getName());
     }


     //同步代码块
     static  void method2(Thread thread){
        synchronized (SynTest.class){
            System.out.println("begin :" + thread.getName());
            try{
                Thread.sleep(2000);
            }catch(Exception e){
                e.printStackTrace();

            }
            System.out.println("end: "+thread.getName());
        }
     }
     //使用对象锁
    private static Object _lock1 = new Object();
    private static  byte _lock2[] = {};
    static  void method3(Thread thread){
        synchronized (_lock1){
            System.out.println("begin :" + thread.getName());
            try{
                Thread.sleep(2000);
            }catch(Exception e){
                e.printStackTrace();

            }
            System.out.println("end: "+thread.getName());
        }


    }
    public  static  void main(String [] args){
        for(int i =0;i<3;i++){
            new Thread( ){
                public void run(){
                    method3(this);
                }
            }.start();
        }
    }
}
