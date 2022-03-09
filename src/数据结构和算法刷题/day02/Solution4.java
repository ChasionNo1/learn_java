package 数据结构和算法刷题.day02;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-02-28 18:56
 */
public class Solution4 {
    public static void main(String[] args) {
        Solution4 solution4 = new Solution4();
        String addfgdfv = solution4.getSub("addfgdfv", 2);
        System.out.println(addfgdfv);

    }

    public String getSub(String s, int i){
        return s.substring(i) + s.substring(0, i);
    }
}
