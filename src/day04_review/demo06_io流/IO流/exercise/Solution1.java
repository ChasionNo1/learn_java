package day04_review.demo06_io流.IO流.exercise;

import org.testng.annotations.Test;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-01-12 15:58
 */
public class Solution1 {

    @Test
    public void test1() {
        // 实现图片加密和解密操作
        String srcPath = "test1.png";
        String destPaht = "test1_secret.png";
        // 加密
        change(srcPath, destPaht);
        // 解密
        change(destPaht, srcPath.replace("1", "decoder"));

    }

    public void change(String srcPath, String destPath) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            File src = new File(srcPath);
            File dest = new File(destPath);

            fis = new FileInputStream(src);
            fos = new FileOutputStream(dest);

            byte[] buffer = new byte[5];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                for (int i = 0; i < len; i++) {
                    buffer[i] = (byte) (buffer[i] ^ 5);
                }
                fos.write(buffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fos != null)
                    fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fis != null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test2() {
        // 获取文本上每个字符出现的次数
        //提示：遍历文本的每一个字符；字符及出现的次数保存在Map中；将Map中数据
        //写入文件

        String sourcePath = "hello.txt";
        FileReader fr = null;
        HashMap<Character, Integer> map = new HashMap<>();
        try {
            File file = new File(sourcePath);
            fr = new FileReader(file);


            char[] cbuf = new char[10];
            int len;

            while ((len = fr.read(cbuf)) != -1) {
                for (int i = 0; i < len; i++) {
                    if (map.containsKey(cbuf[i])) {
                        int count = map.get(cbuf[i]);
                        count = count + 1;
                        map.put(cbuf[i], count);
                    } else {
                        map.put(cbuf[i], 1);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fr != null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // 遍历map， 写入文件中
        FileWriter fw = null;
        try {
            File countFile = new File("count.txt");
            fw = new FileWriter(countFile);
            Set<Map.Entry<Character, Integer>> entrySet = map.entrySet();
            Iterator<Map.Entry<Character, Integer>> iterator = entrySet.iterator();
            while (iterator.hasNext()) {
                fw.write(String.valueOf(iterator.next()) + "\n");
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
        }


    }
}
