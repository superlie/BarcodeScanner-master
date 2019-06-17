public class strFromTo {
    public static void main(String[] args){
        String str ="1234abc1011abc";
        String from = "abc";
        String to ="56789";
        String newstr =str.replace(from,to) ;//replace(str,from,to)
        System.out.print(replace(str,from,to));

    }
    private static String replace(String str,String from ,String to){
        if(str ==null || from == null || str.equals("")||from.equals(""))
            return str;
        char[] chas  = str.toCharArray();
        char[] chaf = from.toCharArray();
        int match =0;
        for(int i=0;i<chas.length;i++){
            if(chas[i] == chaf[match++]){
                if(match == chaf.length){
                    clear(chas,i,match);
                    match = 0;
                }
            }
            else
                match =0;
        }
        StringBuilder res=new StringBuilder();
        StringBuilder cur = new StringBuilder();
        for(int i =0;i<chas.length;i++){
            if(chas[i]!=0){
                cur = cur.append(chas[i]);
            }
            if(chas[i] == 0 &&(i==0|| chas[i-1]!=0)){
                res = res.append(cur).append(to);
                cur = new StringBuilder("");
            }


        }
        if(!cur.equals(""))
            res = res.append(cur);
        return res.toString();

    }
    private static void clear(char[] chas,int end,int len){
        while(len-->0){
            chas[end--] =0;
        }
    }
}
