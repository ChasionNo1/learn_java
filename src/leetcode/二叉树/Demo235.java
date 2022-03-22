package leetcode.二叉树;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-03-21 19:47
 *
 * 二叉搜索树的最近公共祖先
 *
 *
 */
public class Demo235 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 后序遍历
        // 如果知道了谁大谁小，就不用两个判断了，例如， p < q，那么只需要root.val > q.val，
        if (root.val > p.val && root.val > q.val){
            return lowestCommonAncestor(root.left, p, q);
        }
        if (root.val < p.val && root.val < q.val){
            return lowestCommonAncestor(root.right, p, q);
        }
        // 找到了范围内的第一个节点，就是最近的公共祖先
        return root;
    }

    // 迭代法
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        while (true){
            if (root.val > p.val && root.val > q.val){
                root = root.left;
            }else if (root.val < p.val && root.val < q.val){
                root = root.right;
            }else {
                // 没有相等的情况
                break;
            }
        }
        return root;
    }
}
