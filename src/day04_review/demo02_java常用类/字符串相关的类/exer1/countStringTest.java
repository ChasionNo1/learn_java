package day04_review.demo02_java常用类.字符串相关的类.exer1;

/**
 *
 * 获取一个字符串在另一个字符串中出现的次数。
 * 比如：获取“ ab”在 “abkkcadkabkebfkabkskab” 中出现的次数
 * @program: test
 * @author: chasion
 * @create: 2021-12-13 22:09
 */
public class countStringTest {
    public static void main(String[] args) {
        String s = "ababasadasdasaabf";
        String s1 = "ab";
        System.out.println(myCount(s, s1));
    }

    public static int myCount(String source, String aim){
        if (!(source.contains(aim))){
            return 0;
        }else {
            int idx = 0;
            int count = 0;
           while (true){
               idx = source.indexOf(aim, idx);
               if (idx == -1){
                   break;
               }else {
                   idx += aim.length();
               }
               count++;
           }
           return count;
        }
    }
}
