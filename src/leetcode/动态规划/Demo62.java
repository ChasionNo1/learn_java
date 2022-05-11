package leetcode.动态规划;

/**
 * @ClassName Demo62
 * @Description TODO
 * @Author chasion
 * @Date 2022/5/11 15:00
 *
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 *
 * 问总共有多少条不同的路径？
 *
 */
public class Demo62 {

    public int uniquePaths(int m, int n) {

        if (m == 1 || n == 1){
            return 1;
        }
        // 与出发节点，同行同列，初始化为1
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        // 层，从左到右遍历
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];




    }
}
