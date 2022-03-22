package leetcode.二叉树;

import java.util.LinkedList;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-03-21 11:10
 *
 * 二叉搜索树的最小绝对差
 *
 * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 *
 * 差值是一个正数，其数值等于两值之差的绝对值。
 */
public class Demo530 {
    TreeNode pre;
    int minVal = Integer.MAX_VALUE;
    LinkedList<TreeNode> stack;


    public int getMinimumDifference(TreeNode root) {
        if (root == null){
            return 0;
        }
        traversal(root);
        return minVal;

    }

    private void traversal(TreeNode root){
        if (root == null){
            return;
        }
        traversal(root.left);
        if (pre != null && root.val - pre.val < minVal){
            minVal = root.val - pre.val;
        }
        pre = root;
        traversal(root.right);

    }

    // 迭代
    public int getMinimumDifference1(TreeNode root) {
        if (root == null){
            return 0;
        }
        stack = new LinkedList<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()){
            if (cur != null){
                // 左
                stack.addLast(cur);
                cur = cur.left;
            }else {
                cur = stack.removeLast();
                // 中
                if (pre != null){
                    minVal = Math.min(minVal, cur.val - pre.val);
                }
                // 右
                pre = cur;
                cur = cur.right;
            }

        }
        return minVal;
    }
}
