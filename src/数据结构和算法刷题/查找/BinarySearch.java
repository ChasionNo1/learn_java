package 数据结构和算法刷题.查找;

import java.util.Arrays;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-03-03 09:20
 *
 * 二分法查找
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {2, 3, 6, 4, 5, 9, 15};
        Arrays.sort(arr);
        int aim = 10;
        int i = BinarySearch.binarySearch(arr, aim, 0, arr.length);
        System.out.println(i);

    }

    public static int binarySearch(int[] arr, int value, int start, int end){
        // 划分为一个数时，没找到，返回-1
       if (start > end){
           return -1;
       }
        int mid = (start + end) / 2;
        if (arr[mid] > value){
            return binarySearch(arr, value, start, mid - 1);
        }else if (arr[mid] < value){
            return binarySearch(arr, value, mid + 1, end);
        }else {
            return mid;
        }

    }


}
