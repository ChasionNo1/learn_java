package day02_review.demo01流程控制语句;

import java.util.Scanner;

public class Demo05_if_test {
    public static void main(String[] args) {
        System.out.println("输入三个数：");
        Scanner sc = new Scanner(System.in);
        int num1,num2,num3,max;
        num1 = sc.nextInt();
        num2 = sc.nextInt();
        num3 = sc.nextInt();

        if (num1 > num2){
            if (num1 > num3){
                max = num1;
            }else {
                max = num3;
            }
        }else {
            if (num2 > num3){
                max = num2;
            }else {
                max = num3;
            }
        }
        System.out.println("max number=" + max);

    }
}
