package day04_review.demo06_io流.随机存取文件流;

import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * * RandomAccessFile的使用
 *  * 1.RandomAccessFile直接继承于java.lang.Object类，实现了DataInput和DataOutput接口
 *  * 2.RandomAccessFile既可以作为一个输入流，又可以作为一个输出流
 *  *
 *  * 3.如果RandomAccessFile作为输出流时，写出到的文件如果不存在，则在执行过程中自动创建。
 *  *   如果写出到的文件存在，则会对原有文件内容进行覆盖。（默认情况下，从头覆盖）
 *  *
 *  * 4. 可以通过相关的操作，实现RandomAccessFile“插入”数据的效果
 *
 * RandomAccessFile 类支持 “随机访问” 的方式，程序可以直接跳到文件的任意
 * 地方来读、写文件
 * 支持只访问文件的部分内容
 * 可以向已存在的文件后追加内容
 *  方法：
 *  long getFilePointer():获取文件记录指针的当前位置
 *  void seek(long pos):将文件记录指针定位到 pos 位置
 *
 *  构造器：
 *  public RandomAccessFile(File file, String mode)
 *  public RandomAccessFile(String name, String mode)
 *
 *  创建 RandomAccessFile 类实例需要指定一个 mode 参数，该参数指定 RandomAccessFile 的访问模式：
 * r: 以只读方式打开
 * rw：打开以便读取和写入
 * rwd:打开以便读取和写入；同步文件内容的更新
 * rws:打开以便读取和写入；同步文件内容和元数据的更新
 *
 * 如果模式为只读r。则不会创建文件，而是会去读取一个已经存在的文件，
 * 如果读取的文件不存在则会出现异常。 如果模式为rw读写。如果文件不
 * 存在则会去创建文件，如果存在则不会创建。
 *
 * @program: test
 * @author: chasion
 * @create: 2022-01-13 15:20
 */
public class RandomAccessFileTest {

    @Test
    public void test1(){
        RandomAccessFile raf1 = null;
        RandomAccessFile raf2 = null;
        try {
            raf1 = new RandomAccessFile(new File("test1.png"), "r");
            raf2 = new RandomAccessFile(new File("test3.png"), "rw");

            byte[] buffer = new byte[1024];
            int len;
            while ((len = raf1.read(buffer)) != -1){
                raf2.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (raf2 != null)
                raf2.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (raf1 != null)
                raf1.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test2(){
        RandomAccessFile raf = null;
        try {
            raf = new RandomAccessFile(new File("hello.txt"), "rw");
            raf.seek(3);
            raf.write("xyz".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (raf != null)
                raf.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test3(){
//        使用RandomAccessFile实现数据的插入效果
        RandomAccessFile raf1 = null;
        try {
            raf1 = new RandomAccessFile("hello.txt","rw");

            raf1.seek(3);//将指针调到角标为3的位置
            //保存指针3后面的所有数据到StringBuilder中
            StringBuilder builder = new StringBuilder((int) new File("hello.txt").length());
            byte[] buffer = new byte[20];
            int len;
            while((len = raf1.read(buffer)) != -1){
                builder.append(new String(buffer,0,len)) ;
            }
            //调回指针，写入“xyz”
            raf1.seek(3);
            raf1.write("xyz".getBytes());

            //将StringBuilder中的数据写入到文件中
            raf1.write(builder.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (raf1 != null)
                raf1.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //思考：将StringBuilder替换为ByteArrayOutputStream
    }
}
