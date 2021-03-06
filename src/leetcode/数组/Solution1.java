package leetcode.数组;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-03-04 15:11
 *
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 最多出现两次 ，返回删除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 */
public class Solution1 {
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        int[] arr = {1, 1, 1, 2, 2, 3};
        int i = solution1.removeDuplicates(arr);
        System.out.println(i);
    }


    public int removeDuplicates(int[] nums) {
        /*
         *
          由于是保留k个相同数字，所以前k个直接保留
          对于后续的，能够保留的前提是：
          与当前写入的位置前面的第k个元素进行比较，不相同则保留
          * 举例：
             [1,1,1,1,1,1,2,2,2,2,2,2,3]
            首先我们先让前 2 位直接保留，得到 1,1
            对后面的每一位进行继续遍历，能够保留的前提是与当前位置的前面 k 个元素不同（答案中的第一个 1），因此我们会跳过剩余的 1，将第一个 2 追加，
            得到 1,1,2
            继续这个过程，这时候是和答案中的第 2 个 1 进行对比，因此可以得到 1,1,2,2
            这时候和答案中的第 1 个 2 比较，只有与其不同的元素能追加到答案，因此剩余的 2 被跳过，3 被追加到答案：1,1,2,2,3

          **/

        int i = 0;
        for (int x :
                nums) {
            if (i < 2 || nums[i - 2] != x){
                // 1 2 2 4
                // 也就是说每个数最多有两个坑，先放了 1 2
                // 再放第二个2时，考虑要放的这个位置和它前第二位上的数是否相同，如果相同，就说明已经有2个了
                // 因为允许存在两个，x-2 x-1 x，如果x-2和x位置上的数相同，就说明x-2 x-1 x 三个都相同，单调不减的
                // 所以需要x-2 x这两个不相同
                nums[i++] = x;
            }
        }
        return i;
    }
}
