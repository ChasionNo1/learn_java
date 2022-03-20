package leetcode.二叉树;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-03-16 10:11
 *
 * 翻转二叉树
 *
 */
public class Demo226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null){
            return root;
        }
        // 前序遍历
        swap(root);
        invertTree(root.left);
        invertTree(root.right);
        return root;

    }
    public void swap(TreeNode root){
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}
