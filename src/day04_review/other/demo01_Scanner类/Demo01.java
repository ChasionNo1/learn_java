package day04_review.other.demo01_Scanner类;

import java.util.Scanner;
/*
Scanner类：

* */
public class Demo01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入一个整数");
        int i = scanner.nextInt();
        System.out.println("i:" + i);
    }


}
