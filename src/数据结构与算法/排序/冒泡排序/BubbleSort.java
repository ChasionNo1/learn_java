package 数据结构与算法.排序.冒泡排序;

import java.util.Arrays;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-03-01 19:47
 * <p>
 * 冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        int[] arr = {1, 4, 9, 2, 5, 4, 3, 8, 6};
        System.out.println("排序前");
        System.out.println(Arrays.toString(arr));
        bubbleSort.bubbleSort(arr);
        System.out.println("排序后");
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 时间复杂度 O(N^2)，空间复杂度 O(1) ： 只需原地交换元素，使用常数大小的额外空间。
     *
     *  )
     * @param arr:
     * @return: void
     **/
    public void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 通过增加一个标志位 flag ，若在某轮「内循环」中未执行任何交换操作，则说明数组已经完成排序，直接返回结果即可。
     * 优化后的冒泡排序的最差和平均时间复杂度仍为 O(N^2);在输入数组 已排序 时，达到 最佳时间复杂度 Ω(N) 。
     * @param arr:
     * @return: void
     **/
    public void bubbleSortPro(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            boolean flag = false; // 初始化标志位
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true;
                }
            }
            if (!flag) break;  // 内循环未交换任何元素，则跳出
        }
    }
}
