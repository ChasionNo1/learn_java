package day04_review.demo03_Random类;

import java.util.Random;
import java.util.Scanner;

/*
* 猜数字小游戏
* 游戏开始时，会随机生成一个1-100之间的整数number，玩家猜测一个数字guessNumber，会与number作比较，
* 系统提示打了还是小了，直到玩家猜中，游戏结束。
* */
public class Demo02 {
    public static void main(String[] args) {
        Random random = new Random();
        int number = random.nextInt(100) + 1;

        while (true){
            int guess = guessNumber();
            if (guess > number){
                System.out.println("猜大了");
            }else if(guess < number){
                System.out.println("猜小了");
            }else {
                System.out.println("猜对了");
                break;
            }
        }
    }
    public static int guessNumber(){
        int guessNumber;
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入猜测的数字：");
        guessNumber = scanner.nextInt();
        return guessNumber;
    }

}
