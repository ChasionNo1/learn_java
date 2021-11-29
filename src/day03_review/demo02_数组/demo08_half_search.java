package day03_review.demo02_数组;

import java.util.Arrays;

// 二分法查找
public class demo08_half_search {
    public static void main(String[] args) {
        int[] arr = {-29, 30, 21, 84, 20, 49, 34, 56};
        boolean flag = true;
        int searchNum = 28;
        int head = 0; // 首索引位置
        int end = arr.length -1; // 尾索引位置
        // 要求数组是有序的，从小到大
        Arrays.sort(arr);
        while (head <= end){
            int middle = (head + end) / 2;
            if (arr[middle] == searchNum){
                System.out.println("找到指定元素，索引为：" + middle);
                flag = false;
                break;
            }else if (arr[middle] > searchNum){
                end = middle - 1;
            }else {
                head = middle + 1;
            }
        }
        if (flag){
            System.out.println("未找到指定元素");
        }
    }
}
