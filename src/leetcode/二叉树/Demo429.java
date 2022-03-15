package leetcode.二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-03-15 15:43
 * <p>
 * 给定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）。
 * 树的序列化输入是用层序遍历，每组子节点都由 null 值分隔（参见示例）。
 */
public class Demo429 {
    public static void main(String[] args) {
        Node root = new Node(1);
        Node node1 = new Node(3);
        Node node2 = new Node(2);
        Node node3 = new Node(4);
        Node node4 = new Node(5);
        Node node5 = new Node(6);
        ArrayList<Node> childen1 = new ArrayList<>();
        childen1.add(node1);
        childen1.add(node2);
        childen1.add(node3);
        root.children = childen1;
        ArrayList<Node> childen2 = new ArrayList<>();
        childen2.add(node4);
        childen2.add(node5);
        node1.children = childen2;
        Demo429 demo = new Demo429();
        List<List<Integer>> lists = demo.levelOrder(root);
        for (List<Integer> list :
                lists) {
            System.out.println(list);
        }
    }

    public List<List<Integer>> levelOrder(Node root) {
        ArrayList<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        // 创建队列
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            System.out.println("len = " + len);
            ArrayList<Integer> temp = new ArrayList<>();
            while (len > 0) {
                Node node = queue.poll();
                temp.add(node.val);
                // 子节点列表
                if (node.children == null){
                    // 如果没有子节点，那么就跳到下一个节点去，长度要减1
                    --len;
                    continue;
                }
                List<Node> children = node.children;
                System.out.println("children.size() = " + children.size());

                int chSize = children.size();
                // 添加子节点
                for (int i = 0; i < chSize; i++) {
                    queue.offer(children.get(i));
//                    System.out.println(i);
                }
                --len;
            }
            list.add(temp);
        }
        return list;
    }

}

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
