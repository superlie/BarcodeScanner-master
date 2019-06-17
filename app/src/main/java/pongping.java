public class pongping {
    public static void main(String args[]) {
        //for(int i= 0;i<1000;i++){
            Thread t = new Thread() {

                public void run() {

                    pong();

                }

            };

            t.start();

            System.out.print("ping\n");




                Byte var1 = 126;

                Byte var2 = 127;
                //var1+=var2;

               // Byte var3 = var1 + var2;   //第7行




       // }



    }

    static void pong() {

        System.out.print("pong");

    }
}
