package day01_review.demo01数据类型;

public class Demo03_Notes {
    public static void main(String[] args) {
        // -128 ~ 127   -128 -127 -126
        //               128  129  130
        // 溢出后从最小的值开始
        byte b = (byte)130;
        System.out.println(b);  //-126
    }
}
