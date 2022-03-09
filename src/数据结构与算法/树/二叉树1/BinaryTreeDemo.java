package 数据结构与算法.树.二叉树1;


/**
 * @program: test
 * @author: chasion
 * @create: 2022-02-22 21:06
 */
public class BinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        HeroNode root = new HeroNode(1, "aa");
        HeroNode node2 = new HeroNode(2, "bb");
        HeroNode node3 = new HeroNode(3, "cc");
        HeroNode node4 = new HeroNode(4, "dd");
        HeroNode node5 = new HeroNode(5, "ee");
        binaryTree.setRoot(root);
        root.setLeft(node2);
        root.setRight(node3);
        node3.setLeft(node5);
        node3.setRight(node4);
        binaryTree.infixOrder();
        HeroNode heroNode = binaryTree.infixOrderSearch(5);
        if (heroNode != null){
            System.out.println("找到了");
        }else {
            System.out.println("没有找到");
        }
        System.out.println("----------");
        HeroNode heroNode1 = binaryTree.preOrderSearch(5);
        if (heroNode1 != null){
            System.out.println("找到了");
        }else {
            System.out.println("没有找到");
        }
        System.out.println("----------");
        HeroNode heroNode2 = binaryTree.postOrderSearch(5);
        if (heroNode2 != null){
            System.out.println("找到了");
        }else {
            System.out.println("没有找到");
        }
        System.out.println("----------");

        binaryTree.delNode(5);
        binaryTree.infixOrder();


    }
}

class BinaryTree{
    private HeroNode root; // 根节点
    public void setRoot(HeroNode root){
        this.root = root;
    }

    // 前序遍历
    public void preOrder(){
        if (this.root != null){
            this.root.preOrder();
        }else {
            System.out.println("二叉树为空，不能遍历");
        }
    }

    // 中序遍历
    public void infixOrder(){
        if (this.root != null){
            this.root.infixOrder();
        }else {
            System.out.println("二叉树为空，不能遍历");
        }
    }

    // 后序遍历
    public void postOrder(){
        if (this.root != null){
            this.root.postOrder();
        }else {
            System.out.println("二叉树为空，不能遍历");
        }
    }

    public HeroNode preOrderSearch(int no){
        if (this.root != null){
            return this.root.preOrderSearch(no);
        }else {
            return null;
        }
    }

    public HeroNode infixOrderSearch(int no){
        if (this.root != null){
            return this.root.infixOrderSearch(no);
        }else {
            return null;
        }
    }

    public HeroNode postOrderSearch(int no){
        if (this.root != null){
            return this.root.postOrderSearch(no);
        }else {
            return null;
        }
    }

    public void delNode(int no){
        if (root != null){
            if (root.getNo() == no){
                root = null;
            }else {
                root.delNode(no);
            }
        }else {
            System.out.println("空树，不能删除");
        }
    }
}

// 创建二叉树的节点类
class HeroNode{
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

    public HeroNode(int no, String name) {
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

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    // 前序遍历
    public void preOrder(){
        // 先输出自己
        System.out.println(this);
        // 向左子树递归遍历
        if (this.left != null){
            this.left.preOrder();
        }
        // 向右子树递归遍历
        if (this.right != null){
            this.right.preOrder();
        }
    }

    // 中序遍历
    public void infixOrder(){
        if (this.left != null){
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null){
            this.right.infixOrder();
        }
    }

    // 后序遍历
    public void postOrder(){
        if (this.left != null){
            this.left.postOrder();
        }

        if (this.right != null){
            this.right.postOrder();
        }
        System.out.println(this);
    }

    /**
     * @Description: 前序遍历搜索
     * @Author: chasion
     * @Date: 2022/2/23 8:49
     * @param no:
     * @return: 数据结构与算法.树.二叉树1.HeroNode
     **/
    public HeroNode preOrderSearch(int no){
        HeroNode cur = null;
        System.out.println("进入前序查找");
        if (this.no == no){
            return this;
        }
        if (this.left != null){
            cur = this.left.preOrderSearch(no);
        }
        if (cur != null){
            return cur;
        }
        if (this.right != null){
            cur = this.right.preOrderSearch(no);
        }
        return cur;
    }

    /**
     * @Description: 中序遍历搜索
     * @Author: chasion
     * @Date: 2022/2/23 8:40
     * @param no:
     * @return: 数据结构与算法.树.二叉树1.HeroNode
     **/
    public HeroNode infixOrderSearch(int no){
        // 判断当前节点的左子节点是否为空，如果不为空，则递归中序查找
        HeroNode resNode = null;
        if (this.left != null){
            // 进入递归，此时进入递归时this -> this.left了
            resNode = this.left.infixOrderSearch(no);
        }

        if (resNode != null){
            return resNode;
        }

        System.out.println("进入中序查找");
        // 如果找到，则返回，如果没有找到，就和当前节点比较，如果是则返回当前节点
        if (this.no == no){
            return this;
        }
        // 否则继续向右进行递归查找
        if (this.right != null){
            resNode = this.right.infixOrderSearch(no);
        }
        return resNode;
    }

    public HeroNode postOrderSearch(int no){
        HeroNode cur = null;
        if (this.left != null){
            cur = this.left.postOrderSearch(no);
        }
        if (cur != null) {
            return cur;
        }
        if (this.right != null){
            cur = this.right.postOrderSearch(no);
        }
        if (cur != null){
            return cur;
        }
        System.out.println("进入后序查找");
        if (this.no == no){
            return this;
        }
        return cur;
    }

    /**
     * @Description: 删除节点，如果删除的节点是叶子节点，则删除该节点，如果删除的是非叶子节点，就删除该子树
     * @Author: chasion
     * @Date: 2022/2/23 9:16
     * @param no:
     * @return: void
     **/
    public void delNode(int no){
        /*
        1、因为我们的二叉树是单向的，所以我们是判断当前节点的子节点是否需要删除，而不能判断当前这个节点是不是要删除的节点
        2、如果当前节点的左子节点不为空，并且左子节点就是要删除的节点，就将this.left == null，并且就返回，结束递归删除
        3、如果当前节点的右子节点不为空，并且右子节点就是要删除的节点，就将this.right == null，并且就返回，结束递归删除
        4、如果第2和第3步没有删除节点，那么我们就需要向左子树进行递归删除
        5、如果第4步也没有删除节点，则应当向右子树进行递归删除

         **/
        if (this.left != null && this.left.no == no){
            this.left = null;
            return;
        }
        if (this.right != null && this.right.no == no){
            this.right = null;
            return;
        }
        if (this.left != null){
            this.left.delNode(no);
        }
        if (this.right != null){
            this.right.delNode(no);
        }
    }
}
