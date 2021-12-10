package day04_review.other.demo04_ArrayList类;

import java.util.ArrayList;

/*
* 数组的长度不可以发生改变
* 但是ArrayList集合的长度可以随意变化
*
* 对于ArrayList来说，有一个<E>代表泛型
* 泛型：也就是装在集当中的所有元素，全都是统一的什么类型
* 注意：泛型只能是引用类型，不能是基本类型
*       对于ArrayList来说，直接打印得到的不是地址值，而是内容，如果内容为空，得到的是[]。
* */
public class Demo02ArrayList {
    public static void main(String[] args) {
        // 创建一个ArrayList集合，集合的名称是list，里面装的全都是String字符串类型的数据
        // 从jdk1.7+开始，右侧的尖括号内可以不写内容，但<>要写
        ArrayList<String> list = new ArrayList<>();
        System.out.println(list);

        // 向集合当中添加一些数据，用add方法
        list.add("a");
        System.out.println(list);
        list.add("b");
        list.add("c");
//        list.add(1);  添加统一类型的数据
    }
}
