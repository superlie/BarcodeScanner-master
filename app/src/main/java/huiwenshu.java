public class huiwenshu {
    public static boolean palindrome(int n){
        if(n==Integer.MIN_VALUE)
            return false;
        n = Math.abs(n);
        int help = 1;
        while(n/help >=10){
            help *=10;
        }
        while(n!=0){
            if(n/help != n%10)
                return false;
            n = (n%help)/10;
            help /=100;
        }
        return true;
    }
    public static void main(String[] args){
        System.out.print(palindrome(1222222));
    }
}
