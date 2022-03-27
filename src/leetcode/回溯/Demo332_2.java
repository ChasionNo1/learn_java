package leetcode.回溯;


import java.util.*;

/*
* 重新安排行程2：使用回溯法
*
* */
public class Demo332_2 {
    private Deque<String> res;
    private Map<String, Map<String, Integer>> map;

    public static void main(String[] args) {
        Demo332_2 demo = new Demo332_2();
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("JFK");
        list1.add("KUL");
        ArrayList<String> list2 = new ArrayList<>();
        list2.add("JFK");
        list2.add("NRT");
        ArrayList<String> list3 = new ArrayList<>();
        list3.add("NRT");
        list3.add("JFK");
        List<List<String>> lists = new ArrayList<>();
        lists.add(list1);
        lists.add(list2);
        lists.add(list3);
        List<String> res = demo.findItinerary(lists);
        System.out.println(res);


    }

    public List<String> findItinerary(List<List<String>> tickets) {
        map = new HashMap<>();
        res = new LinkedList<>();
        for (List<String> t: tickets
        ){
            Map<String, Integer> temp;
            // 记录路径{src,{dst1,1},{dst2,1}}  {NRT={JFK=1}, JFK={KUL=1, NRT=1}}
            if (map.containsKey(t.get(0))){
                temp = map.get(t.get(0));
                temp.put(t.get(1), temp.getOrDefault(t.get(1), 0) + 1);
            }else {
                // 升序，存放目的节点
                temp = new TreeMap<>();
                temp.put(t.get(1) , 1);
            }
            map.put(t.get(0), temp);
        }
        System.out.println(map);
        res.add("JFK");
        // 遍历完所有航班
        backtracking(tickets.size());
        return new ArrayList<>(res);

    }
    private boolean backtracking(int ticketNum){
        // [a, b] [b, c], [c, d] --> [a->b-->c--->d] 三个航班需要四个机场
        if (res.size() == ticketNum + 1){
            return true;
        }
        // res里添加的是验证最小的路线顺序，获取最后一个去寻找下一个
        String last = res.getLast();
        // 如果是死胡同，src -> dst,此时是dst，而dst没有路径可走，返回false，
        if (map.containsKey(last)){
            // 所有相连节点的集合
            for (Map.Entry<String, Integer> target:map.get(last).entrySet()
            ){
                // 获取src到dst之间的路线数
                int count = target.getValue();
                // 大于0表示同枝还没飞过
                if (count > 0){
                    res.add(target.getKey());
                    target.setValue(count - 1);
                    // 如果返回true，表明找到了合适的路线，
                    // 如果返回false，则回溯继续寻找
                    if (backtracking(ticketNum)) return true;
                    res.removeLast();
                    target.setValue(count);
                }
            }
        }
        return false;
    }
}
