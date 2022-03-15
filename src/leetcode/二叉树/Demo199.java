package leetcode.二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-03-15 15:11
 *
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 */
public class Demo199 {

    public List<Integer> rightSideView(TreeNode root) {
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
            while (len > 0) {
                TreeNode temp = queue.poll();
                if (len == 1){
                    list.add(temp.val);
                }
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
                --len;
            }
        }
        return list;
    }
}
