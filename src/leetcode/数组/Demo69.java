package leetcode.数组;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-03-05 16:43
 *
 * 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
 *
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 */
public class Demo69 {
    public static void main(String[] args) {
        Demo69 demo = new Demo69();
        int i = demo.mySqrt(0);
        System.out.println(i);
    }

    public int mySqrt(int x){
        int start = 0, end = x;
        while (start <= end){
            int mid = (start + end) / 2;
            long result = (long) mid * mid;
            if (result > x){
                end = mid - 1;
            }else if (result < x){
                start = mid + 1;
            }else {
                return mid;
            }
            // 考虑越界
//            if ((long) mid * mid <= x){
//                start = mid + 1;
//            }else {
//                end = mid - 1;
//            }
        }
        return end;
    }
}
