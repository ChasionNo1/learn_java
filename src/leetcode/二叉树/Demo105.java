package leetcode.二叉树;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-03-19 18:34
 *
 * 从前序与中序遍历序列构造二叉树
 * 给定两个整数数组preorder 和 inorder，其中preorder 是二叉树的先序遍历，
 * inorder是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 *
 */
public class Demo105 {
    public static void main(String[] args) {
        Demo105 demo = new Demo105();
//        TreeNode root = new TreeNode(3);
//        TreeNode node1 = new TreeNode(9);
//        TreeNode node2 = new TreeNode(20);
//        TreeNode node3 = new TreeNode(15);
//        TreeNode node4 = new TreeNode(7);
//        root.left = node1;
//        root.right = node2;
//        node2.left = node3;
//        node2.right = node4;
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        TreeNode root = demo.buildTree(preorder, inorder);


    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return bt(preorder, 0, preorder.length, inorder, 0 ,inorder.length);

    }

    private TreeNode bt(int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight){
        // 特殊情况
        if (preRight - preLeft < 1){
            return null;
        }
        if (preRight - preLeft == 1){
            return new TreeNode(preorder[preLeft]);
        }

        int rootVal = preorder[preLeft];
        TreeNode root = new TreeNode(rootVal);
        // 找到preorder第一个元素在inorder中的位置
        int rootIndex = 0;
        for (int i = inLeft; i < inRight; i++) {
            if (inorder[i] == rootVal){
                rootIndex = i;
            }
        }

        // 切割数组
        root.left = bt(preorder, preLeft + 1, preLeft + rootIndex - inLeft + 1, inorder, inLeft, rootIndex);
        root.right = bt(preorder, preLeft + rootIndex - inLeft + 1, preRight, inorder, rootIndex + 1, inRight);
        return root;
    }

}
