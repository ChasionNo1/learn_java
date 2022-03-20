package leetcode.二叉树;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-03-18 19:08
 *
 * 给你二叉树的根节点root 和一个表示目标和的整数targetSum 。
 * 判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和targetSum 。
 * 如果存在，返回 true ；否则，返回 false 。
 *
 */
public class Demo112 {
    int sum = 0;

    public static void main(String[] args) {
        Demo112 demo = new Demo112();
        TreeNode root = new TreeNode(1);
        TreeNode node = new TreeNode(2);
        TreeNode node1 = new TreeNode(3);
        root.left = node;
        root.right = node1;
        boolean b = demo.hasPathSum(root, 3);
        System.out.println(b);

    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null){
            return false;
        }

        // 前序遍历
        sum += root.val;
//        System.out.println(sum);
        if (root.left == null && root.right == null){
            // 叶子节点
//            sum += root.val;
            System.out.println(sum);
            if (sum == targetSum){
                return true;
            }
        }

        if (root.left != null){
            boolean b = hasPathSum(root.left, targetSum);
            if (b){
                return true;
            }
            sum -= root.left.val;
        }

        if (root.right != null){
            boolean b = hasPathSum(root.right, targetSum);
            if (b){
                return true;
            }
            sum -= root.right.val;
        }
        return false;

    }
}
