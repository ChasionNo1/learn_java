package leetcode.贪心;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * @ClassName Demo406
 * @Description TODO
 * @Author chasion
 * @Date 2022/4/12 9:51
 *
 * 假设有打乱顺序的一群人站成一个队列，数组 people 表示队列中一些人的属性（不一定按顺序）。
 * 每个 people[i] = [hi, ki] 表示第 i 个人的身高为 hi ，前面 正好 有 ki 个身高大于或等于 hi 的人。
 *
 * 请你重新构造并返回输入数组 people 所表示的队列。返回的队列应该格式化为数组 queue ，
 * 其中 queue[j] = [hj, kj] 是队列中第 j 个人的属性（queue[0] 是排在队列前面的人）。
 *
 */
public class Demo406 {

    public int[][] reconstructQueue(int[][] people) {
        // 按照身高降序排序，如果相同则按照第二个元素的升序
        Arrays.sort(people, (o1, o2) -> {
            if (o1[0] == o2[0]){
                return o1[1] - o2[1];
            }
            return o2[0] - o1[0];
        });
        // 创建链表存储，便于插入操作
        LinkedList<int[]> queue = new LinkedList<>();
        for (int[] p :
                people) {
            // 根据第二个索引插入，这里链表可以很好维持前面有多少个人
            queue.add(p[1], p);
        }
        return queue.toArray(new int[people.length][]);

    }
}
