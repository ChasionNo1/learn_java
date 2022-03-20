package 数据结构与算法.树.递归;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-03-18 15:10
 */
public class TreeTest {
    public static void main(String[] args) {
        Node root = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        Node node4 = new Node(5);
        root.left  = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        Tree tree = new Tree(root);
        tree.preOrderIndex(root);
        System.out.println("----------");
        tree.infixOrderIndex(root);
        System.out.println("----------");
        tree.postOrderIndex(root);
    }
}
