package day04_review.demo06_io流.IO流;

import org.testng.annotations.Test;

import java.io.*;

/**
 * * 处理流之一：缓冲流的使用
 * *
 * * 1.缓冲流：
 * * BufferedInputStream
 * * BufferedOutputStream
 * * BufferedReader
 * * BufferedWriter
 * *
 * * 2.作用：提高流的读取、写入的速度
 * *   提高读写速度的原因：内部提供了一个缓冲区
 * *
 * * 3. 处理流，就是“套接”在已有的流的基础上。
 * *
 *
 * @program: test
 * @author: chasion
 * @create: 2022-01-12 10:50
 */
public class BufferedTest {

    /*
    实现非文本文件的复制
     */
    @Test
    public void test1() {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            File src = new File("test1.png");
            File des = new File("test2.png");

            FileInputStream fis = new FileInputStream(src);
            FileOutputStream fos = new FileOutputStream(des);

            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            byte[] buffer = new byte[1024];
            int len;
            while ((len = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bos != null)
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (bis != null)
                bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // 缓冲流文件复制
    public void copyFile(String srcPath, String desPath){
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            File src = new File(srcPath);
            File des = new File(desPath);

            FileInputStream fis = new FileInputStream(src);
            FileOutputStream fos = new FileOutputStream(des);

            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            byte[] buffer = new byte[1024];
            int len;
            while ((len = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
                bos.flush(); // 刷新缓冲区
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bos != null)
                    bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (bis != null)
                    bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test2(){
        String srcPath = "F:\\io\\test.mp4";
        String desPath = "F:\\io\\test1.mp4";
        long start = System.currentTimeMillis();
        copyFile(srcPath, desPath);

        long end = System.currentTimeMillis();
//        64ms
        System.out.println(end - start + "ms");
    }

    @Test
    public void test3(){
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            File src = new File("hello.txt");
            File dest = new File("hello4.txt");

            FileReader fr = new FileReader(src);
            FileWriter fw = new FileWriter(dest);

            br = new BufferedReader(fr);
            bw = new BufferedWriter(fw);
            // 方式一：使用char数组
//            char[] buffer = new char[1024];
//            int len;
//            while ((len = br.read(buffer)) != -1){
//                bw.write(buffer, 0 , len);
//            }

            // 方式二：使用String
            String data;
            while ((data = br.readLine()) != null){
//                bw.write(data + "\n"); // 写入换行
                bw.write(data);
                bw.newLine();  // 写入换行
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (bw != null)
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
