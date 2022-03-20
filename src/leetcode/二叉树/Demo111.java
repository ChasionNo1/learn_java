package leetcode.二叉树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-03-16 10:04
 *
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明：叶子节点是指没有子节点的节点。
 */
public class Demo111 {

    public int minDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            ++depth;
            while (size > 0) {
                TreeNode temp = queue.poll();
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
                if (temp.left == null && temp.right == null){
                    return depth;
                }
                --size;
            }

        }
        return depth;

    }

    /**
     * 递归方法：最小深度是从根节点到最近叶子节点的最短路径上的节点数量
     * @param root:
     * @return: int
     **/
    public int minDepth1(TreeNode root) {
        if (root == null){
            return 0;
        }
        int leftDepth = minDepth1(root.left);
        int rightDepth = minDepth1(root.right);
        // 当一个左子树为空，右不为空，这时并不是最低点
        if (root.left == null && root.right != null){
            return 1 + rightDepth;
        }
        // 当一个右子树为空，左不为空，这时并不是最低点
        if (root.left != null && root.right == null){
            return 1 + leftDepth;
        }
        int result = 1 + Math.min(leftDepth, rightDepth);
        return result;

    }
}
