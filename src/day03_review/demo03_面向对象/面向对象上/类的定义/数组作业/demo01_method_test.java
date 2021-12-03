package day03_review.demo03_面向对象.面向对象上.类的定义.数组作业;

/*
* 编写程序，声明一个method方法，在方法中打印一个10*8 的*型矩形，
    在main方法中调用该方法。
* */
public class demo01_method_test {
    public static void main(String[] args) {
        int s = printRectangle(10, 8);
        System.out.println("面积为：" + s);

    }

    public static int printRectangle(int l, int w) {
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < w; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        return l * w;
    }
}
