package day01;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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

    @Test
    public void test4(){
        List<List<Integer>> list = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        path.addLast(1);
        path.addLast(2);
//        list.add(path);
        list.add(new ArrayList<>(path));
        System.out.println(list);
    }

    @Test
    public void test5(){
        String s = "123";
        System.out.println(s.substring(0, 2));
    }
}
