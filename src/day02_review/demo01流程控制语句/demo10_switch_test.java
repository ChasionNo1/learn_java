package day02_review.demo01流程控制语句;

import java.util.Scanner;

/*
* 编写程序：从键盘上输入2019年的“month”和“day”，要求通过程序,输出输入的日期为2019年的第几天。
* */
public class demo10_switch_test {
    public static void main(String[] args) {
        System.out.println("输入月份：");
        Scanner scanner = new Scanner(System.in);
        int month, day;
        month = scanner.nextInt();
        System.out.println("输入日子：");
        day = scanner.nextInt();
        int total = 0;
        switch (month){
            case 12:
                total += 31;
            case 11:
                total += 30;
            case 10:
                total += 31;
            case 9:
                total += 30;
            case 8:
                total += 31;
            case 7:
                total += 31;
            case 6:
                total += 30;
            case 5:
                total += 31;
            case 4:
                total += 30;
            case 3:
                total += 31;
            case 2:
                total += 28;
            case 1:
                total += 31;
        }
        System.out.println("今年的第:" + total + "天");

        
    }
}
