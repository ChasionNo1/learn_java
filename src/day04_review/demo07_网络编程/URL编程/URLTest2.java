package day04_review.demo07_网络编程.URL编程;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * 下载网络图片
 * @program: test
 * @author: chasion
 * @create: 2022-01-13 21:57
 */
public class URLTest2 {
    public static void main(String[] args) {
        HttpURLConnection urlConnection = null;
        InputStream is = null;
        FileOutputStream fos = null;
        try {
            URL url = new URL("http://p0.ifengimg.com/pmop/2018/0324/80D5D6AB48FD50C69864AAFDA5BE0417A3015298_size9_w350_h350.jpeg");
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.connect();

            is = urlConnection.getInputStream();
            fos = new FileOutputStream("kears.jpeg");

            byte[] buffer = new byte[1024];
            int len;
            while ((len = is.read(buffer)) != -1){
                fos.write(buffer, 0, len);
            }

            System.out.println("下载完成");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert fos != null;
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            urlConnection.disconnect();
        }


    }
}
