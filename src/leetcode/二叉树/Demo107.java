package leetcode.二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-03-15 14:34
 * <p>
 * 给你二叉树的根节点 root ，返回其节点值 自底向上的层序遍历 。
 * （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 */
public class Demo107 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        root.right = node1;
        node1.left = node2;
        Demo107 demo = new Demo107();
        List<List<Integer>> lists = demo.levelOrderBottom(root);
        for (List<Integer> list :
                lists) {
            System.out.println(list);
        }
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        // 存放结果的list
        ArrayList<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        // 节点队列
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            // 记录每一层的节点个数
            int len = queue.size();
            // 存放每个节点的值
            ArrayList<Integer> item = new ArrayList<>();
            while (len > 0) {
                TreeNode temp = queue.poll();
                item.add(temp.val);
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
                --len;
            }
            list.add(item);
        }
        // 反转列表
        for (int i = 0, j = list.size() - 1; i < j; i++, j--) {
            List<Integer> temp = list.get(i);
            list.set(i, list.get(j));
            list.set(j, temp);
        }

        return list;
    }
}
