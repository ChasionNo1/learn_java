package leetcode.斐波那契;


/**
 * @program: test
 * @author: chasion
 * @create: 2022-03-03 10:24
 */
public class Solution1 {
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        int fib = solution1.fib(44);
        System.out.println(fib);
    }

    public int fib(int n) {
        if (n == 0){
            return 0;
        }else if (n == 1){
            return 1;
        }else{
            return fib(n - 1) + fib(n - 2);
        }
    }
}


