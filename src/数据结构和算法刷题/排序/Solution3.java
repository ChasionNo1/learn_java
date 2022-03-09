package 数据结构和算法刷题.排序;

import java.util.Arrays;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-03-03 08:43
 * 从若干副扑克牌中随机抽 5 张牌，判断是不是一个顺子，即这5张牌是不是连续的。
 * 2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 */
public class Solution3 {
    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        int[] arr = {0, 0, 2, 2, 5};
        boolean straight = solution3.isStraight(arr);
        System.out.println(straight);
    }


    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        boolean isFlag = false;
        int count = 0;
        int value = 0;
        int i = 0;
        while (i < nums.length - 1) {
            while (nums[i] == 0) {
                i++;
                count++;
            }
            if (nums[i + 1] == nums[i]){
                return isFlag;
            }else {
                value += nums[i + 1] - nums[i] - 1;
            }
            i++;

        }
        if (value <= count){
            isFlag = true;
        }
        return isFlag;

    }
}
