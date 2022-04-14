package leetcode.贪心;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @ClassName Demo56
 * @Description TODO
 * @Author chasion
 * @Date 2022/4/14 16:28
 *
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 *
 */
public class Demo56 {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, ((o1, o2) -> {
            if (o1[0] == o2[0]){
                return o1[1]-o2[1];
            }
            return o1[0]-o2[0];
        }));
        int start = intervals[0][0];
        ArrayList<int[]> res = new ArrayList<>();
        for (int i = 1; i < intervals.length; i++) {
            // 如果当前与上一个没有重叠，则把上一个添加到结果里，当前与下一个还需判断，所以更新start
            if (intervals[i][0] > intervals[i - 1][1]){
                res.add(new int[]{start, intervals[i - 1][1]});
                start = intervals[i][0];
            }else {
                intervals[i][1] = Math.max(intervals[i - 1][1], intervals[i][1]);
            }
        }
        // 添加最后一个，如果和上一个有重叠，则合并过了，没有重叠，就不动
        res.add(new int[]{start, intervals[intervals.length - 1][1]});
        return res.toArray(new int[res.size()][]);


    }
}
