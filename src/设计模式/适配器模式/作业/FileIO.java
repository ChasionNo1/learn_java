package 设计模式.适配器模式.作业;

import java.io.IOException;

/**
 * @ClassName FileIO
 * @Description TODO
 * @Author chasion
 * @Date 2022/5/6 17:16
 *
 * target：将属性集合保存至文件
 */
public interface FileIO {

    void readFromFile(String filename) throws IOException;
    void writeToFile(String filename) throws IOException;
    void setValue(String key, String value);
    String getValue(String key);
}
