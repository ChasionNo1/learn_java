package day04_review.demo04_java集合.Map接口;

import org.testng.annotations.Test;

import java.util.*;

/**
 *
 *
 * @program: test
 * @author: chasion
 * @create: 2022-01-07 10:29
 */
public class TreeMapTest {

    //向TreeMap中添加key-value，要求key必须是由同一个类创建的对象
    //因为要按照key进行排序：自然排序 、定制排序
    //自然排序
    @Test
    public void test1(){
        TreeMap map = new TreeMap();
        User p1 = new User("TOM", 23);
        User p2 = new User("Jerry", 36);
        User p3 = new User("JACK", 3);
        User p4 = new User("ROSE", 18);

        map.put(p1, 23);
        map.put(p2, 45);
        map.put(p3, 454);
        map.put(p4, 2344);

        Set set = map.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            Object next = iterator.next();
            Map.Entry entry = (Map.Entry) next;
            System.out.println(entry.getKey() + "---->" + entry.getValue());
        }
    }

    //定制排序
    @Test
    public void test2(){
        TreeMap map = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof User && o2 instanceof User){
                    User u1 = (User) o1;
                    User u2 = (User) o2;
                    return Integer.compare(u1.getAge(), u2.getAge());
                }
                throw new RuntimeException("输入类型不匹配");
            }
        });
        User p1 = new User("TOM", 23);
        User p2 = new User("Jerry", 36);
        User p3 = new User("JACK", 3);
        User p4 = new User("ROSE", 18);

        map.put(p1, 23);
        map.put(p2, 45);
        map.put(p3, 454);
        map.put(p4, 2344);

        Set set = map.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            Object next = iterator.next();
            Map.Entry entry = (Map.Entry) next;
            System.out.println(entry.getKey() + "---->" + entry.getValue());
        }
    }
}
