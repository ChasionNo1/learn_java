package 数据结构与算法.树.二叉树;

/**
 * 二叉树的抽象数据类型
 *
 * @Description TODO
 * @Author chasion
 * @Date 2022/2/17 13:22
 **/
public interface Tree {
    //查找节点
    public Node find(int key);
    //插入新节点
    public boolean insert(int data);

    //中序遍历
    public void infixOrder(Node current);
    //前序遍历
    public void preOrder(Node current);
    //后序遍历
    public void postOrder(Node current);

    //查找最大值
    public Node findMax();
    //查找最小值
    public Node findMin();

    //删除节点
    public boolean delete(int key);
}
