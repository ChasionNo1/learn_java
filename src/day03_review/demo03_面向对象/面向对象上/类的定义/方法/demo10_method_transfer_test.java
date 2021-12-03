package day03_review.demo03_面向对象.面向对象上.类的定义.方法;

import day03_review.demo03_面向对象.面向对象上.类的定义.类的使用.MyArrays;

/*
* 定义一个int型的数组：int[] arr = new int[]{12,3,3,34,56,77,432};
让数组的每个位置上的值去除以首位置的元素，得到的结果，作为该位置上的
新值。遍历新的数组。

* */
public class demo10_method_transfer_test {
    public static void main(String[] args) {
        int[] arr = new int[]{12,3,3,34,56,77,432};
        for (int i = arr.length - 1; i >= 0; i--) {
            arr[i] = arr[i] / arr[0];
        }
        MyArrays myArrays = new MyArrays();
        myArrays.traverse(arr);
    }
}
