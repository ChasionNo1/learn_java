package 数据结构与算法.排序.快速排序;

import java.util.Arrays;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-03-01 20:03
 * <p>
 * 快排
 */
public class QuickSort {
    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        System.out.println("排序前：");
        int[] arr = {7, 3, 2, 6, 0, 1, 5, 4};
        System.out.println(Arrays.toString(arr));
        quickSort.quickSort(arr, 0, arr.length - 1);
        System.out.println("排序后：");
        System.out.println(Arrays.toString(arr));
    }

    /**
     * @param arr:   子数组
     * @param start: 开始索引
     * @param end:   结尾索引
     * @return: void
     **/
    public void quickSort(int[] arr, int start, int end) {
//        if (start >= end) {
//            return;
//        }
////         向左右递归
//        int i = partition(arr, start, end);
//        quickSort(arr, start, i - 1);
//        quickSort(arr, i + 1 , end);
        // 优化1：
        /*
         * 由于普通快速排序每轮选取「子数组最左元素」作为「基准数」，因此在输入数组 完全倒序 时，
         * partition() 的递归深度会达到 N ，即 最差空间复杂度 为O(N) 。

          每轮递归时，仅对 较短的子数组 执行哨兵划分 partition() ，就可将最差的递归深度控制在 O(logN)
         （每轮递归的子数组长度都≤ 当前数组长度/2 ），即实现最差空间复杂度O(logN) 。
         * @return: void
         **/
        while (start < end){
            int i = partition(arr, start, end);
            if (i - start < end - i) {
                quickSort(arr, start, i - 1);
                // 左侧排序好
                start = i + 1;
            } else {
                quickSort(arr, i + 1, end);
                // 右侧排序好
                end = i - 1;
            }
        }



    }

    public int partition(int[] arr, int start, int end) {
        // 优化2：
        /*
         *同样地，由于快速排序每轮选取「子数组最左元素」作为「基准数」，因此在输入数组 完全有序 或 完全倒序 时，
         * partition() 每轮只划分一个元素，达到最差时间复杂度 O(N^2) 。
        因此，可使用 随机函数 ，每轮在子数组中随机选择一个元素作为基准数，这样就可以极大概率避免以上劣化情况。
        值得注意的是，由于仍然可能出现最差情况，因此快速排序的最差时间复杂度仍为 O(N^2)
         * @return: int
         **/
//        int index = (int) (1 + Math.random() * (end - start + 1));
//        swap(arr, start, index);
        int base = arr[start];

        int i = start, j = end;
        while (i < j) {
            // 为什么要先移动j指针呢？
            // 因为假设i指针移动到倒数第二位时，仍然满足，而最后一位数字大于base时，
            // 跳出循环，交换base和最后一位数字，并不满足条件
            // j指针先动，就可以保证，即使j指针到i位置时，（i未动）i的右侧全是大于base的值，返回哨兵索引，可以向右递归
            while (i < j && arr[j] >= base) j--;
            while (i < j && arr[i] <= base) i++;
            swap(arr, i, j);
        }
        swap(arr, i, start);
        return i;
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
