package 复习与梳理.day06集合;

import org.testng.annotations.Test;

import java.util.*;

/**
 * 集合的使用
 *
 * @Description TODO
 * @Author chasion
 * @Date 2022/1/27 14:47
 **/
public class CollectionTest {

    @Test
    public void test1(){
        /*
        * |----Collection接口：单列集合，用来存储一个一个的对象
         *          |----List接口：存储序的、可重复的数据。  -->“动态”数组
         *              |----ArrayList、LinkedList、Vector
         *
         *          |----Set接口：存储无序的、不可重复的数据   -->高中讲的“集合”
         *              |----HashSet、LinkedHashSet、TreeSet
        * */
    }

    @Test
    public void test2(){
        /*
        * Collections接口中的常用方法：
        * add(Object obj),addAll(Collection coll),size(),isEmpty(),clear();
         contains(Object obj),containsAll(Collection coll),remove(Object obj),removeAll(Collection coll),retainsAll(Collection coll),equals(Object obj);
         hasCode(),toArray(),iterator();
        * */
    }

    @Test
    public void test3(){
        /*
        * Collections集合与数组之间的相互转换
        *
        * */
        ArrayList<Integer> integers = new ArrayList<>();
        Object[] objects = integers.toArray();

        List<Integer> integers1 = Arrays.asList(1, 2, 3);
        System.out.println(integers1);
    }

    @Test
    public void test4(){
        /*
        * 4.使用Collection集合存储对象，要求对象所属的类满足：
        向Collection接口的实现类的对象中添加数据obj时，要求obj所在类要重写equals().
        *
        * 1.遍历Collection的两种方式：
        ① 使用迭代器Iterator  ② foreach循环（或增强for循环）
        2.java.utils包下定义的迭代器接口：Iterator
        2.1说明：
        Iterator对象称为迭代器(设计模式的一种)，主要用于遍历 Collection 集合中的元素。
         GOF给迭代器模式的定义为：提供一种方法访问一个容器(container)对象中各个元素，而又不需暴露该对象的内部细节。迭代器模式，就是为容器而生。
        2.2作用：遍历集合Collectiton元素
        2.3如何获取实例：coll.iterator()返回一个迭代器实例
        2.4遍历的代码实现：
        Iterator iterator = coll.iterator();
        //hasNext():判断是否还下一个元素
        while(iterator.hasNext()){
            //next():①指针下移 ②将下移以后集合位置上的元素返回
            System.out.println(iterator.next());
        }
        * */
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        for (Integer i :
                list) {
            System.out.println(i);
        }
        System.out.println();
        // 方法引用
        list.forEach(System.out::println);
    }

    @Test
    public void test5(){
        /*
       //测试Iterator中的remove()
        //如果还未调用next()或在上一次调用 next 方法之后已经调用了 remove 方法，再调用remove都会报IllegalStateException。
        //内部定义了remove(),可以在遍历的时候，删除集合中的元素。此方法不同于集合直接调用remove()
        * */
        class Person{
            String name;
            int age;

            public Person(String name, int age) {
                this.name = name;
                this.age = age;
            }

            @Override
            public String toString() {
                return "Person{" +
                        "name='" + name + '\'' +
                        ", age=" + age +
                        '}';
            }
        }
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry",20));
        coll.add(new String("Tom"));
        coll.add(false);

        //删除集合中"Tom"
        Iterator iterator = coll.iterator();
        while (iterator.hasNext()){
//            iterator.remove();
            Object obj = iterator.next();
            if("Tom".equals(obj)){
                iterator.remove();
//                iterator.remove();
            }

        }
        //遍历集合
        iterator = coll.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
