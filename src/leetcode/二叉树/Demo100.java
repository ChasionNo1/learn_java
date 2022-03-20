package leetcode.二叉树;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-03-18 09:04
 *
 * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 *
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 */
public class Demo100 {

    public boolean isSameTree(TreeNode p, TreeNode q) {
       return compare(p, q);


    }
    private boolean compare(TreeNode p, TreeNode q){
        if (p == null && q == null){
            return true;
        }else if (p == null || q == null){
            return false;
        }else if (p.val != q.val){
            return false;
        }
        // 开始遍历
        boolean left = compare(p.left, q.left);
        boolean right = compare(p.right, q.right);
        return left && right;
    }

}
