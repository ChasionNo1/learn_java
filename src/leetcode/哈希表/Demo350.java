package leetcode.哈希表;

import java.util.*;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-03-09 19:28
 *
 * 给你两个整数数组nums1 和 nums2 ，请你以数组形式返回两数组的交集。返回结果中每个元素出现的次数，
 * 应与元素在两个数组中都出现的次数一致（如果出现次数不一致，则考虑取较小值）。可以不考虑输出结果的顺序。
 *
 */
public class Demo350 {


    /**
     * 先遍历短数组，如果这个元素在长数组中存在，就
     * @param nums1:
     * @param nums2:
     * @return: int[]
     **/
    public int[] intersect(int[] nums1, int[] nums2) {
        // 这个处理妙啊
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums1) {
            // 这个处理也妙啊
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);
        }
        int[] intersection = new int[nums1.length];
        int index = 0;
        for (int num : nums2) {
            // 如果是子集元素，则count就不为0，如果不是就为0
            int count = map.getOrDefault(num, 0);
            // 存在子元素，但不清楚是否重复
            if (count > 0) {
                // 先添加一个
                intersection[index++] = num;
                // 对应计数减少1
                count--;
                // 如果短数组中，还有次数，那么留着看看长数组后面还会出现不
                if (count > 0) {
                    map.put(num, count);
                } else {
                    // 如果短数组就出现一次，则长数组也不用再考虑后续是否还会再出现了
                    map.remove(num);
                }
            }
        }
        // 数组复制
        return Arrays.copyOfRange(intersection, 0, index);
    }
}
