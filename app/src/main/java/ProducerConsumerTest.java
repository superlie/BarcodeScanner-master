public class ProducerConsumerTest {
    /**
     * @param args
     */
    public static void main(String[] args) {
        Container container = new Container();
        Producer p = new Producer(container);
        Consumer c = new Consumer(container);
        new Thread(p).start();

        //可以创建多个生产者消费者线程
        //new Thread(p).start();
        //new Thread(p).start();
        //new Thread(c).start();
        new Thread(c).start();
    }




}
class Consumer implements Runnable{//消费者线程

    Container container = null;

    public Consumer(Container container) {
        this.container = container;
    }

    @Override
    public void run() {

        while(true){

            WoTou woTou = container.get();
            System.out.println("消费了:"+woTou);

            try {
                Thread.sleep((int)(Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

class Producer implements Runnable{//生产者线程

    Container container = null;

    public Producer(Container container) {
        this.container = container;
    }

    @Override
    public void run() {

        for(int i=0;i<100;i++){

            WoTou wotou = new WoTou(i);
            container.set(wotou);
            System.out.println("生产了:" + wotou);
            try{
                Thread.sleep((int)(Math.random() * 200));
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

class Container{

    int index = 0;
    WoTou []arrWT = new WoTou[6];

    //通过synchronized这一关键字来同步
    public synchronized void set(WoTou wotou){//生产方法，加锁

        while(index == arrWT.length){
            //必须使用while，而不是if
            //因为如果用if抛出异常，后边的代码还会继续执行
            //while的话抛出异常后还是回到while里边执行
            try {
                this.wait();
            } catch ( InterruptedException e) {
                e.printStackTrace();
            }
        }

        //唤醒其他线程
        this.notifyAll();

        arrWT[index++] = wotou;

    }

    //通过synchronized这一关键字来同步
    public synchronized WoTou get(){//消费方法，加锁

        while(index == 0){
            //同理，必须使用while
            try{
                this.wait();
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        this.notifyAll();


        WoTou woTou = arrWT[--index];
        return woTou;
    }

}

class WoTou{

    //用来标记生产的每个实例
    int id;

    public WoTou(int id){
        this.id = id;
    }

    public String toString(){
        //重写toString方法，方便打印
        return "WoTou:" + id;
    }
}
