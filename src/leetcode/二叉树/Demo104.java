package leetcode.二叉树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-03-16 09:59
 * <p>
 * 给定一个二叉树，找出其最大深度。
 * <p>
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 */
public class Demo104 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode temp = queue.poll();
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
                --size;
            }
            ++depth;
        }
        return depth;

    }

    /**
     * 递归方法，前序遍历是求树的深度，后序遍历求的是高度，对根节点后序遍历得到的是深度
     * @param root:
     * @return: int
     **/
    public int maxDepth1(TreeNode root) {
        if (root == null){
            return 0;
        }
        // 后序遍历
        int leftDepth = maxDepth1(root.left);
        int rightDepth = maxDepth1(root.right);
        int max = 1 + Math.max(leftDepth, rightDepth);
        return max;

    }


}
