package leetcode.二叉树;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-03-16 16:03
 * 给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
 * 在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，
 * 并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~2**h个节点。
 *
 */
public class Demo222 {
    public int countNodes(TreeNode root) {
        if (root == null){
            return 0;
        }
        // 递归方法
        int left = countNodes(root.left);
        int right = countNodes(root.right);
        int result = left + right + 1;
        return result;

    }

    /**
     * 完全二叉树的解法
     * @param root:
     * @return: int
     **/
    public int countNodes1(TreeNode root) {
        if (root == null){
            return 0;
        }
        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);
        // 左子树是满二叉树
        if (leftDepth == rightDepth){
            // 2^leftDepth其实是 （2^leftDepth - 1） + 1 ，左子树 + 根结点
            return (1 << leftDepth) + countNodes1(root.right);
        // 右子树是满二叉树
        }else {
            return (1 << rightDepth) + countNodes1(root.left);
        }

    }
    // 完全二叉树时，计算左右子树的深度
    private int getDepth(TreeNode node){
        int depth = 0;
        while (node != null){
            ++depth;
            node = node.left;
        }
        return depth;
    }
}
