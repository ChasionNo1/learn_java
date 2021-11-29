package day03_review.demo02_数组;

/*
 * 排序算法：
 * 1、时间复杂度
 * 2、空间复杂度
 * 3、稳定性
 *
 * 分类：内部排序和外部排序
 *
 * 内部排序算法：
 * 选择排序：直接选择排序、堆排序
 * 交换排序：冒泡排序、快速排序
 * 插入排序：直接插入排序、折半插入排序、Shell排序
 * 归并排序
 * 桶式排序
 * 基数排序
 * */
public class demo09_sort {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 4, 56, 12, 5, 64, -5, -65};
//        BubbleSort(arr);
        quickSort(arr, 0, arr.length-1);
        for (int a :
                arr) {
            System.out.print(a + "\t");
        }
    }

    static void BubbleSort(int[] arr) {
        // 冒泡的实现
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                // 比较相邻两个元素
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        for (int a :
                arr) {
            System.out.print(a + "\t");
        }
    }

    static void quickSort(int[] data, int start, int end) {
        /*
        * 快速排序(Quick Sort)使用分治法策略。
          它的基本思想是：选择一个基准数，通过一趟排序将要排序的数据分割成独立的两部分；
        * 其中一部分的所有数据都比另外一部分的所有数据都要小。然后，再按此方法对这两部分数据分别进行快速排序，
        * 整个排序过程可以递归进行，以此达到整个数据变成有序序列。

        快速排序流程：
        (1) 从数列中挑出一个基准值。
        (2) 将所有比基准值小的摆放在基准前面，所有比基准值大的摆在基准的后面(相同的数可以到任一边)；在这个分区退出之后，该基准就处于数列的中间位置。
        (3) 递归地把"基准值前面的子数列"和"基准值后面的子数列"进行排序。
        * */
        if (start < end) {
            int base = data[start];
            int low = start;
            int high = end + 1;
            while (true) {
                // 从左往右搜索，当前的数比基数要小，循环才可以执行
                while (low < end && data[++low] - base <= 0)
                    ;
                // 从右往左搜索，当前的数比基数要大，循环才可以执行
                while (high > start && data[--high] - base >= 0)
                    ;
                // 当双方都执行到一个数不满足条件时，开始交换
                if (low < high) {
                    swap(data, low, high);
                } else {
                    break;
                }
            }
            // 当low==high时，一趟交换已经完成，此时将基数与中间的数进行交换
            // 基数左边是比它小的，右边是比它大的
            swap(data, start, high);
            // 接下来对左右两边执行相同的操作，high是中间的位置
            quickSort(data, start, high - 1);//递归调用
            quickSort(data, high + 1, end);
        }
    }
    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
