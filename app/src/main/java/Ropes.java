import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Ropes {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int M = input.nextInt();
        double  Length[] = new double[N];
        for (int i = 0; i < N; i++) {
            Length[i] = input.nextDouble();
        }
        Arrays.sort(Length);

        int LengthArray[] = new int[N];
        for(int i = N-1; i>=0;i--){
            LengthArray[i]=(int)Math.floor(Length[i]/Length[0]);
        }
        int begin =0;
        for(;;){
            int sum =0;
            for(int i=begin;i<N;i++){
                sum+=LengthArray[i];
            }
            if(sum>M){
                begin++;
            }else if(sum==M){

                System.out.println(Length[begin]);
                return;
            }else{

                    System.out.println(Length[begin--]);
                    return;
            }
            for(int i = N-1 ;i>=begin;i--){
                LengthArray[i] =  (int)Math.floor(LengthArray[i]/ LengthArray[begin]);
            }

        }


    }
}
