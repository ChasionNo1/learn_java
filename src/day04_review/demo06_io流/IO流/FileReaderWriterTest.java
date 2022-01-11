package day04_review.demo06_io流.IO流;

import org.testng.annotations.Test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * * 一、流的分类：
 *  * 1.操作数据单位：字节流、字符流
 *  * 2.数据的流向：输入流、输出流
 *  * 3.流的角色：节点流、处理流
 *  *
 *  * 二、流的体系结构
 *  * 抽象基类         节点流（或文件流）                               缓冲流（处理流的一种）
 *  * InputStream     FileInputStream   (read(byte[] buffer))        BufferedInputStream (read(byte[] buffer))
 *  * OutputStream    FileOutputStream  (write(byte[] buffer,0,len)  BufferedOutputStream (write(byte[] buffer,0,len) / flush()
 *  * Reader          FileReader (read(char[] cbuf))                 BufferedReader (read(char[] cbuf) / readLine())
 *  * Writer          FileWriter (write(char[] cbuf,0,len)           BufferedWriter (write(char[] cbuf,0,len) / flush()
 *  *
 * @program: test
 * @author: chasion
 * @create: 2022-01-11 19:38
 */
public class FileReaderWriterTest {

    @Test
    public void test1(){
        // 相对路径：main方法相较于当前工程，单元测试：相较于当前module
    /*
    将hello.txt文件内容读入程序中，并输出到控制台

    说明点：
    1. read()的理解：返回读入的一个字符。如果达到文件末尾，返回-1
    2. 异常的处理：为了保证流资源一定可以执行关闭操作。需要使用try-catch-finally处理
    3. 读入的文件一定要存在，否则就会报FileNotFoundException。

     */
        FileReader fr = null;

        try {
            //1.实例化File类的对象，指明要操作的文件
            File file = new File("hello.txt");
            //2.提供具体的流
            fr = new FileReader(file);
            //3.数据的读入
            //read():返回读入的一个字符。如果达到文件末尾，返回-1
//        int data = fr.read();
//        // 方式一：
//        while (data != -1){
//            System.out.println((char) data);
//            data = fr.read();
//        }

            // 方式二：
            int data;
            while ((data = fr.read()) != -1) {
                System.out.println((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
//            try {
//                //4.流的关闭操作
//                if (fr != null){
//                    fr.close();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
            // or
            if(fr != null){
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test2(){
        //对read()操作升级：使用read的重载方法
        FileReader fr = null;

        try {
            //1.File类的实例化
            File file = new File("hello.txt");
            //2.FileReader流的实例化
            fr = new FileReader(file);
            //3.读入的操作
            char[] cbuf = new char[5];
            int data = fr.read(cbuf);
            int len;
            while ((len = fr.read(cbuf)) != -1){
                // 方式一：
                for (int i = 0; i < cbuf.length; i++) {
                    System.out.print(cbuf[i]);
                }

                // 正确的
                for (int i = 0; i < len; i++) {
                    System.out.print(cbuf[i]);
                }

                //方式二：
                //错误的写法,对应着方式一的错误的写法
    //            String str = new String(cbuf);
    //            System.out.print(str);

                // 正确的
                String str = new String(cbuf, 0, len);
                System.out.print(str);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.资源的关闭
            try {
                if (fr != null){
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test3(){
        /*
    从内存中写出数据到硬盘的文件里。

    说明：
    1. 输出操作，对应的File可以不存在的。并不会报异常
    2.
         File对应的硬盘中的文件如果不存在，在输出的过程中，会自动创建此文件。
         File对应的硬盘中的文件如果存在：
                如果流使用的构造器是：FileWriter(file,false) / FileWriter(file):对原有文件的覆盖
                如果流使用的构造器是：FileWriter(file,true):不会对原有文件覆盖，而是在原有文件基础上追加内容

     */
        FileWriter fw = null;
        try {
            //1.提供File类的对象，指明写出到的文件
            File file = new File("hello1.txt");
            //2.提供FileWriter的对象，用于数据的写出
            fw = new FileWriter(file);

            fw.write("测试写入\n");
            fw.write("testing writer function");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fw != null)
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test4(){
        FileReader fr = null;
        FileWriter fw = null;
        try {
            //1.创建File类的对象，指明读入和写出的文件
            File src = new File("hello.txt");
            File des = new File("hello2.txt");

            //不能使用字符流来处理图片等字节数据
//            File src = new File("test1.png");
//            File des = new File("test2.png");

            //2.创建输入流和输出流的对象
            fr = new FileReader(src);
            fw = new FileWriter(des);

            //3.数据的读入和写出操作
            char[] cbuf = new char[5];
            int len;
            while ((len = fr.read(cbuf)) != -1){
                fw.write(cbuf, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fw != null)
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fr != null)
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
