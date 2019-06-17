public class checkDifferent {

    public static boolean CheckDifferent(String iniString) {

        for(int i=0;i<iniString.length();i++){
            for(int j =i+1;j<iniString.length();j++){
                if((iniString.charAt(i)^iniString.charAt(j))==0)
                    return false;

            }
        }
        return  true;

    }
    public static void main(String[] args){
        String iniString = "abcdefg";
        String iniString2 ="abcdfef";
        System.out.println(CheckDifferent(iniString)+" "+CheckDifferent(iniString2));
    }
}
