import java.util.Random;

public class testRandom {
    private static  final Random rand = new Random();
    static  int random(int n){
        return Math.abs(rand.nextInt())%n;
    }
    public static  void main(String[] args){
        int n = 2*(Integer.MAX_VALUE/3);
        int low=0;
        for(int i = 0;i<100000;i++){
            if(random(n)<n/2)
                low++;
        }
        System.out.println(low);
        Integer t1 = new Integer(10);
        Integer t2 = new Integer(10);
        System.out.print(t1==t2);
        StringBuffer sb = new StringBuffer(123);
    }
}
