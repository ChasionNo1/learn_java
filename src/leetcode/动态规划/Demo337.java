package leetcode.动态规划;

/**
 * @ClassName Demo337
 * @Description TODO
 * @Author chasion
 * @Date 2022/5/25 10:35
 *
 * 小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为root。
 *
 * 除了root之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，
 * 聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果 两个直接相连的房子在同一天晚上被打劫 ，房屋将自动报警。
 *
 * 给定二叉树的root。返回在不触动警报的情况下，小偷能够盗取的最高金额。
 *
 */
public class Demo337 {

    public int rob(TreeNode root) {
        int[] dp = robAction(root);
        return Math.max(dp[0], dp[1]);

    }

    int[] robAction(TreeNode root){
        int[] dp = new int[2];
        if (root == null){
            return dp;
        }
        // 后序遍历
        int[] left = robAction(root.left);
        int[] right = robAction(root.right);
        // 不偷
        dp[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        // 偷
        dp[1] = root.val + left[0] + right[0];
        return dp;
    }
}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
