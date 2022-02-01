package 项目.项目五单机考试软件.service;

import 项目.项目五单机考试软件.domain.Item;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 封装了与考试题目访问相关的业务方法
 *
 * @Description TODO
 * @Author chasion
 * @Date 2022/1/30 21:03
 **/
public class ItemService {
    private Item[] items;

    private final String ITEM_FILENAME = "D:\\java_project\\learn_java\\src\\项目\\项目五单机考试软件\\Items.txt";
    private final String ANSWER_FILENAME = "./answer.dat";
    public final int TOTAL_ITEMS;//题目数

    private final int LINES_PER_ITEMS = 6;//每题占用的行数

    public ItemService() {

        List<String> list = readTextFile(ITEM_FILENAME);
        TOTAL_ITEMS = list.size() / LINES_PER_ITEMS;
        // 一个item对象有6行，1行题目，4个选项，1个答案
        items = new Item[TOTAL_ITEMS];
        for (int i = 0; i < TOTAL_ITEMS; i++) {
            String question = list.get(i * LINES_PER_ITEMS);
            String[] selections = {
                    list.get(i * LINES_PER_ITEMS + 1),
                    list.get(i * LINES_PER_ITEMS + 2),
                    list.get(i * LINES_PER_ITEMS + 3),
                    list.get(i * LINES_PER_ITEMS + 4),
            };
            char answer = list.get(i * LINES_PER_ITEMS + 5).charAt(0);
            items[i] = new Item(question, selections, answer);
        }
    }

    //    public void readTextFile(String filename){
////        该方法可读取参数指定的文本文件内容 （不使用包装） ，并打印输出到屏幕上；
//        FileReader fr = null;
//        try {
//            File file = new File(filename);
//            fr = new FileReader(file);
//
//            char[] cbuf = new char[1024];
//            int len;
//            while ((len = fr.read(cbuf)) != -1){
//                System.out.println(new String(cbuf, 0, len));
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                assert fr != null;
//                fr.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
    private List<String> readTextFile(String filename){
        ArrayList<String> list = new ArrayList<>();
//        该方法使用流的链接，以文本行的方式读取参数指定的文本文件内容，并放置到集合中以作为该方法的返回值；

        FileReader fr = null;
        BufferedReader br = null;
        try {
            File file = new File(filename);
            // 缓冲流， readLine方法
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            String data;
            while ((data = br.readLine()) != null){
                if (!data.trim().equals("")){
                    // 去掉空行
                    list.add(data);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert br != null;
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return list;
    }

    public Item getItem(int no){
        if (no < 1 || no > TOTAL_ITEMS){
            return null;
        }else {
            no -= 1;
            return items[no];
        }
    }

    public void saveAnswer(char[] answer){
        // 将数组写入到文件中，对象流
        File file = new File(ANSWER_FILENAME);
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(file);
            oos = new ObjectOutputStream(fos);

            oos.writeObject(answer);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert oos != null;
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public char[] readAnswer() {
        char[] answer = null;

        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            fis = new FileInputStream(ANSWER_FILENAME);
            ois = new ObjectInputStream(fis);

            answer = (char[])ois.readObject();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }

        return answer;
    }
}
