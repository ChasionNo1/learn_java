package leetcode.二叉树;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-03-20 16:34
 */
public class Demo700 {


    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null){
            return root;
        }
        if (root.val == val){
            return root;
        }

        if (root.val > val){
            return searchBST(root.left, val);
        }
        if (root.val < val){
            return searchBST(root.right, val);
        }
        return null;
    }
}
