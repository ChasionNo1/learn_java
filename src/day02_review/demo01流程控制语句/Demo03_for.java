package day02_review.demo01流程控制语句;

public class Demo03_for {
    public static void main(String[] args) {
        printf(new int[]{1, 2, 3, 4});
    }
    public static void printf(int[] a){
        for (int value : a) {
            System.out.println(value);
        }
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
