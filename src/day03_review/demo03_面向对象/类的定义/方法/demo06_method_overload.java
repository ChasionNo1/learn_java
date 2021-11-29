package day03_review.demo03_面向对象.类的定义.方法;

import java.util.Arrays;

/*
* 定义三个重载方法max()，第一个方法求两个int值中的最大值，第二个方
法求两个double值中的最大值，第三个方法求三个double值中的最大值，
并分别调用三个方法。
* */
public class demo06_method_overload {
    public static void main(String[] args) {
        max(1, 3);
        max(10.7, 2.0);
        max(2.3, 6.3, 5.2);
    }

    public static void max(int x, int y) {
        System.out.println(Math.max(x, y));
    }

    public static void max(double x, double y) {
        System.out.println(Math.max(x, y));
    }

    public static void max(double x, double y, double z) {
        double[] arr = {x, y, z};
        Arrays.sort(arr);
        System.out.println(arr[2]);
    }
}
