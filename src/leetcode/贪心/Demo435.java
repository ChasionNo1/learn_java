package leetcode.贪心;

import java.util.Arrays;

/**
 * @ClassName Demo435
 * @Description TODO
 * @Author chasion
 * @Date 2022/4/13 16:22
 * <p>
 * 给定一个区间的集合 intervals ，其中 intervals[i] = [starti, endi] 。返回 需要移除区间的最小数量，使剩余区间互不重叠 。
 */
public class Demo435 {

    public int eraseOverlapIntervals(int[][] intervals) {
        // 按照区间右端点排序
        Arrays.sort(intervals, ((o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        }));
        int count = 0;
        // 设定初始边界为无穷小
        int edge = Integer.MIN_VALUE;
        for (int i = 0; i < intervals.length; i++) {
            // 由于已经按照右端点排序了，所以此时只需要遍历即可
            // 当前区间的开始位置大于边界，就说明没有交叉，将边界替换为当前区间的结尾
            if (intervals[i][0] >= edge){
                edge = intervals[i][1];
                count++;
            }
        }
        // 总区间个数-非交叉区间个数=删除区间的个数
        return intervals.length - count;


    }
}
