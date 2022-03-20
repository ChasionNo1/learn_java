package leetcode.二叉树;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-03-18 12:35
 * <p>
 * 给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
 * 假设二叉树中至少有一个节点。
 */
public class Demo513 {
    // 记录树的最大深度，以及要返回的最左边节点的值
    private int Deep = -1;
    private int value = 0;

    public int findBottomLeftValue(TreeNode root) {
        value = root.val;
        findLeftValue(root, 0);
        return value;
    }

    private void findLeftValue(TreeNode root, int deep) {
        // 前序遍历
        // 这地方的判断是多余的，如果当前节点是叶子节点，左右子节点为空，不会进入下一个递归，也就没有root == null 的情况
        // 而应该是处理当前叶子节点后，返回
//        if (root == null){
//            return;
//        }
        // 到达每一层时，更新第一个左子节点
        if (root.left == null && root.right == null) {
            if (deep > Deep) {
                Deep = deep;
                value = root.val;
            }
            return;
        }
        if (root.left != null) {
            // 这里有回溯，deep + 1，每一层deep值是不同的，回到上一层就是对应的deep值
            // 相当于以下三步操作
//            ++deep;
//            findLeftValue(root.left, deep);
//            --deep;

            findLeftValue(root.left, deep + 1);
        }
        if (root.right != null) {
            findLeftValue(root.right, deep + 1);
        }
    }

    // 使用层序遍历，每一层第一个添加的元素
    public int findBottomLeftValue1(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int res = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            int flag = queue.size();
            while (size > 0){
                TreeNode node = queue.poll();
                // 第一个节点
                if (size == flag){
                    res = root.val;
                }
                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
                --size;
            }
        }
        return res;

    }

}
