import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {

    public static  void main(String[] args){
        try{
            ServerSocket serverSocket = new ServerSocket(8888);
            System.out.println("服务器已启动，等待客户端连接");
            Socket socket = serverSocket.accept();


             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String temp = null;
            String info ="";
            while((temp=bufferedReader.readLine())!=null){
                info += temp;
                System.out.println("已接收到客户端连接");
                System.out.println("服务端接收到客户端消息："+ info+"，当前客户端IP："+socket.getInetAddress().getHostAddress());

            }
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
            printWriter.print("你好，服务端已接受到您的消息！");
            printWriter.flush();
            socket.shutdownOutput();

            printWriter.close();
            bufferedReader.close();
            socket.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
