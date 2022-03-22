package leetcode.二叉树;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-03-22 10:14
 *
 * 将有序数组转换为二叉搜索树
 */
public class Demo108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return traversal(nums, 0, nums.length);


    }
    private TreeNode traversal(int[] nums, int low ,int high){
        if (low >= high){
            return null;
        }
        int mid = (low + high) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = traversal(nums, low, mid);
        root.right = traversal(nums, mid + 1, high);
        return root;
    }
}
