package day04_review.demo04_java集合.Map接口;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 *
 *
 * @program: test
 * @author: chasion
 * @create: 2022-01-07 10:47
 */
public class PropertiesTest {
    //Properties:常用来处理配置文件。key和value都是String类型
    public static void main(String[] args) {
        Properties properties = new Properties();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("D:\\java_projects\\learn_java\\src\\jdbc.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            properties.load(fis);
            String name = properties.getProperty("name");
            String password = properties.getProperty("password");
            System.out.println("name=" + name + ";password=" + password);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
