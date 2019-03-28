public class RuntimeContantPolllOOm {
    public  static  void main(String[] args){
        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.print(str1.intern()==str1);

        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.print(str2.intern()==str2);
    }
}
