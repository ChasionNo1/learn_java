package day02_review.demo01流程控制语句;

import java.util.Arrays;
import java.util.Scanner;

/*
* 假设你想开发一个玩彩票的游戏，程序随机地产生一个两位数的彩票，提示用户输入
一个两位数，然后按照下面的规则判定用户是否能赢。
1)如果用户输入的数匹配彩票的实际顺序，奖金10 000美元。
2)如果用户输入的所有数字匹配彩票的所有数字，但顺序不一致，奖金 3 000美元。
3)如果用户输入的一个数字仅满足顺序情况下匹配彩票的一个数字，奖金1 000美元。
4)如果用户输入的一个数字仅满足非顺序情况下匹配彩票的一个数字，奖金500美元。
5)如果用户输入的数字没有匹配任何一个数字，则彩票作废。
* */
public class demo08_if_test {
    public static void main(String[] args) {
        System.out.println("输入一个两位数：");
        int buy;
        Scanner scanner = new Scanner(System.in);
        buy = scanner.nextInt();
        int[] a = new int[2];
        a[0] = buy/10;
        a[1] = buy%10;
        judgeResult(a);
    }

    public static void judgeResult(int[] buy){
        int origin;
        origin = (int)(Math.random()*90+10);
        int[] b = new int[2];
        b[1] = origin%10;
        b[0] = origin/10;
        // 完全一样
        if (Arrays.equals(buy, b)){
            System.out.println("10000$");
        }else if (buy[0] == b[1] & buy[1] == b[0]){
            System.out.println("3000$");
        }else if (buy[0] == b[0] | buy[1] == b[1]){
            System.out.println("1000$");
        }else if (buy[0] == b[1] | buy[1] == b[0]){
            System.out.println("500$");
        }else {
            System.out.println("none");
        }
    }
}
