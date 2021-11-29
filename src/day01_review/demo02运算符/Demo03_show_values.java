package day01_review.demo02运算符;

import java.util.Scanner;

/*
* 随意给出一个整数，打印显示它的个位数，十位数，百位数的值。
    格式如下：
* */
public class Demo03_show_values {
    public static void main(String[] args) {
        System.out.println("输入三位数：");
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int g,s,b;
        b = x / 100;
        s = x / 10;
        s = s - b*10;
        g = x - b * 100 - s * 10;
        System.out.println("百位：" + b);
        System.out.println("十位：" + s);
        System.out.println("个位：" + g);
    }
}
