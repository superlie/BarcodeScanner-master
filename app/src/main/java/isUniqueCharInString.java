public class isUniqueCharInString {
    private static boolean isUnique(String str){
        if(str.length()>256)
            return false;
        boolean [] map = new boolean[256];
        char[] chas = str.toCharArray();
        for(int i=0;i<chas.length;i++){
            if(map[chas[i]])
                return false;
            map[chas[i]] =true;
        }
        return true;
    }
    public static void main(String[] args){
        System.out.print(isUnique("abcdf123"));
    }
}
