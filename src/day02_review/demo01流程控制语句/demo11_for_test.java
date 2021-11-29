package day02_review.demo01流程控制语句;

import java.util.Scanner;

// 输入两个正整数m和n，求其最大公约数和最小公倍数。
/*
* 求最大公约数有两种方法 更相减损法和辗转相处法 最小公倍数在求出最大公约数后 两个数相乘除以最大公约数就是最小公倍数
* */
public class demo11_for_test {
    public static void main(String[] args) {
        System.out.println("输入两个数");
        int num1, num2;
        Scanner scanner = new Scanner(System.in);
        num1 = scanner.nextInt();
        num2 = scanner.nextInt();
        getValue(num1, num2);
    }

    public static void getValue(int a, int b) {
        // 获取a，b中最大的数
        int max = Math.max(a, b);
        int gy = 0;
        for (int i = 1; i <= max; i++) {
            if (a % i == 0 & b % i == 0) {
                gy = i;
            }
        }
        int gb;
        gb = a * b / gy;
        System.out.println("最大公约数：" + gy + ", 最小公倍数：" + gb);

    }
}
