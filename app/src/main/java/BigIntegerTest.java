import  java.math.BigInteger;
import java.util.Scanner;
public class BigIntegerTest {
    public  static  void main(String[] args){
        BigInteger f [] = new BigInteger[5000];
        f[0]=f[1]= BigInteger.ONE;
        for (int i =2;i<5000;i++){
            f[i]=f[i-1].multiply(BigInteger.valueOf(i));
        }
        Scanner cin = new Scanner(System.in);
        while(cin.hasNext()){
            try{
                int m =cin.nextInt();
                System.out.println(f[m]);
            }catch (ArrayIndexOutOfBoundsException e){
                System.out.print(e);
            }

        }
    }
}
