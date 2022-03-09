package leetcode.数组;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-03-05 20:30
 *
 * 给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
 *
 * 进阶：不要 使用任何内置的库函数，如 sqrt 。
 *
 */
public class Demo367 {
    public static void main(String[] args) {
        Demo367 demo = new Demo367();
        boolean result = demo.isPerfectSquare(17);
        System.out.println(result);
    }

    public boolean isPerfectSquare(int num) {
        int start = 0, end = num;
        while (start <= end){
            int mid = (start + end) / 2;
            long result = (long) mid * mid;
            if (result > num){
                end = mid - 1;
            }else if (result < num){
                start = mid + 1;
            }else {
                return true;
            }
            // 考虑越界
//            if ((long) mid * mid <= x){
//                start = mid + 1;
//            }else {
//                end = mid - 1;
//            }
        }
        return false;

    }

}
