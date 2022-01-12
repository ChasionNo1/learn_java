package day04_review.demo06_io流.IO流;

import org.testng.annotations.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 *
 *  * 处理流之二：转换流的使用
 *  * 1.转换流：属于字符流
 *  *   InputStreamReader：将一个字节的输入流转换为字符的输入流
 *  *   OutputStreamWriter：将一个字符的输出流转换为字节的输出流
 *  *
 *  * 2.作用：提供字节流与字符流之间的转换
 *  *
 *  * 3. 解码：字节、字节数组  --->字符数组、字符串
 *  *    编码：字符数组、字符串 ---> 字节、字节数组
 *  *
 *  *
 *  * 4.字符集
 *  *ASCII：美国标准信息交换码。
 *     用一个字节的7位可以表示。
 *  ISO8859-1：拉丁码表。欧洲码表
 *     用一个字节的8位表示。
 *  GB2312：中国的中文编码表。最多两个字节编码所有字符
 *  GBK：中国的中文编码表升级，融合了更多的中文文字符号。最多两个字节编码
 *  Unicode：国际标准码，融合了目前人类使用的所有字符。为每个字符分配唯一的字符码。所有的文字都用两个字节来表示。
 *  UTF-8：变长的编码方式，可用1-4个字节来表示一个字符。
 *
 * @program: test
 * @author: chasion
 * @create: 2022-01-12 20:03
 */
public class InputStreamReaderTest {

    @Test
    public void test1(){
        /*
        此时处理异常的话，仍然应该使用try-catch-finally
        InputStreamReader的使用，实现字节的输入流到字符的输入流的转换
        */
        InputStreamReader isr = null;
        try {
            FileInputStream fis = new FileInputStream("hello.txt");
            //参数2指明了字符集，具体使用哪个字符集，取决于文件保存时使用的字符集
            isr = new InputStreamReader(fis, StandardCharsets.UTF_8);

            char[] cbuf = new char[10];
            int len;
            while ((len = isr.read(cbuf)) != -1){
                String s = new String(cbuf, 0, len);
                System.out.print(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (isr != null)
                isr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //  综合使用InputStreamReader和OutputStreamWriter
    @Test
    public void test2(){
        InputStreamReader isr = null;
        OutputStreamWriter osw = null;
        try {
            FileInputStream fis = new FileInputStream("hello.txt");
            FileOutputStream fos = new FileOutputStream("hello_gbk.txt");

            isr = new InputStreamReader(fis);
            osw = new OutputStreamWriter(fos);

            char[] cbuf = new char[10];
            int len;
            while ((len = isr.read(cbuf)) != -1){
                osw.write(cbuf, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (isr != null)
                isr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (osw != null)
                osw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
