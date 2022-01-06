package day04_review.demo04_java集合.Iterator迭代器接口;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * 增强for循环的使用
 *
 *
 * @program: test
 * @author: chasion
 * @create: 2022-01-05 15:23
 */
public class ForeachTest {
    public static void main(String[] args) {
        Collection collection = new ArrayList();
        collection.add("aa");
        collection.add("bb");
        collection.add(123);
        collection.add(new Date());

        for (Object obj:
             collection) {
            System.out.println(obj);
        }

        int[] arr = new int[]{1,2,3,4,5,6};
        for (int i :
                arr) {
            System.out.println(i);
        }

        String[] str = new String[]{"AA", "AA", "AA"};
        for (String s :
                str) {
            s = "bb";
        }
        for (int i = 0; i < str.length; i++) {
            System.out.println(str[i]);
        }
    }
}
