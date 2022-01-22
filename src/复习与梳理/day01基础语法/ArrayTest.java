package 复习与梳理.day01基础语法;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

/**
 * 数组
 *
 * @Description TODO
 * @Author chasion
 * @Date 2022/1/21 16:20
 **/
public class ArrayTest {

    @Test
    public void test1(){
        int num;//声明
        num = 10;//初始化
        int id = 1001;//声明 + 初始化

        int[] ids;//声明
        //1.1 静态初始化:数组的初始化和数组元素的赋值操作同时进行
        ids = new int[]{1001,1002,1003,1004};
        //1.2动态初始化:数组的初始化和数组元素的赋值操作分开进行
        String[] names = new String[5];

        int[] arr4 = {1,2,3,4,5};//类型推断
    }

    @Test
    public void test2(){
//        5.一维数组元素的默认初始化值
//                > 数组元素是整型：0
//                * 		> 数组元素是浮点型：0.0
//                * 		> 数组元素是char型：0或'\u0000'，而非'0'
//                * 		> 数组元素是boolean型：false
//                *
// * 		> 数组元素是引用数据类型：null
        int[] arr1 = new int[5];
        System.out.println(arr1[0]);

        String[] arr2 = new String[4];
        System.out.println(arr2[0]);
    }

    @Test
    public void test3(){
        int[] arr = new int[]{1,2,3};//一维数组
        //静态初始化
        int[][] arr1 = new int[][]{{1,2,3},{4,5},{6,7,8}};
        //动态初始化1
        String[][] arr2 = new String[3][2];
        //动态初始化2
        String[][] arr3 = new String[3][];
        //也是正确的写法：
        int[] arr4[] = new int[][]{{1,2,3},{4,5,9,10},{6,7,8}};
        int[] arr5[] = {{1,2,3},{4,5},{6,7,8}};//类型推断
    }

    @Test
    public void test4(){
//        6.二维数组元素的默认初始化值
//                * 	规定：二维数组分为外层数组的元素，内层数组的元素
//                * 		int[][] arr = new int[4][3];
// * 		外层元素：arr[0],arr[1]等
//                * 		内层元素：arr[0][0],arr[1][2]等
//                *
// *   ⑤ 数组元素的默认初始化值
//                *   针对于初始化方式一：比如：int[][] arr = new int[4][3];
// *      外层元素的初始化值为：地址值
//                *      内层元素的初始化值为：与一维数组初始化情况相同
//                *
// *   针对于初始化方式二：比如：int[][] arr = new int[4][];
// *   	外层元素的初始化值为：null
//                *      内层元素的初始化值为：不能调用，否则报错。
    }

    @Test
    public void test5(){
        // 排序算法
        // 冒泡排序
        // 快速排序
        int[] arr = {1, 2, 4, 4, 56, 12, 5, 64, -5, -65};
        BubbleSort(arr);
        quickSort(arr, 0, arr.length-1);
        for (int a :
                arr) {
            System.out.print(a + "\t");
        }
    }
    public void BubbleSort(int[] arr) {
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
    public void quickSort(int[] data, int start, int end) {
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
    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    @Test
    public void test6(){
        // Arrays 方法
        //1.boolean equals(int[] a,int[] b):判断两个数组是否相等。
        int[] arr1 = new int[]{1,2,3,4};
        int[] arr2 = new int[]{1,3,2,4};
        boolean isEquals = Arrays.equals(arr1, arr2);
        System.out.println(isEquals);

        //2.String toString(int[] a):输出数组信息。
        System.out.println(Arrays.toString(arr1));


        //3.void fill(int[] a,int val):将指定值填充到数组之中。
        Arrays.fill(arr1,10);
        System.out.println(Arrays.toString(arr1));


        //4.void sort(int[] a):对数组进行排序。
        Arrays.sort(arr2);
        System.out.println(Arrays.toString(arr2));

        //5.int binarySearch(int[] a,int key)
        int[] arr3 = new int[]{-98,-34,2,34,54,66,79,105,210,333};
        int index = Arrays.binarySearch(arr3, 210);
        if(index >= 0){
            System.out.println(index);
        }else{
            System.out.println("未找到");
        }

        List<Integer> integers = Arrays.asList(1, 2, 3);
        integers.forEach(System.out::println);

    }

}
