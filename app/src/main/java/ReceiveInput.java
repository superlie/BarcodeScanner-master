import java.util.Scanner;

public class ReceiveInput {
    public  static  void main(String [] args){
        Scanner scan = new Scanner(System.in);
        /*System.out.println("请输入你的名字： ");
        String name = scan.nextLine();
        System.out.println("请输入你的年龄： ");
        int age = scan.nextInt();
        System.out.println("请输入你的身高： ");
        Double length =scan.nextDouble();
        System.out.println("数据输入完毕。");
        System.out.println("名叫"+name+"年纪"+age+"身高为"+length+"的一个人掉河里了\n");*/
        System.out.println("请输入一个数组：");
        int [] arr = new int [5];

       for(int i=0; i<5;i++){
            arr[i] = scan.nextInt();

        }
        for(int j=0;j<arr.length;j++){
            System.out.print(arr[j]+" ");
        }
    }
}
