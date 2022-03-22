package leetcode.二叉树;

import java.util.ArrayList;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-03-21 09:22
 *
 * 验证二叉搜索树
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 *
 * 有效 二叉搜索树定义如下：
 *
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 *
 */
public class Demo98 {
    ArrayList<Integer> list = new ArrayList<>();
    TreeNode pre;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(3);
        root.left = node1;
        root.right = node2;
        Demo98 demo = new Demo98();
        boolean b = demo.isValidBST(root);
        System.out.println(b);
    }

    public boolean isValidBST(TreeNode root) {
        infixOrder(root);
        if (list.size() == 1){
            return true;
        }
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) <= list.get(i - 1)){
                return false;
            }
        }
        return true;



    }
    public void infixOrder(TreeNode root){
        if (root == null){
            return;
        }
        infixOrder(root.left);
        int value = root.val;
        list.add(value);
        infixOrder(root.right);
    }

    /**
     * 在递归过程中进行比较
     * @param root:
     * @return: boolean
     **/
    public boolean isValidBST1(TreeNode root) {
        // 如果搜索二叉树为空满足，如果左子节点为空，一定小于根节点，满足
        if (root == null){
            return true;
        }

        // 左
        // 如果left为false
        boolean left = isValidBST1(root.left);
        if (!left){
            return false;
        }
        // 和前一个节点进行比较
        if (pre != null && root.val <= pre.val){
            return false;
        }

        pre = root;
        boolean right = isValidBST1(root.right);
        return right;
    }
}
