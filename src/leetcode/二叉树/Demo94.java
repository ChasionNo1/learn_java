package leetcode.二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-03-15 09:02
 * <p>
 * 中序遍历
 */
public class Demo94 {

    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        } else {
            inOrderIndex(root, list);
        }
        return list;

    }

    public void inOrderIndex(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inOrderIndex(root.left, list);
        list.add(root.val);
        inOrderIndex(root.right, list);

    }

    public List<Integer> inorderTraversal1(TreeNode root) {
        // 迭代法
//        中序遍历顺序: 左-中-右 入栈顺序： 左-右
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                // 继续向下找左子树
                stack.addLast(cur);
                cur = cur.left;
            } else {
                // 到底了，弹出左节点，将指针指向右节点，右节点为空，会再次到这里，
                // 然后再弹出一个节点，是倒数第二个左节点，然后指针指向该节点的右节点
                cur = stack.removeLast();
                list.add(cur.val);
                cur = cur.right;
            }
        }
        return list;

    }
}
