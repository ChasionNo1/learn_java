package day04_review.demo06_io流.File类的使用.exercise;

import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-01-11 10:59
 */
public class FileDemo {

    @Test
    public void test1() {
        File file1 = new File("d:\\io\\io1");
        File file2 = new File(file1.getParent(), "hh.txt");
        try {
            file2.createNewFile();
            System.out.println("创建成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2() {
        // 判断指定目录下是否有后缀名为.jpg的文件，如果有，就输出该文件名称
        File file = new File("d:\\io\\o1");
        String[] list = file.list();
        for (String f :
                list) {
            if (f.endsWith(".jpg")) {
                System.out.println(f);
            }
        }
    }

    @Test
    public void test3() {
        //
        File file = new File("D:\\java_projects\\learn_java\\src\\day04_review");
//        getFiles(file);
        System.out.println(getDirectorySize(file));

    }

    public void getFiles(File file) {
        //递归方法
        //遍历文件目录
        File[] files = file.listFiles();
        if (files.length > 0) {
            for (File f :
                    files) {
                System.out.println(f);
                if (f.isDirectory()) {
                    getFiles(f);
                }
            }
        }
    }

    public long getDirectorySize(File file) {
        // 统计文件大小
        long size = 0;
        if (file.isFile()) {
            size += file.length();
        } else {
            File[] files = file.listFiles();
            for (File f :
                    files) {
                size += getDirectorySize(f);
            }
        }
        return size;
    }

    // 删除文件
    // 如果自己是文件直接删除
    // 如果自己是目录，先把它的下一级删除，然后再删除自己
}
