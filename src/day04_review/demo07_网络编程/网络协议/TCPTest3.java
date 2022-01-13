package day04_review.demo07_网络编程.网络协议;

import org.testng.annotations.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 *  * 实现TCP的网络编程
 *  * 例题3：从客户端发送文件给服务端，服务端保存到本地。并返回“发送成功”给客户端。
 *  * 并关闭相应的连接。
 *
 * @program: test
 * @author: chasion
 * @create: 2022-01-13 21:04
 */
public class TCPTest3 {
    @Test
    public void client(){
        Socket socket = null;
        OutputStream os = null;
        FileInputStream fis = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        try {
            InetAddress inet = InetAddress.getByName("127.0.0.1");
            socket = new Socket(inet, 8899);
            os = socket.getOutputStream();
            fis = new FileInputStream("test1.png");
            byte[] buffer = new byte[20];
            int len;
            while ((len = fis.read(buffer)) != -1){
                os.write(buffer, 0, len);
            }

            //关闭数据的输出，阻塞
            socket.shutdownOutput();

            //接收来自于服务器端的数据，并显示到控制台上
            is = socket.getInputStream();
            baos = new ByteArrayOutputStream();
            byte[] buffer1 = new byte[5];
            int len1;
            while ((len1 = is.read(buffer1)) != -1){
                baos.write(buffer1, 0, len1);
            }
            System.out.println(baos.toString());


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null)
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (baos != null)
                baos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if (fis != null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (os != null)
                    os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (socket != null)
                    socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Test
    public void server(){
        ServerSocket ss = null;
        Socket socket = null;
        InputStream is = null;
        FileOutputStream fos = null;
        try {
            ss = new ServerSocket(8899);
            socket = ss.accept();
            is = socket.getInputStream();

            fos = new FileOutputStream("test5.png");
            byte[] buffer = new byte[10];
            int len;
            while ((len = is.read(buffer)) != -1){
                fos.write(buffer, 0, len);
            }

            OutputStream os = socket.getOutputStream();
            os.write("图片已收到".getBytes());


        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                if (fos != null)
                    fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (is != null)
                    is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (socket != null)
                    socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (ss != null)
                    ss.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
