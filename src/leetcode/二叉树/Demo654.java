package leetcode.二叉树;

import 数据结构与算法.树.递归.Tree;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-03-19 21:30
 *
 * 最大二叉树
 * 给定一个不重复的整数数组nums 。最大二叉树可以用下面的算法从nums 递归地构建:
 *
 * 创建一个根节点，其值为nums 中的最大值。
 * 递归地在最大值左边的子数组前缀上构建左子树。
 * 递归地在最大值 右边 的子数组后缀上构建右子树。
 *
 */
public class Demo654 {


    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return cmt(nums, 0, nums.length);

    }

    public TreeNode cmt(int[] nums, int leftIndex, int rightIndex){
        // 排除特殊情况
        if (rightIndex - leftIndex < 1){
            return null;
        }
        if (rightIndex - leftIndex == 1){
            return new TreeNode(nums[leftIndex]);
        }
        // 最大值和其索引
        int maxIndex = leftIndex;
        int maxVal = nums[leftIndex];

        for (int i = leftIndex; i < rightIndex; i++) {
            if (nums[i] > maxVal){
                maxIndex = i;
                maxVal = nums[i];
            }
        }

        TreeNode root = new TreeNode(maxVal);
        // 数组分割
        root.left = cmt(nums, leftIndex, maxIndex);
        root.right = cmt(nums, maxIndex + 1, rightIndex);
        return root;
    }
}
