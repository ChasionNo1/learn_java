package leetcode.二叉树;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-03-21 14:33
 * <p>
 * 二叉搜索树中的众数
 * 给你一个含重复值的二叉搜索树（BST）的根节点 root ，找出并返回 BST 中的所有 众数（即，出现频率最高的元素）。
 * <p>
 * 如果树中有不止一个众数，可以按 任意顺序 返回。
 * <p>
 * 假定 BST 满足如下定义：
 * <p>
 * 结点左子树中所含节点的值 小于等于 当前节点的值
 * 结点右子树中所含节点的值 大于等于 当前节点的值
 * 左子树和右子树都是二叉搜索树
 */
public class Demo501 {
    int max_f;
    int count;
    TreeNode pre;
    ArrayList<Integer> res;

    public static void main(String[] args) {
        Demo501 demo = new Demo501();
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(2);
        root.left = node1;
        root.right = node2;
        node2.left = node3;
        int[] res = demo.findMode1(root);
        System.out.println(Arrays.toString(res));
    }

    public int[] findMode(TreeNode root) {
        res = new ArrayList<>();
        max_f = 0;
        count = 0;
        pre = null;

        traversal(root);
        int[] arr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            arr[i] = res.get(i);
        }
        return arr;


    }

    private void traversal(TreeNode root) {
        if (root == null) {
            return;
        }
        traversal(root.left);
        if (pre == null || root.val != pre.val){
            // 当为第一个节点，或者当前节点和之前节点不相等时
            // 都出现1次
            count = 1;
        }else {
            count++;
        }

        if (count > max_f){
            max_f = count;
            res.clear();
            res.add(root.val);
        }else if (count == max_f){
            res.add(root.val);
        }
        pre = root;

        traversal(root.right);

    }

    // 迭代
    public int[] findMode1(TreeNode root) {
        int count = 0;
        int max_count = 0;
        LinkedList<TreeNode> stack = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        TreeNode pre = null;
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()){
            // 处理只出现一次的情况
            if (cur != null){
                stack.addLast(cur);
                cur = cur.left;
            }else {
                cur = stack.removeLast();
                // 如果只出现一次
                if (pre == null || cur.val != pre.val){
                    count = 1;
                }else {
                    count++;
                }

                if(max_count < count){
                    max_count = count;
                    list.clear();
                    list.add(cur.val);
                }else if (count == max_count){
                    list.add(cur.val);
                }
                pre = cur;
                cur = cur.right;
            }
        }

        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }
}
