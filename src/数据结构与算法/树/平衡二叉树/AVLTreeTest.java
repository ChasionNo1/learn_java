package 数据结构与算法.树.平衡二叉树;

import org.testng.annotations.Test;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-02-26 15:16
 */
public class AVLTreeTest {
    public static void main(String[] args) {
//        int[] arr = {4, 3, 6, 5, 7, 8};
//        int[] arr1 = { 10, 11, 7, 6, 8, 9 };
//        AVLTree avlTree = new AVLTree();
//        for (int i = 0; i < arr1.length; i++) {
//            avlTree.add(new Node(arr1[i]));
//        }
//
//        System.out.println("中序遍历");
//        avlTree.infixOrder();
//        System.out.println("树的高度" + avlTree.getRoot().height());
//        System.out.println("左子树的高度" + avlTree.getRoot().leftHeight());
//        System.out.println("右子树的高度" + avlTree.getRoot().rightHeight());
    }
    @Test
    public void test1(){
        int[] arr1 = {7, 6, 8, 9};
        AVLTree avlTree = new AVLTree();
        for (int i = 0; i < arr1.length; i++) {
            avlTree.add(new Node(arr1[i]));
        }

        System.out.println("树的高度" + avlTree.getRoot().getHeight());

    }


}
