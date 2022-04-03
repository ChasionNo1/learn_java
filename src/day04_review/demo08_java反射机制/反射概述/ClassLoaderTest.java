package day04_review.demo08_java反射机制.反射概述;

import org.testng.annotations.Test;

import java.io.InputStream;
import java.util.Properties;

/**
 * 了解类的加载器
 *
 * @program: test
 * @author: chasion
 * @create: 2022-01-15 14:40
 */
public class ClassLoaderTest {

    @Test
    public void test1(){
        // 对于自定义类，使用系统类加载器进行加载
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader);
        // 使用系统类加载的getParent：获取扩展类加载器
        ClassLoader parent = classLoader.getParent();
        System.out.println(parent);
        // 调用扩展类加载器的getParent：无法获取引导类加载器
        // 引导类加载器主要负责加载java的核心类库，无法加载自定义类
        ClassLoader parent1 = parent.getParent();
        System.out.println(parent1);

        ClassLoader classLoader1 = String.class.getClassLoader();
        System.out.println(classLoader1);
    }

    @Test
    public void test2() throws Exception{
        // Properties:用来读取配置文件
        // 此时的文件默认在当前的module下
        // 读取配置文件的方式一：
        Properties properties = new Properties();
//        FileInputStream fis = new FileInputStream("src\\jdbc.properties");
//        properties.load(fis);

        // 读取配置文件的方式二：使用ClassLoader
        // 配置文件默认识别为：当前module的src下
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("jdbc.properties");
        properties.load(is);


        String name = properties.getProperty("name");
        String password = properties.getProperty("password");
        System.out.println("name=" + name + ",password=" + password);

//        InputStream is1 = classLoader.getResourceAsStream("hello.txt");
//        InputStreamReader isr = new InputStreamReader(is1);
//        char[] cbuf = new char[10];
//        int len;
//        while ((len = isr.read(cbuf))!= -1){
//            System.out.println(new String(cbuf, 0, len));
//        }

    }
}
