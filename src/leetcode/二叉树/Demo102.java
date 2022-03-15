package leetcode.二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-03-15 10:52
 * <p>
 * 二叉树的层序遍历
 */
public class Demo102 {
    public static void main(String[] args) {
        Demo102 demo = new Demo102();
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        root.right = node1;
        node1.left = node2;
        List<List<Integer>> lists = demo.levelOrder(root);
        for (List<Integer> list :
                lists) {
            System.out.println(list);
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            ArrayList<Integer> itemList = new ArrayList<>();
            int len = queue.size();

            while (len > 0) {
                TreeNode tmpNode = queue.poll();
                itemList.add(tmpNode.val);
                if (tmpNode.left != null) {
                    queue.offer(tmpNode.left);
                }
                if (tmpNode.right != null) {
                    queue.offer(tmpNode.right);
                }
                --len;
            }
            list.add(itemList);
        }

        return list;
    }
}
