package leetcode.动态规划;

/**
 * @ClassName Demo474
 * @Description TODO
 * @Author chasion
 * @Date 2022/5/18 11:05
 *
 * 给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
 *
 * 请你找出并返回 strs 的最大子集的长度，该子集中 最多 有 m 个 0 和 n 个 1 。
 *
 * 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。
 *
 */
public class Demo474 {

    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        int oneNum, zeroNum;
        // 外层遍历是字符串
        for (String str :
                strs) {
            oneNum = 0;
            zeroNum = 0;
            for (char ch :
                    str.toCharArray()) {
                if (ch == '0') {
                    zeroNum++;
                }else {
                    oneNum++;
                }
            }

            // 倒序遍历
            for (int i = m; i >= zeroNum; i--) {
                for (int j = n; j >= oneNum; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeroNum][j - oneNum] + 1);
                }
            }
        }
        return dp[m][n];
    }
}
