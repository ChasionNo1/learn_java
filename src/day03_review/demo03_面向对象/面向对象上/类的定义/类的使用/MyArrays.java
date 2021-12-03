package day03_review.demo03_面向对象.面向对象上.类的定义.类的使用;

/*
 * 自定义数组的工具类
 * */
public class MyArrays {
    // 求数组的最值
    public int getMax(int[] arr) {
        int temp = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (temp < arr[i]) {
                temp = arr[i];
            }
        }
        return temp;
    }

    public int getMin(int[] arr) {
        int min = arr[0];
        for (int x :
                arr) {
            if (min > x) {
                min = x;
            }
        }
        return min;
    }

    public double getMean(int[] arr) {
        int mean = 0;
        for (int x :
                arr) {
            mean += x;
        }
        return mean / (double) (arr.length);
    }

    public int getSum(int[] arr) {
        int sum = 0;
        for (int x :
                arr) {
            sum += x;
        }
        return sum;
    }
    // 反转数组

    public void reverse(int[] arr) {
        for (int i = 0; i < (arr.length - 1) / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - i - 1] = temp;
        }
    }

    // 数组遍历
    public void traverse(int[] arr) {
        String s = "";
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                s += "[" + arr[i] + ", ";
            } else if (i == arr.length - 1) {
                s += arr[i] + "]";
            } else {
                s += arr[i] + ", ";
            }
        }
        System.out.println(s);
    }

    // 查找指定元素
    public int index(int[] arr, int value) {
        // 先排序
        sort(arr);
        int head=0;
        int end = arr.length-1;
        while (head < end) {
            int middle = (head + end) / 2;
            if (arr[middle] == value) {
                return middle;
            } else if (arr[middle] > value) {
                end = middle - 1;
            } else {
                head = middle + 1;
            }
        }
        return -1;
    }

    // 复制数组
    public int[] copy(int[] arr1){
        int[] arr2 = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            arr2[i] = arr1[i];
        }
        return arr2;
    }

    // 数组排序
    public void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
