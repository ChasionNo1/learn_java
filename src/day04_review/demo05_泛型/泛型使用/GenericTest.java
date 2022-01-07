package day04_review.demo05_泛型.泛型使用;

import org.testng.annotations.Test;

import java.util.*;

/**
 *
 *  * 泛型的使用
 *  * 1.jdk 5.0新增的特性
 *  *
 *  * 2.在集合中使用泛型：
 *  *  总结：
 *  *  ① 集合接口或集合类在jdk5.0时都修改为带泛型的结构。
 *  *  ② 在实例化集合类时，可以指明具体的泛型类型
 *  *  ③ 指明完以后，在集合类或接口中凡是定义类或接口时，内部结构（比如：方法、构造器、属性等）使用到类的泛型的位置，都指定为实例化的泛型类型。
 *  *    比如：add(E e)  --->实例化以后：add(Integer e)
 *  *  ④ 注意点：泛型的类型必须是类，不能是基本数据类型。需要用到基本数据类型的位置，拿包装类替换
 *  *  ⑤ 如果实例化时，没有指明泛型的类型。默认类型为java.lang.Object类型。
 *  *
 *  * 3.如何自定义泛型结构：泛型类、泛型接口；泛型方法。见 GenericTest1.java
 * @program: test
 * @author: chasion
 * @create: 2022-01-07 16:26
 */
public class GenericTest {

    @Test
    public void test1(){
        // 在集合中使用泛型之前的情况
        ArrayList list = new ArrayList();
        list.add(12);
        list.add(98);
        list.add(45);
        // 问题1:类型不安全
        list.add("tom");
        for (Object obj:
             list) {
            // 问题2:强转时，可能会出现ClassCastException
            int score = (int) obj;
            System.out.println(score);
        }
    }

    @Test
    public void test2(){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(987);
        list.add(1233);
        list.add(34);
        //编译时，就会进行类型检查，保证数据的安全
//        list.add("tom");

        // 方式一：避免了强转操作
        for (int score :
                list) {
            System.out.println(score);
        }

        // 方式二:
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test3(){
        //在集合中使用泛型的情况：以HashMap为例
        HashMap<String, Integer> map = new HashMap<>();
        // jdk7新特性：类型推断
        HashMap<String, Integer> map1 = new HashMap<>();
        map.put("tom", 23);
        map.put("jack", 24);

        // 泛型的嵌套
        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = entrySet.iterator();

        while ((iterator.hasNext())){
            Map.Entry<String, Integer> next = iterator.next();
            String key = next.getKey();
            Integer value = next.getValue();
            System.out.println(key + "---->" + value);
        }
    }
}
