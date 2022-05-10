package 设计模式.适配器模式.作业;

import java.io.IOException;

/**
 * @ClassName MaIN
 * @Description TODO
 * @Author chasion
 * @Date 2022/5/6 18:14
 */
public class Main {
    public static void main(String[] args) throws IOException {
        FileProperties f = new FileProperties();
        // main方法里的资源路径是content root
        f.readFromFile("src/设计模式/适配器模式/作业/file.txt");
        f.setValue("year", "2004");
        f.setValue("month", "4");
        f.setValue("day", "21");
        f.writeToFile("src/设计模式/适配器模式/作业/newfile.txt");
    }
}
