package leetcode.二叉树;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-03-22 09:28
 *
 * 删除二叉搜索树中的节点
 */
public class Demo450 {

    // 中，左，右，前序遍历
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null){
            return root;
        }
        // 找到要删除的节点了
        if (root.val == key){
            // 左子树为空
            if (root.left == null){
                return root.right;
                // 右子树为空
            }else if (root.right == null){
                return root.left;
            }else {
                // 左右子树都不为空
                TreeNode cur = root.right;
                // 找到右子树的最左侧的节点
                while (cur.left != null){
                    cur = cur.left;
                }
                // 将要删除的节点的左子树挂到右子树最左侧的节点上
                cur.left = root.left;
                // 返回右节点
                root = root.right;
                return root;

            }
        }
        if (root.val > key){
            root.left = deleteNode(root.left, key);
        }
        if (root.val < key){
            root.right = deleteNode(root.right, key);
        }
        return root;

    }


}
