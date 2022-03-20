package leetcode.二叉树;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-03-17 09:37
 *
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 */
public class Demo110 {

    public boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;


    }

    public int getHeight(TreeNode root){
        if (root == null){
            return 0;
        }
        int leftHeight = getHeight(root.left);
        if (leftHeight == -1){
            return -1;
        }
        int rightHeight = getHeight(root.right);
        if (rightHeight == -1){
            return -1;
        }
        // 如果两个树高度相差大于1，则返回-1表示不是平衡二叉树
        if (Math.abs(leftHeight - rightHeight) > 1){
            return -1;
        }
        // 返回root的高度
        return Math.max(leftHeight, rightHeight) + 1;

    }
}
