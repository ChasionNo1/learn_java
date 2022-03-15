package leetcode.二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-03-15 08:46
 * <p>
 * 二叉树的前序遍历
 */
public class Demo144 {
    public static void main(String[] args) {
        Demo144 demo = new Demo144();
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        root.right = node1;
        node1.left = node2;
        List<Integer> list = demo.preorderTraversal1(root);
        System.out.println(list);

    }

    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null){
            return list;
        }else {
            preOrderIndex(root, list);
        }
        return list;
    }

    public void preOrderIndex(TreeNode root, List<Integer> list){
        if (root == null){
            return ;
        }
        list.add(root.val);
        preOrderIndex(root.left, list);
        preOrderIndex(root.right, list);
    }

    // 迭代法
    public List<Integer> preorderTraversal1(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null){
            return list;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        // 先压入根节点，然后右节点，再左节点
        stack.offer(root);
        while (!stack.isEmpty()){
            // 弹出
            TreeNode node = stack.removeLast();
            list.add(node.val);
            // 先压入右节点
            if (node.right != null){
                stack.addLast(node.right);
            }
            // 再压入左节点
            if (node.left != null){
                stack.addLast(node.left);
            }
        }
        return list;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}