package leetcode.二叉树;


import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-03-16 10:54
 * <p>
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 */
public class Demo101 {

    public boolean isSymmetric(TreeNode root) {
        return compare(root.left, root.right);


    }

    private boolean compare(TreeNode left, TreeNode right){
        if (left == null && right != null) return false;
        if (left != null && right == null) return false;
        if (left == null && right == null) return true;
        if (left.val != right.val){
            return false;
        }
        boolean compareOutside = compare(left.left, right.right);
        boolean compareInside = compare(left.right, right.left);
        return compareOutside && compareInside;


    }

    public boolean isSymmetric1(TreeNode root) {
        // 双端队列
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerFirst(root.left);
        deque.offerLast(root.right);
        while (!deque.isEmpty()){
            TreeNode leftNode = deque.pollFirst();
            TreeNode rightNode = deque.pollLast();
            // 判断这两个节点是否相等
            if (leftNode == null && rightNode == null){
                continue;
            }
            if (leftNode == null || rightNode == null || leftNode.val != rightNode.val){
                return false;
            }

            // 接着进入队列，根据比较关系添加，镜像
            deque.offerFirst(leftNode.left);
            deque.offerFirst(leftNode.right);
            deque.offerLast(rightNode.right);
            deque.offerLast(rightNode.left);
        }
        return true;
    }


}
