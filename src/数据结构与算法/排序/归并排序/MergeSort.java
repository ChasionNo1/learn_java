package 数据结构与算法.排序.归并排序;

import java.util.Arrays;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-03-02 14:58
 *
 * 归并排序
 */
public class MergeSort {
    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] arr = {7, 3, 2, 6, 0, 1, 5, 4};
        System.out.println("排序前：");
        System.out.println(Arrays.toString(arr));
        mergeSort.mergeSort(arr, 0,  arr.length - 1);
        System.out.println("排序后：");
        System.out.println(Arrays.toString(arr));
    }

    public void mergeSort(int[] arr, int start, int end){
        if (start >= end){
            return;
        }
        int m = (end + start) / 2;
        // 递归划分
        mergeSort(arr, start, m);
        mergeSort(arr, m + 1, end);
        // 循环合并
        // 暂存需合并区间元素
        int[] temp = new int[end - start + 1];
        // 两指针分别指向左/右子数组的首个元素
        int i = start, j = m + 1, k = 0;
        while (i <= m && j <= end){
            // 当左右子数组都没有选完
            if (arr[i] <= arr[j]){
                temp[k++] = arr[i++];
            }else {
                temp[k++] = arr[j++];
            }
        }
        // 右子数组选完
        while (i <= m){
            temp[k++] = arr[i++];
        }
        // 左子数组选完
        while (j <= end){
            temp[k++] = arr[j++];
        }

        for (i = start, j = 0; i <= end ; i++, j++) {
            arr[i] = temp[j];
        }
    }
}
