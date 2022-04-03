package day04_review.demo06_io流.IO流;

import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * * 测试FileInputStream和FileOutputStream的使用
 *  *
 *  * 结论：
 *  * 1. 对于文本文件(.txt,.java,.c,.cpp)，使用字符流处理
 *  * 2. 对于非文本文件(.jpg,.mp3,.mp4,.avi,.doc,.ppt,...)，使用字节流处理
 *
 *  文本文件也可也使用字节流处理，但是不能再内存中查看
 *
 *
 * @program: test
 * @author: chasion
 * @create: 2022-01-12 10:20
 */
public class FileInputOutputStreamTest {

    //使用字节流FileInputStream处理文本文件，可能出现乱码。
    @Test
    public void testFileInputStream() {
        FileInputStream fis = null;
        try {
            //1. 造文件
            File file = new File("hello.txt");

            //2.造流
            fis = new FileInputStream(file);

            //3.读数据
            byte[] buffer = new byte[5];
            int len;//记录每次读取的字节的个数
            while((len = fis.read(buffer)) != -1){

                String str = new String(buffer,0,len);
                System.out.print(str);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fis != null){
                //4.关闭资源
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    @Test
    public void test2(){
        /*
        实现对图片的复制操作
         */

        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            File src = new File("test1.png");
            File des = new File("reuslt.png");

            fis = new FileInputStream(src);
            fos = new FileOutputStream(des);

            byte[] buffer = new byte[5];
            int len;
            while ((len = fis.read(buffer)) != -1){
                fos.write(buffer, 0, len);
            }
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
                if (fis != null)
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public void copyFile(String srcPath, String desPath){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            File src = new File(srcPath);
            File des = new File(desPath);

            fis = new FileInputStream(src);
            fos = new FileOutputStream(des);

            byte[] buffer = new byte[1024];
            int len;
            while ((len = fis.read(buffer)) != -1){
                fos.write(buffer, 0, len);
            }
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
                if (fis != null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test3(){
        String srcPath = "F:\\io\\test.mp4";
        String desPath = "F:\\io\\test1.mp4";
        long start = System.currentTimeMillis();
        copyFile(srcPath, desPath);
        long end = System.currentTimeMillis();
//        298ms
        System.out.println(end - start + "ms");
    }
}
