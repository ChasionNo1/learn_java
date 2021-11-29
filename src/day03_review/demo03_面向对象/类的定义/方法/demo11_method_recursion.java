package day03_review.demo03_面向对象.类的定义.方法;
/*
* 递归方法：一个方法体内调用它自身。
*方法递归包含了一种隐式的循环，它会重复执行某段代码，但这种重复执
行无须循环控制。
递归一定要向已知方向递归，否则这种递归就变成了无穷递归，类似于死
循环。

* */
public class demo11_method_recursion {
    public static void main(String[] args) {
        int sum = getSum(100);
        System.out.println(sum);
        System.out.println(factorial(10));
    }
    public static int getSum(int num){
        if (num == 1){
            return 1;
        }else
            return num + getSum(num - 1);
    }
    public static int factorial(int n){
        if (n == 1){
            return 1;
        }else
            return n * factorial(n -1);
    }
}
