package day04_review.demo06_io流.对象流;

import org.testng.annotations.Test;

import java.io.*;

/**
 *
 * * 对象流的使用
 *  * 1.ObjectInputStream 和 ObjectOutputStream
 *  * 2.作用：用于存储和读取基本数据类型数据或对象的处理流。它的强大之处就是可以把Java中的对象写入到数据源中，也能把对象从数据源中还原回来。
 *  *
 *  * 3.要想一个java对象是可序列化的，需要满足相应的要求。见Person.java
 *  *
 *  * 4.序列化机制：
 *  * 对象序列化机制允许把内存中的Java对象转换成平台无关的二进制流，从而允许把这种
 *  * 二进制流持久地保存在磁盘上，或通过网络将这种二进制流传输到另一个网络节点。
 *  * 当其它程序获取了这种二进制流，就可以恢复成原来的Java对象。
 *
 *
 * @program: test
 * @author: chasion
 * @create: 2022-01-13 09:13
 */
public class ObjectStreamTest {

      /*
    序列化过程：将内存中的java对象保存到磁盘中或通过网络传输出去
    使用ObjectOutputStream实现
     */

    @Test
    public void test1(){
        ObjectOutputStream oos = null;
        try {
            FileOutputStream fos = new FileOutputStream("object.dat");
            oos = new ObjectOutputStream(fos);
            oos.writeObject("今天星期四");
            oos.flush();

            oos.writeObject(new Person("TOM", 23, 1001, new Account(234.12)));
            oos.flush();

            oos.writeObject(new Person("JACA", 34, 1002));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (oos != null)
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

     /*
    反序列化：将磁盘文件中的对象还原为内存中的一个java对象
    使用ObjectInputStream来实现
     */
    @Test
    public void test2(){
        ObjectInputStream ois = null;
        try {
            FileInputStream fis = new FileInputStream("object.dat");
            ois = new ObjectInputStream(fis);
            Object o1 = ois.readObject();
            String str = (String) o1;
            System.out.println(str);

            Object o2 = ois.readObject();
            System.out.println(o2);

            Object o3 = ois.readObject();
            System.out.println(o3);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ois != null)
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
