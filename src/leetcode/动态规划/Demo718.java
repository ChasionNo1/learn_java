package leetcode.动态规划;

/**
 * @ClassName Demo718
 * @Description TODO
 * @Author chasion
 * @Date 2022/6/1 9:59
 *
 * 给两个整数数组 nums1 和 nums2 ，返回 两个数组中 公共的 、长度最长的子数组的长度 。
 */
public class Demo718 {
    public static void main(String[] args) {
        Demo718 demo = new Demo718();
        int[] A = {1, 2, 3, 4, 7};
        int[] B = {1, 3, 4, 2, 6};
        int res = demo.findLength(A, B);
        System.out.println(res);
    }

//    public int findLength(int[] A, int[] B) {
//        int n = A.length, m = B.length;
//        int[][] dp = new int[n + 1][m + 1];
//        int ans = 0;
//        for (int i = n - 1; i >= 0; i--) {
//            for (int j = m - 1; j >= 0; j--) {
//                dp[i][j] = A[i] == B[j] ? dp[i + 1][j + 1] + 1 : 0;
//                ans = Math.max(ans, dp[i][j]);
//            }
//        }
//        return ans;
//
//    }

    public int findLength(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int[][] dp = new int[n + 1][m + 1];
        int res = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // 这两个数组下标是从0开始，所以要减一对齐
                if (nums1[i - 1] == nums2[j - 1]){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        return res;


    }
}
