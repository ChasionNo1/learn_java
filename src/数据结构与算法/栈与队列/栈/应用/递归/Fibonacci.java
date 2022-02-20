package 数据结构与算法.栈与队列.栈.应用.递归;

/**
 * @Description TODO
 * @Author chasion
 * @Date 2022/2/11 13:06
 **/
public class Fibonacci {
    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        int result = fibonacci.fib(10);
        System.out.println(result);
    }

    public int fib(int i){
        if (i == 0){
            return 0;
        }
        if (i == 1){
            return 1;
        }
        return fib(i -1) + fib(i - 2);
    }
}
