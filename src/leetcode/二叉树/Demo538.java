package leetcode.二叉树;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-03-22 10:44
 *
 * 把二叉搜索树转换为累加树
 */
public class Demo538 {
    int sum;

    public TreeNode convertBST(TreeNode root) {
        // 右中左遍历
        sum = 0;
        traversal(root);
        return root;



    }
    private void traversal(TreeNode root){
        if (root == null){
            return;
        }
        traversal(root.right);
        // 为啥下面这个不对？sum没有变化，没有累加
//        root.val += sum;
        sum += root.val;
        root.val = sum;
        traversal(root.left);
    }
}
