package day04_review.demo04_java集合.set接口.exerise;

import java.util.HashSet;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-01-06 10:12
 */
public class Exercise1 {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        Person p1 = new Person(1001, "aa");
        Person p2 = new Person(1002, "bb");
        hashSet.add(p1);
        hashSet.add(p2);

        // 按照1001， aa计算了hashcode值，完成添加，然后再根据1001，cc计算的哈希值删除p1，找不到
        p1.name = "cc";
        hashSet.remove(p1);
        System.out.println(hashSet);
        // 此时根据1001，cc计算的哈希值添加
        hashSet.add(new Person(1001, "cc"));
//        hashSet.remove(p1);
        System.out.println(hashSet);
        // 此时根据1001，aa计算的哈希值添加，由于一开始的name改为cc了，虽然hash值相同，但是equals不同，仍然可以添加
        hashSet.add(new Person(1001, "aa"));
        System.out.println(hashSet);


    }
}
