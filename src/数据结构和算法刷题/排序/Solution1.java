package 数据结构和算法刷题.排序;

import java.util.Arrays;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-03-02 19:20
 * <p>
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 * 小顶堆
 */
public class Solution1 {
    public static void main(String[] args) {
//        int[] arr = {4, 5, 1, 6, 2, 7, 3, 8};
        int[] arr = {0, 1, 2, 1};
        Solution1 solution1 = new Solution1();
        int[] leastNumbers = solution1.getLeastNumbers(arr, 2);
        System.out.println(Arrays.toString(leastNumbers));

    }

    public int[] getLeastNumbers(int[] arr, int k) {
        int temp;
        int[] least = new int[k];
        int j = 0;
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }

        for (int i = arr.length - 1; i >= arr.length - k; i--) {
            temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            least[j++] = arr[i];
            adjustHeap(arr, 0, i);
        }
        return least;

    }

    public static void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i]; // 记录父节点的值
        // 这个循环的范围怎么解释？
        for (int j = 2 * i + 1; j < length; j = 2 * j + 1) {
            if (j + 1 < length && arr[j] > arr[j + 1]) {
                // 如果左子节点大于右子节点，则指向右子节点
                j++;
            }
            if (arr[j] <= temp) {
                arr[i] = arr[j];
                i = j;
            } else {
                break;
            }
        }
        arr[i] = temp;
    }

}
