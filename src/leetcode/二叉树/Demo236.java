package leetcode.二叉树;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-03-21 15:30
 *
 * 二叉树的最近公共祖先
 *
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，
 * 最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 */
public class Demo236 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 后序遍历，搜索节点
        // 如果当前节点是叶子节点则返回，如果找到了p、q也返回
        if (root == null || root == p || root == q){
            return root;
        }

        // 左，如果找到了p\q则则返回相应的值
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        // 右：
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 中：对返回的left和right进行判断，如果都是null，则没有找到

        if (left == null && right == null){
            return null;
            // 如果找了一个，说明在一个子树找到了，向上返回
        }else if (left == null && right != null){
            return right;
        }else if (left != null && right == null){
            return left;
        }else {
            // 都不为空，就是找到了两个
            return root;
        }

    }
}
