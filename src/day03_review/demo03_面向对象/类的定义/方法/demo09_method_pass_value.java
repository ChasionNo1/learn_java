package day03_review.demo03_面向对象.类的定义.方法;

public class demo09_method_pass_value {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        method(a, b);
        System.out.println("a=" + a);
        System.out.println("b=" + b);
    }
    public static void method(int a, int b){
        // 没有返回值，影响不了实参
        a = 100;
        b = 200;
        System.out.println("a=" + a);
        System.out.println("b=" + b);
        System.exit(0);
    }
}
