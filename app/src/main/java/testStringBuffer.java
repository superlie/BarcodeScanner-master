public class testStringBuffer {


        public static void main(String[] args) {
            StringBuffer strb1 = new StringBuffer("Java");// 创建StringBuffer对象str1
            StringBuffer strb2 = new StringBuffer("Java");// 创建StringBuffer对象str2
            System.out.println("****不使用toString()方法****");
            if (strb1.equals(strb2)) {
                System.out.println("相等");
            } else {
                System.out.println("不相等");
            }
            System.out.println("****使用toString()方法****");
            if (strb1.toString().equals(strb2.toString())) {
                System.out.println("相等");
            } else {
                System.out.println("不相等");
            }
        }

}
