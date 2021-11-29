package day03_review.demo03_面向对象.类的定义.方法作业;
/*
* 已知有一个数列：f(0) = 1,f(1) = 4,f(n+2)=2*f(n+1) + f(n),其中n是大于0
的整数，求f(10)的值。
*
* 已知一个数列：f(20) = 1,f(21) = 4,f(n+2) = 2*f(n+1)+f(n),
其中n是大于0的整数，求f(10)的值。

*
* 输入一个数据n，计算斐波那契数列(Fibonacci)的第n个值
1 1 2 3 5 8 13 21 34 55
规律：一个数等于前两个数之和
要求：计算斐波那契数列(Fibonacci)的第n个值，并将整个数列打印出来
* */
public class demo01_recursion {
    public static void main(String[] args) {
        System.out.println(getValue1(10));
        System.out.println(getValue2(10));

        for (int i = 1; i <= 5; i++) {
            System.out.print(fibonacci(i) + " ");
        }
    }
    public static int getValue1(int n){
        if (n == 0){
            return 1;
        }else if (n == 1){
            return 4;
        }else
            return 2 * getValue1(n-1) + getValue1(n-2);
    }
    public static int getValue2(int n){
        // f(n+2) = 2 * f(n+1) + f(n)
        // f(n) = f(n+2)-2*f(n+1)
        if (n == 21){
            return 4;
        }else if(n==20){
            return 1;
        }else
            return getValue2(n+2)-2*getValue2(n+1);
    }
    public static int fibonacci(int n){
        // 1 1 2 3 5 8 13 21 34 55
        if (n == 1 | n == 2){
            return 1;
        }
        else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
}
