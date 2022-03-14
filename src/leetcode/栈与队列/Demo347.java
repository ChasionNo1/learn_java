package leetcode.栈与队列;

import java.util.*;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-03-14 14:47
 *
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 */
public class Demo347 {


    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();
        // 统计数组内元素出现的次数
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i]) + 1);
            }else {
                map.put(nums[i], 1);
            }
        }
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        // 根据map的value值正序排，相当于一个小顶堆
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((Comparator.comparingInt(Map.Entry::getValue)));
        for (Map.Entry<Integer, Integer> entry: entries
             ) {
            queue.offer(entry);
            if (queue.size() > k){
                queue.poll();
            }
        }
        for (int i = k - 1; i >=0; i--) {
            res[i] = queue.poll().getKey();
        }
        return res;


    }
}
