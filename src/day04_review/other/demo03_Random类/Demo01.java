package day04_review.other.demo03_Random类;

import java.util.Random;

/*
* java.util.Random()
*
* public int nextInt(int n):返回一个伪随机数，范围在0到n之间的int值
* */
public class Demo01 {
    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            int number = random.nextInt(10);
            System.out.println(number);
        }
    }
}
