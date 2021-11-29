package day03_review.demo03_面向对象.类的定义.类的使用;

import java.util.Arrays;

public class TestArrays {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 54, 6};
        MyArrays myArrays = new MyArrays();
        myArrays.traverse(arr);
        myArrays.reverse(arr);
        System.out.println(Arrays.toString(arr));
        int idx = myArrays.index(arr, 3);
        System.out.println(idx);
        int[] arr2 = myArrays.copy(arr);
        arr2[2] = 100;
        myArrays.traverse(arr2);
        myArrays.traverse(arr);
    }
}
