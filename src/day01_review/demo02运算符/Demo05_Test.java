package day01_review.demo02运算符;

public class Demo05_Test {
    public static void main(String[] args) {
        int x =1, y = 1;
        if (x++ == 1 | ++y == 1){
            x = 7;
        }
        System.out.println("x = " + x + ", y = " + y);
    }
}
