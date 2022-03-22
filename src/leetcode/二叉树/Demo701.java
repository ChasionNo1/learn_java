package leetcode.二叉树;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-03-21 20:21
 *
 * 二叉搜索树中的插入操作
 */
public class Demo701 {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null){
            return new TreeNode(val);
        }
        TreeNode newRoot = root;
        TreeNode pre = root;
        while (root != null){
            pre = root;
            if (root.val > val){
                root = root.left;
            }else if (root.val < val){
                root = root.right;
            }
        }
        if (pre.val > val){
            pre.left = new TreeNode(val);
        }else {
            pre.right = new TreeNode(val);
        }
        return newRoot;
    }

    // 递归
    public TreeNode insertIntoBST1(TreeNode root, int val) {
        if (root == null){
            return new TreeNode(val);
        }
        if (root.val > val){
            // 插在左节点上
            root.left = insertIntoBST1(root.left, val);
        }else if (root.val < val){
            root.left = insertIntoBST1(root.right, val);
        }
        return root;
    }
}
