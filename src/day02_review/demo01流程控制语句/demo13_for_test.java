package day02_review.demo01流程控制语句;
//输出所有的水仙花数，所谓水仙花数是指一个3位数，其各个位上数
//字立方和等于其本身
public class demo13_for_test {
    public static void main(String[] args) {
        for (int i=100; i<1000; i++){
            int b = i / 100;
            int s = (i - 100 * b) / 10;
            int g = i - 100 * b - 10 * s;
            int num = b*b*b + s*s*s + g*g*g;
            if (num == i){
                System.out.println(i);
            }
        }
    }
}
