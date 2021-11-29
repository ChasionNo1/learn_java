package day03_review.demo02_数组;

import java.util.Arrays;

/**
 *数组的特点：
 * 1、数组是有序排列的
 * 2、数组属于引用数据类型的变量。数组的元素既可以是基本数据类型、也可以是引用数据类型
 * 3、创建数组对象会在内存中开辟一整块连续的空间
 * 4、数组的长度一旦确定，就不能再更改
 *
 *一维数组的使用：
 * 1、一维数组的声明和初始化
 * 2、如何调用数组的指定位置的元素
 * 3、如何获取数组的长度
 * 4、如何遍历数组
 * 5、数组元素的默认初始化值
 * boolean:false
 * 整形：0
 * 浮点：0.0
 * char：0
 * 引用类型：null
 *
 * 6、数组的内存解析
 *
 *
 * 1、数组的定义
 * 数组存储的数据类型[]  数组名称 = new 数组存储的数据类型[长度];
 * 数据类型[] 数组名 = new 数据类型[]{元素1，元素2，元素3，...}
 * 数据类型[] 数组名 = {元素1，元素2，元素3，...}
 *
 * 2、数组的常见操作
 *    数组越界异常
 *    数组空指针异常
 *    数组遍历
 *    数组获取最大元素
 *    数组反转
 *
 * 3、数组作为方法的参数
 *      方法的参数为基本类型时,传递的是数据值. 方法的参数为引用类型时,传递的是地址值
 * 4、数组作为方法返回值
 * */
public class Demo01_array {
    public static void main(String[] args) {
        // 静态初始化：数组的初始化和元素赋值同时进行
        String[] arr1 = new String[]{"a", "b", "c"};
        int[] arr = {1, 3, 45, 1, 2, 5, 33, 45, 67};
        byte[] arr2 = {1, 2, 3};
        // 动态初始化:数组的初始化和元素赋值分开进行
        int[] scores = new int[10];

        getMax(arr);
        reverse(arr);

    }
    public static void getMax(int[] a){
        int max = a[0];
        for (int value : a) {
            if (value > max) {
                max = value;
            }
        }
        System.out.println("最大值为：" + max);
    }
    public static void reverse(int[] a){
        int temp;
        System.out.println("未反转：");
        print_array(a);
        for (int i = 0; i <= a.length/2 - 1;i++){
            temp = a[i];
            a[i] = a[a.length - i - 1];
            a[a.length - i -1] = temp;
        }
        System.out.println("反转后：");
        print_array(a);
        System.out.println("排序后：");
        Arrays.sort(a);
        print_array(a);

    }
    public static void print_array(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            if (i==0){
                System.out.print("[" + arr[i] + ",");
            }else if (i == arr.length -1){
                System.out.println(arr[i] + "]");
            }else {
                System.out.print(arr[i] + ",");
            }
        }
    }
    //数组作为方法返回值
    public static int[] ouput_arr(int[] arr){
        return arr;
    }
}
