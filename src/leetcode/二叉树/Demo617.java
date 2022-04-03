package leetcode.二叉树;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-03-20 16:06
 *
 * 合并二叉树
 *
 */
public class Demo617 {

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null){
            return root1;
        }
        if (root1 == null && root2 != null){
            return root2;
        }
        if (root1 != null && root2 == null){
            return root1;
        }

        int val1 = root1.val;
        int val2 = root2.val;
        TreeNode newRoot = new TreeNode(val1 + val2);

        newRoot.left = mergeTrees(root1.left, root2.left);
        newRoot.right = mergeTrees(root1.right, root2.right);
        return newRoot;


    }
}
