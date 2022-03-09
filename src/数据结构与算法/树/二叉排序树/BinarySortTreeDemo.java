package 数据结构与算法.树.二叉排序树;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-02-23 20:47
 *
 * 二叉排序树
 */
public class BinarySortTreeDemo {
    public static void main(String[] args) {
        int[] arr = {7, 3, 10, 12, 5, 1, 9, 2};
        BinarySortTree tree = new BinarySortTree();
        for (int i = 0; i < arr.length; i++) {
            tree.add(new Node(arr[i]));
        }

        tree.infixOrder();
        System.out.println("-----------");
        Node search = tree.search(7);
        System.out.println(search);
        System.out.println("-----------");
        Node parent = tree.searchParent(2);
        System.out.println(parent);

        System.out.println("---------");
        tree.delNode(5);
        tree.delNode(1);
        tree.delNode(10);
        tree.infixOrder();


    }
}

class BinarySortTree{
    private Node root;

    public void add(Node node){
        if (root == null){
            root = node;
        }else {
            root.add(node);
        }
    }

    public void infixOrder(){
        if (root == null){
            System.out.println("树为空");
        }else {
            root.infixOrder();
        }
    }

    public Node search(int value){
        if(root == null) {
            return null;
        } else {
            return root.search(value);
        }
    }

    public Node searchParent(int value){
        if (root == null){
            return null;
        }else {
            return root.searchParent(value);
        }

    }

    /**
     * 1. 返回的 以node 为根结点的二叉排序树的最小结点的值
     * 2. 删除node 为根结点的二叉排序树的最小结点
     * @param node: 传入的结点(当做二叉排序树的根结点)
     * @return: int 以node 为根结点的二叉排序树的最小结点的值
     **/
    public int delRightTreeMin(Node node){
        Node target = node;
        // 循环查找左子节点，就会找到最小值
        while (target.left != null){
            target = target.left;
        }
        // 如果没有左子树，那么target就是最小的
        // 这时target就指向了最小节点
        delNode(target.value);
        return target.value;

    }

    /**
     * 删除节点：
     * 1、删除叶子节点
     * 2、删除只有一颗子树的节点
     * 3、删除有两颗子树的节点
     * @param value:
     * @return: void
     **/
    public void delNode(int value){
        if (root == null){
            return;
        }else {
            // 1、找到要删除的节点
            Node targetNode = search(value);
            if (targetNode == null){
                return;
            }
            // 如果二叉树只有一个根节点
            if (root.left == null && root.right == null){
                // 如果是根节点，如果不是就找不到
                root = null;
                return;
            }

            // 去找到targetNode的父节点
            Node parent = searchParent(value);
            // 如果要删除的是叶子节点
            if (targetNode.left == null && targetNode.right == null){
                // 判断targetNode 是父结点的左子结点，还是右子结点
                if (parent.left != null && parent.left.value == value){
                    parent.left = null;
                }
                if (parent.right != null && parent.right.value == value){
                    parent.right = null;
                }
            }else if (targetNode.left != null && targetNode.right != null){
                // 删除有两颗子树的节点
                // 得到最小的值，进行替换
                targetNode.value = delRightTreeMin(targetNode.right);
            }else {
                // 左子节点不为空
                if (targetNode.left != null){
                    // 父节点不为空
                    if (parent != null){
                        if (parent.left.value == value){
                            // 目标节点是左子节点
                            parent.left = targetNode.left;
                        }else {
                            parent.right = targetNode.left;
                        }
                    }else {
                        // 父节点为空
                        root = targetNode.left;
                    }
                }else {
                    // 右子节点不为空
                    if (parent != null){
                        if (parent.left.value == value){
                            parent.left = targetNode.right;
                        }else {
                            parent.right = targetNode.right;
                        }
                    }else {
                        root = targetNode.right;
                    }
                }
            }
        }
    }
}

class Node{
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    //添加结点的方法
    //递归的形式添加结点，注意需要满足二叉排序树的要求
    public void add(Node node){
        if (node == null){
            return;
        }
        //判断传入的结点的值，和当前子树的根结点的值关系
        if (node.value < this.value){
            if (this.left == null){
                this.left = node;
            }else {
                this.left.add(node);
            }
        }else {
            if (this.right == null){
                this.right = node;
            }else {
                this.right.add(node);
            }
        }
    }

    public void infixOrder(){
        if (this.left != null){
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null){
            this.right.infixOrder();
        }
    }

    /**
     * 查找要删除的节点，递归查找
     * @param value:
     * @return: 数据结构与算法.树.二叉排序树.Node
     **/
    public Node search(int value){
        if (this.value == value){
            return this;
        }
        if (value < this.value){
            // 查找值小于value，在当前节点的左子树
            if (this.left != null){
                return this.left.search(value);
            }else {
                return null;
            }
        }else {
            if (this.right != null){
                return this.right.search(value);
            }else {
                return null;
            }
        }
    }

    /**
     * 查找value值的父节点
     * @param value:
     * @return: 数据结构与算法.树.二叉排序树.Node
     **/
    public Node searchParent(int value){
        if ((this.left != null && this.left.value == value) || (this.right != null && this.right.value == value)){
            return this;
        }
        if (this.value > value){
            // 向左遍历查找
            if (this.left != null){
                return this.left.searchParent(value);
            }else {
                return null;
            }
        }else {
            if (this.right != null){
               return this.right.searchParent(value);
            }else {
                return null;
            }
        }
    }
}
