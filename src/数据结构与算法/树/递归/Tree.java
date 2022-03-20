package 数据结构与算法.树.递归;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-03-18 15:08
 */
public class Tree {
    Node root;

    public Tree(Node root) {
        this.root = root;
    }

    public void preOrderIndex(Node root){
        if (root == null){
            return;
        }
        System.out.println(root.val);
        if (root.left != null){
            preOrderIndex(root.left);
        }
        if (root.right != null){
            preOrderIndex(root.right);
        }
    }

    public void infixOrderIndex(Node root){
        if (root.left != null){
            infixOrderIndex(root.left);
        }
        System.out.println(root.val);
        if (root.right != null){
            infixOrderIndex(root.right);
        }
    }

    public void postOrderIndex(Node root){
        if (root.left != null){
            postOrderIndex(root.left);
        }
        if (root.right != null){
            postOrderIndex(root.right);
        }
        System.out.println(root.val);
    }

}
