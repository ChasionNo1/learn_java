package 练习题.day01;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * @Description TODO
 * @Author chasion
 * @Date 2022/2/2 11:35
 **/
public class Demo01 {
    static int i;

    public static void main(String[] args) {
        System.out.println(i);
    }

    @Test
    public void test1(){
        TreeSet<Integer> set = new TreeSet<>();
//        set.subSet()

    }
    @Test
    public void test2(){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        for (int i = 0, j = list.size() - 1; i < j; i++, j--){
            int temp = list.get(i);
            list.set(i, list.get(j));
            list.set(j, temp);
        }
        System.out.println(list);
    }

    @Test
    public void test3(){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(null);
    }
}
