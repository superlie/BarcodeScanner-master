import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Statistics {
    public static  void main(String[] args){
        Random rand =new Random(47);
        Map<Integer,Integer> m = new HashMap<Integer, Integer>();
        for(int i=0;i<10000;i++){
            int r= rand.nextInt(20);
            Integer fraq =m.get(r);
            m.put(r,fraq == null?1:fraq+1);


        }
        System.out.println(m);
    }
}