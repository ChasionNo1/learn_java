package day02_review.demo01流程控制语句;

import java.util.Scanner;

//从键盘读入个数不确定的整数，并判断读入的正数和负数的个数，输入
//        为0时结束程序。
public class demo14_while_test {
    public static void main(String[] args) {
        int count_p = 0;
        int count_n = 0;
        while (true){
            int inputs;
            Scanner scanner = new Scanner(System.in);
            inputs = scanner.nextInt();
            if (inputs>0){
                count_p++;
            }else if(inputs<0){
                count_n++;
            }else
                break;
        }
        System.out.println("正数个数为：" + count_n);
        System.out.println("负数个数为：" + count_p);

    }
}
