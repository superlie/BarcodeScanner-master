public class CountCharInString {

    private static String getCountString(String str){
        if(str ==null )
            return str;
        StringBuilder  res = new StringBuilder();
        char[] chas = str.toCharArray();
        int count =1;
        int i =0;
        for(;i<chas.length-1;i++){

            if(chas[i] == chas[i+1]){

                count++;
            }
            else{
                res.append(chas[i]).append('_').append(count).append('_');
                count =1;

            }
        }
        res.append(chas[i]).append('_').append(count);
        return res.toString();
    }
    public static void main(String[] args){
        String str = "aaabbcddddffghhhh";
        System.out.print(getCountString(str));
    }
}
