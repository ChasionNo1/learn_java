package leetcode.贪心;
/*
55. 跳跃游戏
给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。

数组中的每个元素代表你在该位置可以跳跃的最大长度。

判断你是否能够到达最后一个下标。
* */
public class Demo55 {

    public boolean canJump(int[] nums) {
        if (nums.length == 1){
            return true;
        }
        int coverArea = 0;

        for (int i = 0; i <= coverArea; i++) {
            coverArea = Math.max(coverArea, nums[i] + i);
            if (coverArea >= nums.length - 1){
                return true;
            }
        }
        return false;

    }
}
