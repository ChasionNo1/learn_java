package day03_review.demo03_面向对象.面向对象上.类的定义.方法;

public class demo05_method_overload {
    public static void main(String[] args) {
        mOL(2);
        mOL(2, 3);
        mOL("12345");

    }
    public static void mOL(int x){
        System.out.println(x*x);
    }
    public static void mOL(int x, int y){
        System.out.println(x * y);
    }
    public static void mOL(String s){
        System.out.println(s);
    }
}
