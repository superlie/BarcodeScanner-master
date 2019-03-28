import java.util.Scanner;

/**
 * Created by.
 */
public class Permutation {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int sum = input.nextInt();

        solve(sum);
    }

    //硬币面值
    static int coin[]={1,4,16,64};
    //贪心算法
    //coinnum是每种硬币个数
    public static void solve(int sum){
        int ans = 0;
        for(int i=3; i>=0; i--){
            int n = sum/coin[i];
            sum = sum - n * coin[i];
            ans += n;
        }
        System.out.println(ans);
    }
}
