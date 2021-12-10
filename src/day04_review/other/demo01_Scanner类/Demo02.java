package day04_review.other.demo01_Scanner类;

import java.util.Scanner;

public class Demo02 {
    public static void main(String[] args) {
        System.out.println("请输入数字：");
        Scanner scanner = new Scanner(System.in);
        double sum = 0.0;
        int count = 0;
        double max = 0.0;
        while (scanner.hasNextDouble()) {
//          用泛型
            double x = scanner.nextDouble();
            count = count + 1;
            sum = sum + x;
            if( x > max){
                max = x;
            }
        }
        System.out.println("共有"+ count + "数据");
        System.out.println("平均值为：" + (sum/count));
        System.out.println("最大值为：" + max);
    }
}
