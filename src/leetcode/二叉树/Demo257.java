package leetcode.二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-03-17 10:15
 * <p>
 * 给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
 */
public class Demo257 {

    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        List<Integer> path = new ArrayList<>();
        traversal(root, path, res);
        return res;

    }


    /**
     * 前序遍历，递归，回溯
     *
     * @param root:
     * @param path: 记录遍历到的路径
     * @param res:  所有路径的字符串
     * @return: void
     **/
    private void traversal(TreeNode root, List<Integer> path, List<String> res) {
        // 中
        path.add(root.val);
        // 叶子节点，拼接路径
        if (root.left == null && root.right == null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < path.size() - 1; i++) {
                sb.append(path.get(i));
                sb.append("->");
            }
            // 最后一个没有箭头，特殊处理
            sb.append(path.get(path.size() - 1));
            // 一条路径添加到res中，
            res.add(sb.toString());
            // 递归终止
            return;
        }

        // 左
        if (root.left != null) {
            traversal(root.left, path, res);
            // 回溯，回到上一个节点
            path.remove(path.size() - 1);
        }

        // 右
        if (root.right != null) {
            traversal(root.right, path, res);
            path.remove(path.size() - 1);
        }
    }


    /**
     * 迭代法： 前序遍历
     * @param root:
     * @return: java.util.List<java.lang.String>
     **/
    public List<String> binaryTreePaths1(TreeNode root) {
        ArrayList<String> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        LinkedList<Object> stack = new LinkedList<>();
        // 将节点和路径都压入栈中
        stack.addLast(root);
        stack.addLast(root.val + "");
        while (!stack.isEmpty()){
            // 出栈
            String path = (String) stack.removeLast();
            TreeNode node = (TreeNode) stack.removeLast();
            // 处理叶子节点
            if (node.left == null && node.right == null){
                res.add(path);
            }
            // 右
            if (node.right != null){
                stack.addLast(node.right);
                stack.addLast(path + "->" + node.right.val);
            }
            // 左
            if (node.left != null){
                stack.addLast(node.left);
                stack.addLast(path + "->" + node.left.val);
            }

        }
        return res;
    }
}
