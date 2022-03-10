package leetcode.哈希表;

import java.util.HashMap;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-03-09 21:39
 *
 * 
 */
public class Demo454 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int temp;
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        // 遍历AB数组，求和，并统计其出现次数
        for (int i :
                nums1) {
            for (int j :
                    nums2) {
                temp = i + j;
                int counts = map.getOrDefault(temp, 0) + 1;
                map.put(temp, counts);
            }
        }

        // 遍历CD
        for (int k :
                nums3) {
            for (int l :
                    nums4) {
                temp =  - k - l;
                if (map.containsKey(temp)){
                    // 如果要找的数在map里
                    res += map.get(temp);
                }
            }
        }
        return res;

    }
}
