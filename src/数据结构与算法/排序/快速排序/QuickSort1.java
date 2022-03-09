package 数据结构与算法.排序.快速排序;

import java.util.Arrays;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-03-02 10:36
 */
public class QuickSort1 {
    public static void main(String[] args) {
        QuickSort1 quickSort1 = new QuickSort1();
        int[] arr = {10, 4, 6, 9, 18, 17};
        System.out.println(Arrays.toString(arr));
        quickSort1.quickSort(arr, 0, arr.length - 1);
        System.out.println("排序后：");
        System.out.println(Arrays.toString(arr));
    }

    void quickSort(int[] nums, int l, int r) {
        // 子数组长度为 1 时终止递归
        if (l >= r) return;
        // 哨兵划分操作
        int i = partition(nums, l, r);
        // 递归左（右）子数组执行哨兵划分
        quickSort(nums, l, i - 1);
        quickSort(nums, i + 1, r);
    }

    int partition(int[] nums, int l, int r) {
        // 以 nums[l] 作为基准数
        int i = l, j = r;
        while (i < j) {
            while (i < j && nums[j] >= nums[l]) j--;
            while (i < j && nums[i] <= nums[l]) i++;
            swap(nums, i, j);
        }
        swap(nums, i, l);
        return i;
    }

    void swap(int[] nums, int i, int j) {
        // 交换 nums[i] 和 nums[j]
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
