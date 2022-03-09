package 数据结构与算法.树.二叉树1;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-02-23 09:58
 * 数组二叉树，顺序存储二叉树
 */

/*
顺序存储二叉树的概念

基本说明
从数据存储来看，数组存储方式和树
的存储方式可以相互转换，即数组可
以转换成树，树也可以转换成数组，

顺序存储二叉树的特点:

顺序二叉树通常只考虑完全二叉树
第n个元素的左子节点为  2 * n + 1
第n个元素的右子节点为  2 * n + 2
第n个元素的父节点为  (n-1) / 2

n : 表示二叉树中的第几个元素(按0开始编号)

 **/
public class ArrayBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        ArrayBinaryTree arrayBinaryTree = new ArrayBinaryTree(arr);
        System.out.println("前序遍历");
        arrayBinaryTree.preOrder();
        System.out.println();
        System.out.println("中序遍历");
        arrayBinaryTree.infixOrder();
        System.out.println();
        System.out.println("后序遍历");
        arrayBinaryTree.postOrder();
    }
}

class ArrayBinaryTree{
    private int[] arr;

    public ArrayBinaryTree(int[] arr) {
        this.arr = arr;
    }

    public void preOrder(){
        preOrder(0);
    }

    // 顺序存储二叉树的前序遍历
    public void preOrder(int index){
        if (arr == null || arr.length == 0){
            System.out.println("数组为空，不能按照二叉树遍历");
        }
        // 输出当前这个元素
        System.out.print(arr[index] + "\t");
        // 向左递归遍历，不能越界，也就是左子树存在
        if ((index * 2 + 1) < arr.length){
            preOrder(2 * index + 1);
        }
        // 向右递归遍历
        if ((index * 2 + 2) < arr.length){
            preOrder(2 * index + 2);
        }
    }
    public void infixOrder(){
        infixOrder(0);
    }

    // 中序遍历
    public void infixOrder(int index){
        if (arr == null || arr.length == 0){
            System.out.println("数组为空，不能按照二叉树遍历");
        }

        if ((index * 2 + 1) < arr.length){
            infixOrder(2 * index + 1);
        }
        System.out.print(arr[index] + "\t");

        if ((index * 2 + 2) < arr.length){
            infixOrder(2 * index + 2);
        }
    }

    public void postOrder(){
        postOrder(0);
    }
    // 后序遍历
    public void postOrder(int index){
        if (arr == null || arr.length == 0){
            System.out.println("数组为空，不能按照二叉树遍历");
        }
        if ((index * 2 + 1) < arr.length){
            infixOrder(2 * index + 1);
        }
        if ((index * 2 + 2) < arr.length){
            infixOrder(2 * index + 2);
        }
        System.out.print(arr[index] + "\t");
    }
}


