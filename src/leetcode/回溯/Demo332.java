package leetcode.回溯;


import java.util.*;

/**
 * 重新安排行程
 *
 * */

public class Demo332 {
    HashMap<String, PriorityQueue<String>> map = new HashMap<>();
    LinkedList<String> itinerary = new LinkedList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        // 遍历所有的行程信息，将他们放进map里，如果一个节点有多个目的地，那么将
        // 它们放进小顶堆中，每次弹出一个节点就是最近的目的地。
        for (List<String> ticket: tickets
             ) {
            String src = ticket.get(0);
            String dst = ticket.get(1);
            if (!map.containsKey(src)){
                map.put(src, new PriorityQueue<>());
            }
            map.get(src).offer(dst);
        }
        // 从起点出发，进行深度优先搜索。
        dfs("JFK");
        Collections.reverse(itinerary);
        return itinerary;

    }
    /*
    DFS的调用其实是一个拆边的过程（既每次递归调用删除一条边，所有子递归都返回后，再将当前节点加入结果集保证了结果集的逆序输出），
    一定是递归到这个死胡同（没有子递归可以调用）后递归函数开始返回。所以死胡同是第一个加入结果集的元素。
    * */
    public void dfs(String curr){
        while (map.containsKey(curr) && map.get(curr).size() > 0){
//            每次沿着某条边从某个顶点移动到另外一个顶点的时候，都需要删除这条边。
            String tmp = map.get(curr).poll();
            dfs(tmp);
        }
//        如果没有可移动的路径，则将所在节点加入到栈中，并返回
        itinerary.add(curr);
    }

}
