package 数据结构与算法.树.二叉树1;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-02-23 14:02
 *
 * 线索化二叉树
 * n个结点的二叉链表中含有n+1  【公式 2n-(n-1)=n+1】 个空指针域。
 * 利用二叉链表中的空指针域，存放指向该结点在某种遍历次序下的前驱和后继结点的指针（这种附加的指针称为"线索"）
 *
 * 这种加上了线索的二叉链表称为线索链表，相应的二叉树称为线索二叉树(Threaded BinaryTree)。
 * 根据线索性质的不同，线索二叉树可分为前序线索二叉树、中序线索二叉树和后序线索二叉树三种
 *
 * 一个结点的前一个结点，称为前驱结点
 * 一个结点的后一个结点，称为后继结点
 */
public class ThreadedBinaryTreeDemo {
    public static void main(String[] args) {
        Node root = new Node(1, "aa");
        Node node2 = new Node(3, "bb");
        Node node3 = new Node(6, "cc");
        Node node4 = new Node(8, "dd");
        Node node5 = new Node(10, "ee");
        Node node6 = new Node(14,  "ff");
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);

        ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree();
        threadedBinaryTree.setRoot(root);
        threadedBinaryTree.threadedNodes();
        Node right = node5.getRight();
        Node left = node5.getLeft();
        System.out.println("10号结点的前驱结点是 ="  + left); //3
        System.out.println("10号结点的后继结点是="  + right); //1

        System.out.println("------");
        threadedBinaryTree.threadedList();
    }
}

// 定义线索化二叉树
class ThreadedBinaryTree{
    private Node root;
    // 为了线索化，需要创建指向当前节点的前驱节点的指针
    // 在递归进行线索化时，pre总是保留前一个节点
    private Node pre = null;

    public void setRoot(Node root) {
        this.root = root;
    }

    public void threadedNodes(){
        threadedNodes(root);
    }

    /**
     * @Description: 二叉树线索化方法，采用中序遍历顺序
     * @Author: chasion
     * @Date: 2022/2/23 14:41
     * @param node:
     * @return: void
     **/
    public void threadedNodes(Node node){

        //如果node==null, 不能线索化
        if (node == null){
            return;
        }
        // 1、先线索化左子树
        threadedNodes(node.getLeft());
        // 2、线索化当前节点
        // 处理当前节点的前驱节点
        if (node.getLeft() == null){
            // 让当前节点的左指针指向前驱节点
            node.setLeft(pre);
            // 修改当前节点的左指针的类型，指向前驱节点
            node.setLeftType(1);
        }
        // 处理后续节点
        if (pre != null && pre.getRight() == null){
            // 让前驱节点的右指针指向当前节点
            pre.setRight(node);
            pre.setRightType(1);
        }
        //!!! 每处理一个结点后，让当前结点是下一个结点的前驱结点
        pre = node;

        //(三)在线索化右子树
        threadedNodes(node.getRight());
    }

    /**
     * @Description: 遍历线索化二叉树
     * @Author: chasion
     * @Date: 2022/2/23 15:25

     * @return: void
     **/
    public void threadedList(){
        //定义一个变量，存储当前遍历的结点，从root开始
        Node cur = root;
        while (cur != null){
            //循环的找到leftType == 1的结点，第一个找到就是8结点
            //后面随着遍历而变化,因为当leftType==1时，说明该结点是按照线索化
            //处理后的有效结点
            while (cur.getLeftType() == 0){
                cur = cur.getLeft();
            }
            System.out.println(cur);
            //如果当前结点的右指针指向的是后继结点,就一直输出
            while (cur.getRightType() == 1){
                cur = cur.getRight();
                System.out.println(cur);
            }
            //替换这个遍历的结点
            cur = cur.getRight();
        }
    }
}

class Node{
    private int no;
    private String name;
    private Node left;
    private Node right;

    // 如果leftType=0表示指向的是左子树，如果是1表示指向的是前驱节点
    // 如果rightType=0表示指向的是右子树，如果是1表示指向的是前驱节点
    private int leftType;
    private int rightType;

    public Node(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}
