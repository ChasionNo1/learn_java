package leetcode.贪心;

/**
 * @ClassName Demo738
 * @Description TODO
 * @Author chasion
 * @Date 2022/4/14 16:47
 *
 * 当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。
 *
 * 给定一个整数 n ，返回 小于或等于 n 的最大数字，且数字呈 单调递增 。
 *
 */
public class Demo738 {

    public int monotoneIncreasingDigits(int n) {
        // 将n转为字符数组处理
        String s = String.valueOf(n);
        char[] chars = s.toCharArray();
        int start = chars.length;
        // 从后往前遍历，比较是否满足递增
        for (int i = chars.length - 2; i >= 0; i--) {
            // 如果不满足，则当前数字减一，后一个数字变成9
            if (chars[i] > chars[i + 1]){
                chars[i]--;
                // 更新变成9开始的位置
                start = i + 1;
            }
        }
        for (int i = start; i < chars.length; i++) {
            chars[i] = '9';
        }
        return Integer.parseInt(String.valueOf(chars));



    }
}
