import java.util.HashMap;
import java.util.Scanner;

public class ZeroOnePack {

    int N,V;
    int [] weights;
    int [] values;
    int[][] dp;
    public void init(){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        V = sc.nextInt();
        dp = new int[N+1][V+1];
        weights = new int[N+1];
        values = new int[N+1];
        for(int i=1;i<=N;i++){
            weights[i]=sc.nextInt();
        }
        for(int i=1;i<=N;i++){
            values[i]=sc.nextInt();
        }

    }
    public void ZeroOnePackNonRecursive3(){
        for(int i= 0;i<=N;i++)
            dp[0][i] =0;

        for(int i =1;i<=N;i++){
            for(int j =1;j<=V;j++){
                dp[i][j]=j>weights[i]? Math.max(dp[i-1][j-weights[i]]+values[i],dp[i-1][j]):dp[i-1][j];
            }
        }
        for(int i =0;i<=N;i++){
            for(int j =0;j<=V;j++){
                System.out.print(dp[i][j]+ "  ");
            }
            System.out.println();
        }
        System.out.println(dp[N][V]);
    }
    public void ZeroOnePackNonRecursive(){
        for(int j=0;j<=V;j++)
        {dp[0][j]=0;}
        for(int i =1;i<=N;i++){
            for(int j =0;j<=V;j++){
                if(j>=weights[i]){
                    dp[i][j] = Math.max(dp[i-1][j-weights[i]]+values[i],dp[i-1][j]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }

            }
        }
        for(int i=0;i<=N;i++){
            for(int j=0;j<=V;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }

    }
    public void ZeroOnePackNonRecursive2() {
        //对二维数组F进行初始化
        for(int j = 0; j <= V; j++) {
            dp[0][j] = 0;
        }
        for(int i =0;i<=N;i++)
            dp[i][0]=0;

        //注意边界问题，i是从1开始的，j是从0开始的
        //因为F[i - 1][j]中i要减1
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= V; j++) {
                //如果容量为j的背包放得下第i个物体
                if( weights[i]<=j) {
                    dp[i][j] = Math.max(dp[i - 1][j - weights[i]] + values[i], dp[i - 1][j]);
                }else {
                    //放不下，只能选择不放第i个物体
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        //打印所有结果，我们要求的是F[N][V]
        for(int i = 0; i <= N; i++) {
            for(int j = 0; j <= V; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }

    public  void printResult(int n,int v){
        boolean [] result = new boolean[n+1];
        for(int i =n;i>=1;i--){
            if(dp[i][v] == dp[i-1][v]){
                result[i] = false;
            }else{
                result[i] = true;
                v -= weights[i];
            }
        }
        for(int i =1;i<=n;i++){
            System.out.print(result[i]+" ");
        }
        System.out.println();
    }
    public boolean checkDifferent(String iniString) {

        for(int i=0;i<iniString.length();i++){
            for(int j =i+1;j<iniString.length();j++){
                if((iniString.charAt(i)^iniString.charAt(j))==0)
                    return false;

            }
        }
        return  true;

    }
    public static  void main(String[] args){
        ZeroOnePack pack = new ZeroOnePack();
        pack.init();
        pack.ZeroOnePackNonRecursive3();
        pack.printResult(pack.N,pack.V);
    }
}
