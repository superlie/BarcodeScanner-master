public class getZeroNumOfN {
private int getZeroNum(int num){
    if(num < 0)
        return 0;
    int res = 0;
    int cur = 0;
    for(int i=5;i<num+1;i+=5){
        cur =i;
        while(cur%5 ==0){
            res++;
            cur/=5;

        }
    }
    return res;
}
    private int getZeroNum2(int num){
    if(num<0)
        return 0;
    int res =0;
    while(num != 0){
        res += num/5;
        num /= 5;

    }
    return res;
    }
    private int getRightOne1(int num){
    if(num <1)
        return -1;
    int res = 0;
    while(num !=0) {
        num >>>= 1;
        res += num;
    }
    return  res;
    }


    private int getRightOne2(int num){
        if(num <1)
            return -1;
        int ones = 0;
        int temp =num;
        while(temp != 0){
            ones += (temp & 1) !=0? 1:0;
            temp >>>= 1;
        }
        return num -ones;
}
public static void main(String[] args){
    getZeroNumOfN  zeronum = new getZeroNumOfN();
    System.out.println("the zeronum of N！is " + zeronum.getZeroNum2(2000000000));
    System.out.println("the position of first 1 is " + zeronum.getRightOne2(2000000000));

}
}
