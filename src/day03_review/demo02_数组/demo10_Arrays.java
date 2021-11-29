package day03_review.demo02_数组;

import java.util.Arrays;

public class demo10_Arrays {
    public static void main(String[] args) {
        int[] arr1 = {1, 23, 4, 5};
        int[] arr2 = {1, 2, 4, 5};
        // 判断两个数组是否相等
        boolean flag = Arrays.equals(arr1, arr2);
        // 输出数组信息
        System.out.println(Arrays.toString(arr1));
        // 将指定值填充到数组之中
        Arrays.fill(arr1, 3);
        // 排序
        Arrays.sort(arr1);
        // 二分查找
        int idx = Arrays.binarySearch(arr1, 5);
        System.out.println(flag);
        System.out.println(idx);
    }
}
