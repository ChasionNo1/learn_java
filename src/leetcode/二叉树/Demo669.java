package leetcode.二叉树;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-03-22 09:53
 *
 * 修剪二叉搜索树
 */
public class Demo669 {

    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null){
            return null;
        }
        // 如果当前节点小于low，那么就返回当前节点的右子树，（左子树和根节点一定小于，所以裁掉，右子树可能大于，返回）
        if (root.val < low){
            return trimBST(root.right, low, high);
        }
        // 同理
        if (root.val > high){
            return trimBST(root.left, low, high);
        }
        // 裁剪后的左右子树
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;

    }
}
