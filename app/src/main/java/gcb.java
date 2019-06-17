public class gcb {

    public static int getGcb(int m,int n){
        return n==0? m:getGcb(n,m%n);
    }
    public static  void main(String[] args){
        System.out.print(getGcb(77777,323));
    }
}
