public class hnabi {
    public static  void move(int n,String from ,String buffer ,String to){
        if(n==1){
            System.out.println("form "+ from +" to "+to+";");
            return ;
        }
        move(n-1,from,to,buffer);
        move(1,from,buffer,to);
        move(n-1,buffer,from,to);

    }

 public static void main(String[] args){
        move(10,"h1","h2","h3");
 }
}
