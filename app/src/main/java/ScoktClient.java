import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ScoktClient {
    public static  void main(String [] args){
        try{
            Socket socket = new Socket("localhost",8888);
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream()) ;
            printWriter.print("服务器你好，我是BAlla兔子。");
            printWriter.flush();


            socket.shutdownOutput();


            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String info ="";
            String temp =null;
            while((temp=bufferedReader.readLine())!=null){
                info +=temp;
                System.out.println("客户端接收服务器消息： "+info);
            }

            bufferedReader.close();
            printWriter.close();
            socket.close();

        }catch (UnknownHostException e){
            e.printStackTrace();
        }
        catch(IOException  e){
            e.printStackTrace();
        }

    }
}
