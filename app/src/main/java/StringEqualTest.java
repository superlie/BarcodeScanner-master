public class StringEqualTest
{
    public static  void main(String[] args){
        String a = new String("myString");
        String b = "myString";
        String c = "my" + "String";
        String d = c;
        System.out.println(a == b);
        System.out.println(a == c);
        System.out.println(b == c);
        System.out.println(b == d);
    }
}
