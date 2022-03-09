package 数据结构与算法.排序.堆排序;


import java.util.Arrays;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-02-23 19:03
 * 堆排序
 *
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {2, 1, 3};
//        for (int i = 0; i < 800000; i++) {
//            arr[i] = (int) (Math.random() * 800000);
//        }
        System.out.println("排序前");
        System.out.println(Arrays.toString(arr));
        long start = System.currentTimeMillis();
        heapSort(arr);
        System.out.println("排序后");
        System.out.println(Arrays.toString(arr));
        long end = System.currentTimeMillis();
        System.out.println(end - start + "ms");

    }

    public static void heapSort(int[] arr){
        int temp = 0;
        System.out.println("堆排序");

        // 1、将待排序序列构造成一个大顶堆
        // 自下而上的调整
        for (int i = arr.length/2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }

        // 2、将其与末尾元素进行交换，此时末尾就为最大值。
        for (int i = arr.length - 1; i > 0; i--) {
            // 交换
            temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            // 然后将剩余n-1个元素重新构造成一个堆，这样会得到n个元素的次小值。如此反复执行，便能得到一个有序序列了。
            adjustHeap(arr, 0 , i);
        }

    }

    /**
     * @Description: 将一个数组（二叉树），调整成一个大顶堆， 完成将以 i 对应的非叶子结点的树调整成大顶堆
     * @Author: chasion
     * @Date: 2022/2/23 19:05
     * @param arr: 待调整的数组
     * @param i: 非叶子节点索引
     * @param length: 表示对多少个元素继续调整， length 是在逐渐的减少
     * @return: void
     **/
    public static void adjustHeap(int[] arr, int i, int length){
        int temp = arr[i]; // 保存当前位置的元素，用于交换
        for (int k = 2 * i + 1; k < length; k = k * 2 + 1) {
            // k和k+1是i节点的左右子节点
            if (k + 1 < length && arr[k] < arr[k + 1]){
                // 如果右子节点大于左子节点
                k++; // 指向右子节点
            }
            if (arr[k] > temp){
                // 如果子节点大于父节点
                arr[i] = arr[k]; // 将子节点值给父节点
                i = k; // 指向子节点
            }else {
                break;
            }
        }
        arr[i] = temp; // 将原本父节点值给子节点

    }

}
