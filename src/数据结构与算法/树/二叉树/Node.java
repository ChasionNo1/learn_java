package 数据结构与算法.树.二叉树;

/**
 * 二叉树的结点类
 *
 * @Description TODO
 * @Author chasion
 * @Date 2022/2/17 13:20
 **/
public class Node {
    int data; // 节点数据
    Node leftChild; // 左节点
    Node rightChild; // 右节点
    boolean isDelete; // 表示节点是否被删除

    public Node(int data){
        this.data = data;
    }

    public void display(){
        System.out.println(data);
    }
}
