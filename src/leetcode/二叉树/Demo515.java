package leetcode.二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-03-15 19:55
 *
 * 给定一棵二叉树的根节点 root ，请找出该二叉树中每一层的最大值。
 */
public class Demo515 {

    public List<Integer> largestValues(TreeNode root) {
        // 存放结果的list
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        // 节点队列
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            // 记录每一层的节点个数
            int len = queue.size();
            int max = Integer.MIN_VALUE;
            while (len > 0) {
                TreeNode temp = queue.poll();
                if (temp.val > max){
                    max = temp.val;
                }
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
                --len;
            }
            list.add(max);

        }
        return list;

    }
}
