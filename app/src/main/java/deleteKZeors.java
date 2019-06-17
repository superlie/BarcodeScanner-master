public class deleteKZeors {

    public static String removeZeros(String str,int k){
        if(str ==null || k<1)
            return  str;
        char [] chars = str.toCharArray();
        int count =0;
        int start = -1;
        for(int i=0;i<chars.length;i++){
            if(chars[i] == '0'){
                count++;
                start = start == -1 ?i:start;

            }else{
                if(count == k){
                    while(count-- !=0)
                        chars[start++] = 0;
                }
                count =0;
                start =-1;
            }

            if(count == k){
                while(count-- !=0)
                    chars[start++ ]=0;
            }
        }

        return  String.valueOf(chars);
    }
    public static void main(String[] args){
        System.out.print(removeZeros("A000B000",3));
    }
}
