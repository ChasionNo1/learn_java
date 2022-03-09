package leetcode.哈希表;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-03-09 19:02
 * <p>
 * 两个数组的交集
 * 给定两个数组 nums1 和 nums2 ，返回 它们的交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
 */
public class Demo349 {
    public static void main(String[] args) {
        Demo349 demo = new Demo349();
        int[] arr1 = {1, 2, 2, 1};
        int[] arr2 = {2, 2};
        int[] units = demo.intersection(arr1, arr2);
        System.out.println(Arrays.toString(units));
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> map1 = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i :
                nums1) {
            if (!map.containsKey(i)) {
                map.put(i, 1);
            }
        }
        for (int i :
                nums2) {
            if (!map1.containsKey(i)){
                map1.put(i, 1);
                if (map.containsKey(i)) {
                    list.add(i);
                }
            }

        }
        if (list.size() == 0){
            return new int[]{};
        }
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;

    }
    // 使用set集合，可以去掉重复的元素


}
