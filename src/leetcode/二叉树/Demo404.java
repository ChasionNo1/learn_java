package leetcode.二叉树;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-03-18 09:26
 *
 * 给定二叉树的根节点 root ，返回所有左叶子之和。
 */
public class Demo404 {

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null){
            return 0;
        }
        // 后序遍历
        // 左
        int left = sumOfLeftLeaves(root.left);
        // 右
        int right = sumOfLeftLeaves(root.right);
        // 中
        int mid = 0;
        if (root.left != null &&  root.left.left == null && root.left.right == null){
            mid = root.left.val;
        }
        int sum = left + right + mid;
        return sum;

    }
}
