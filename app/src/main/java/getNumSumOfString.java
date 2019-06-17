public class getNumSumOfString {

    public static  int numSum(String str){
        if(str == null)
            return 0;
        char [] charArr = str.toCharArray();
        int res =0,num =0,cur =0;
        boolean posi = true;
        for(int i =0;i<charArr.length;i++){
            cur = charArr[i] - '0';
            if(cur<0 || cur >9){
                res += num;
                num =0;
                if(charArr[i] == '-'){
                    if(i-1 > -1 && charArr[i-1] == '-')
                        posi = !posi;
                    else
                        posi = false;
                }else
                    posi = true;
            }else{
                num =num*10+(posi? cur:-cur);
            }


        }
        res +=num;
        return res;

    }
    public static void main(String[] args){
        System.out.print(numSum("A-1CD-2E33"));
    }
}
