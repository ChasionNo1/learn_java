package leetcode.动态规划;

import java.util.Arrays;

/**
 * @ClassName Demo1049
 * @Description TODO
 * @Author chasion
 * @Date 2022/5/17 9:44
 */
public class Demo1049 {
    public static void main(String[] args) {
        Demo1049 demo = new Demo1049();
        int[] stones = {31, 26, 33, 21, 40};
        int res = demo.lastStoneWeightII(stones);
        System.out.println(res);
    }

    public int lastStoneWeightII(int[] stones) {
        int sum = Arrays.stream(stones).sum();
        int target = sum / 2;
        int[] dp = new int[target + 1];
        for (int i = 0; i < stones.length; i++) {
            for (int j = target; j >= stones[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }
        System.out.println(Arrays.toString(dp));
        return sum - 2 * dp[target];


    }
}
