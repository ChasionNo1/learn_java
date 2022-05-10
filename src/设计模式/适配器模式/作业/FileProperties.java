package 设计模式.适配器模式.作业;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @ClassName FileProperties
 * @Description TODO
 * @Author chasion
 * @Date 2022/5/6 17:19
 *
 * 适配器：这里继承了FileIO接口，需要实现哪些需求，然后通过委托Properties对象来实现
 */
public class FileProperties implements FileIO{
    private Properties properties;

    public FileProperties() {
        this.properties = new Properties();
    }

    @Override
    public void readFromFile(String filename) throws IOException {
        File file = new File(filename);
        FileInputStream fis = new FileInputStream(file);
        properties.load(fis);
    }

    @Override
    public void writeToFile(String filename) throws IOException {
        File file = new File(filename);
        FileOutputStream fos = new FileOutputStream(file);
        properties.store(fos, "write by properties");
    }

    @Override
    public void setValue(String key, String value) {
        properties.setProperty(key, value);

    }

    @Override
    public String getValue(String key) {
        return properties.getProperty(key);
    }
}
