package leetcode.二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-03-15 15:18
 *
 * 给定一个非空二叉树的根节点 root , 以数组的形式返回每一层节点的平均值。与实际答案相差 10-5 以内的答案可以被接受。
 */
public class Demo637 {
    public List<Double> averageOfLevels(TreeNode root) {
        // 存放结果的list
        ArrayList<Double> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        // 节点队列
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            // 记录每一层的节点个数
            int len = queue.size();
            int avg_len = queue.size();
            double sum = 0.0;
            while (len > 0) {
                TreeNode temp = queue.poll();
                sum += temp.val;
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
                --len;
            }
            list.add(sum / avg_len);

        }
        return list;

    }
}
