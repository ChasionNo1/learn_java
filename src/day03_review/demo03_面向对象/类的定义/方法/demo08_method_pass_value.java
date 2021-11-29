package day03_review.demo03_面向对象.类的定义.方法;
/*
* 1、基本数据类型：数据值
* 2、引用数据类型：地址值
*
*
* 方法的形参传递机制：值传递
* 1、形参
* 2、实参
* */
public class demo08_method_pass_value {
    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 2, 3, 4, 5};
//        [I@1b6d3586
        System.out.println(arr1);
        char[] arr2 = new char[]{'a', 'b', 'c'};
        // abc
        // println(char[])
        System.out.println(arr2);
    }
}
