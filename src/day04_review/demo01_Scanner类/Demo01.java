package day04_review.demo01_Scanner类;
import jdk.nashorn.internal.ir.CallNode;

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
