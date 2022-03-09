package 数据结构和算法刷题.查找;

import java.util.Arrays;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-03-03 09:46
 *
 * 插值查找，
 * 对于数据量大，关键字分布比较均匀的查找表来说，采用插值查找，速度较快
 * 关键字分布不均匀的情况下，该方法不一定比二分查找要好
 *
 */
public class InsertValueSearch {
    public static void main(String[] args) {
        int[] arr = {2, 3, 6, 4, 5, 9, 15};
        Arrays.sort(arr);
        int i = InsertValueSearch.insertValueSearch(arr, 0, arr.length - 1, 5);
        System.out.println(i);
    }

    public static int insertValueSearch(int[] arr, int start, int end, int findValue){
        // 需要考虑越界的问题
        if (start > end || findValue < arr[0] || findValue > arr[arr.length - 1]){
            return -1;
        }
        int mid = start + (end - start) * (findValue - arr[start]) / (arr[end] - arr[start]);
        if (findValue > arr[mid]){
            return insertValueSearch(arr, mid + 1, end, findValue);
        }else if (findValue < arr[mid]){
            return insertValueSearch(arr, start, mid - 1, findValue);
        }else {
            return mid;
        }

    }

}
