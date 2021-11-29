package day04_review.demo04_ArrayList类;

import java.util.ArrayList;

/*
ArrayList中常用的方法：
1、public boolean add(E e):向集合中添加元素，对于ArrayList来说，添加动作一定是成功的，所以返回值一定是true
                            对于其他集合，添加不一定成功。
2、public E get(int index):返回值是获取的元素
3、public E remove(int index): 返回值是被删除元素
4、public int size():获取集合的长度
* */
public class Demo03ArrayListMethod {
    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<>();

        // 向集合中添加元素
        for (int i = 0; i < 10; i++) {
            array.add(i);
        }
        System.out.println(array);
//      获取集合大小
        System.out.println(array.size());
//        获取指定位置的元素
        System.out.println(array.get(3));
//        删除指定位置的元素
        array.remove(1);
        System.out.println(array);
        each(array);
    }
    public static void each(ArrayList<Integer> arrayList){
        // 集合遍历
        for (Integer value:
             arrayList) {
            System.out.println(value);
        }


    }
}
