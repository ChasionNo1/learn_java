package leetcode.二叉树;

import 数据结构与算法.树.递归.Tree;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-03-19 13:32
 *
 * 给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历，
 * postorder 是同一棵树的后序遍历，请你构造并返回这颗二叉树。
 *
 */
public class Demo106 {


    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return bt(inorder, 0, inorder.length, postorder, 0, postorder.length);


    }

    public TreeNode bt(int[] inorder, int inLeft, int inRight, int[] postorder, int postLeft, int postRight){
        // 没有元素了，数组为空
        if (inRight - inLeft < 1){
            return null;
        }
        // 数组只有一个元素，就成一个节点的树
        if (inRight - inLeft == 1){
            return new TreeNode(inorder[inLeft]);
        }

        // 取后序数组的最后一个元素作为根节点
        int rootVal = postorder[postRight - 1];
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = 0;
        // 根据根结点的值找到该值在中序数组inorder里的位置
        for (int i = inLeft; i < inRight; i++) {
            if (inorder[i] == rootVal){
                rootIndex = i;
                break;
            }
        }
        // 根据rootIndex划分左右子树
        root.left = bt(inorder, inLeft, rootIndex, postorder, postLeft, postLeft + (rootIndex - inLeft));
        root.right = bt(inorder, rootIndex + 1, inRight, postorder, postLeft + (rootIndex - inLeft), postRight - 1);
        return root;

    }
}
