package leetcode.二叉树;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-03-15 08:58
 *
 * 二叉树的后序遍历
 *
 */
public class Demo145 {
    public static void main(String[] args) {
        Demo145 demo = new Demo145();
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        root.right = node1;
        node1.left = node2;
        List<Integer> list = demo.postorderTraversal(root);
        System.out.println(list);
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null){
            return list;
        }else {
            postOrderIndex(root, list);
        }
        return list;

    }

    public void postOrderIndex(TreeNode root, List<Integer> list){
        if (root == null){
            return ;
        }
        postOrderIndex(root.left, list);
        postOrderIndex(root.right, list);
        list.add(root.val);
    }

    public List<Integer> postorderTraversal1(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null){
            return list;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.addLast(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.removeLast();
            list.add(node.val);
            if (node.left != null){
                stack.addLast(node.left);
            }
            if (node.right != null){
                stack.addLast(node.right);
            }
        }
        Collections.reverse(list);
        return list;
    }

}
