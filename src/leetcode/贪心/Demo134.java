package leetcode.贪心;

/*
134. 加油站
在一条环路上有 n 个加油站，其中第 i 个加油站有汽油 gas[i] 升。

你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。

给定两个整数数组 gas 和 cost ，如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1 。如果存在解，则 保证 它是 唯一 的。
* */
public class Demo134 {

    // 暴力
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int cap;
        for (int i = 0; i < gas.length; i++) {
            int index = (i + 1) % cost.length;
            cap = gas[i] - cost[i];
            while (cap > 0 && index != i){
                cap += gas[index] - cost[index];
                index = (index + 1) % cost.length;
            }
            if (cap >= 0 && index == i){
                return i;
            }
        }
        return -1;

    }

    // 贪心
    public int canCompleteCircuit1(int[] gas, int[] cost) {
        int curSum = 0;
        int totalSum = 0; // 如果cost总和大于gas，则不满足
        int start = 0; // 记录满足条件的起始位置
        for (int i = 0; i < gas.length; i++) {
            int res = gas[i] - cost[i];
            curSum += res;
            totalSum += res;
            // 如果不进入这个if，则start就不会更新，表示满足条件
            if (curSum < 0){
                curSum = 0;
                start = i + 1;

            }
        }
        if (totalSum < 0){
            return -1;
        }
        return start;
    }
}
