package leetcode.二叉树;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-03-16 15:00
 *
 * N叉树的最大深度
 *
 */
public class Demo559 {

    public int maxDepth(Node root) {
        if (root == null){
            return 0;
        }
        int depth = 0;
        // 递归方式，用for循环遍历每个子节点
        // 层序遍历也可以
        for (int i = 0; i < root.children.size(); i++) {
            depth = Math.max(depth, maxDepth(root.children.get(i)));
        }
        return depth;
    }
}
