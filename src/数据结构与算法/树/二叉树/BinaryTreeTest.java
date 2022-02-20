package 数据结构与算法.树.二叉树;

import org.testng.annotations.Test;

/**
 * @Description TODO
 * @Author chasion
 * @Date 2022/2/18 16:56
 **/
public class BinaryTreeTest {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        boolean b = binaryTree.insert(20);
//        System.out.println(b);
        boolean b1 = binaryTree.insert(30);
//        System.out.println(b1);
        boolean b2 = binaryTree.insert(40);
//        System.out.println(b2);
        boolean b3 = binaryTree.insert(60);
//        System.out.println(b3);
        boolean b4 = binaryTree.insert(70);
//        System.out.println(b4);
        boolean b5 = binaryTree.insert(25);
//        System.out.println(b5);
        boolean b6 = binaryTree.insert(65);
//        System.out.println(b6);
        binaryTree.infixOrder(binaryTree.getRoot());
        System.out.println("max:" + binaryTree.findMax().data);
        System.out.println("min:" + binaryTree.findMin().data);
        boolean delete = binaryTree.delete(25);
        System.out.println(delete);
//        Node node = binaryTree.find(20);
//        System.out.println(node);
    }

    @Test
    public void test1(){
        /*
        从前面的大部分对树的操作来看，都需要从根节点到下一层一层的查找。

    　　一颗满树，每层节点数大概为2n-1，那么最底层的节点个数比树的其它节点数多1，因此，查找、插入或删除节点的操作大约有一半都需要找到底层的节点，另外四分之一的节点在倒数第二层，依次类推。

    　　总共N层共有2n-1个节点，那么时间复杂度为O(logn),底数为2。

    　　在有1000000 个数据项的无序数组和链表中，查找数据项平均会比较500000 次，但是在有1000000个节点的二叉树中，只需要20次或更少的比较即可。

    　　有序数组可以很快的找到数据项，但是插入数据项的平均需要移动 500000 次数据项，在 1000000 个节点的二叉树中插入数据项需要20次或更少比较，在加上很短的时间来连接数据项。

    　　同样，从 1000000 个数据项的数组中删除一个数据项平均需要移动 500000 个数据项，而在 1000000 个节点的二叉树中删除节点只需要20次或更少的次数来找到他，然后在花一点时间来找到它的后继节点，一点时间来断开节点以及连接后继节点。

    　　所以，树对所有常用数据结构的操作都有很高的效率。

    　　遍历可能不如其他操作快，但是在大型数据库中，遍历是很少使用的操作，它更常用于程序中的辅助算法来解析算术或其它表达式。


        * */
    }
}
