package day04_review.demo04_java集合.集合框架概述;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.testng.annotations.Test;

import java.util.*;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-01-04 20:38
 *
 * 一、集合框架的概述
 *  *
 *  * 1.集合、数组都是对多个数据进行存储操作的结构，简称Java容器。
 *  *  说明：此时的存储，主要指的是内存层面的存储，不涉及到持久化的存储（.txt,.jpg,.avi，数据库中）
 *  *
 *  * 2.1 数组在存储多个数据方面的特点：
 *  *      > 一旦初始化以后，其长度就确定了。
 *  *      > 数组一旦定义好，其元素的类型也就确定了。我们也就只能操作指定类型的数据了。
 *  *       比如：String[] arr;int[] arr1;Object[] arr2;
 *  * 2.2 数组在存储多个数据方面的缺点：
 *  *      > 一旦初始化以后，其长度就不可修改。
 *  *      > 数组中提供的方法非常有限，对于添加、删除、插入数据等操作，非常不便，同时效率不高。
 *  *      > 获取数组中实际元素的个数的需求，数组没有现成的属性或方法可用
 *  *      > 数组存储数据的特点：有序、可重复。对于无序、不可重复的需求，不能满足。
 *  *
 *  * 二、集合框架
 *  *      |----Collection接口：单列集合，用来存储一个一个的对象
 *  *          |----List接口：存储有序的、可重复的数据。  -->“动态”数组
 *  *              |----ArrayList、LinkedList、Vector
 *  *
 *  *          |----Set接口：存储无序的、不可重复的数据   -->高中讲的“集合”
 *  *              |----HashSet、LinkedHashSet、TreeSet
 *  *
 *  *      |----Map接口：双列集合，用来存储一对(key - value)一对的数据   -->高中函数：y = f(x)
 *  *              |----HashMap、LinkedHashMap、TreeMap、Hashtable、Properties
 *  *
 *  *
 *  * 三、Collection接口中的方法的使用
 */
public class CollectionTest {

    @Test
    public void test1(){
        Collection collection = new ArrayList();
        // 1、add(Object e):将元素e添加到集合中
        // 向Collection接口的实现类的对象中添加数据obj时，要求obj所在类要重写equals方法
        collection.add("aa");
        collection.add("bb");
        collection.add(123);
        collection.add(new Date());

        // 2、size():获取添加元素的个数
        System.out.println(collection.size());

        // 3、addAll(Collection coll1):将coll1集合中的元素添加到当前的集合中
        Collection collection1 = new ArrayList();
        collection1.add("cc");
        collection1.add(234);
        collection.addAll(collection1);

        System.out.println(collection.size());
        System.out.println(collection);

        collection.addAll(collection);
        System.out.println(collection);

        // 4、clear()：清空集合元素
        collection.clear();

        // 5、isEmpty():判断当前集合是否为空
        System.out.println(collection.isEmpty());

        // 6、contains(Object obj):判断当前集合中是否包含obj
        // 我们在判断时会调用obj对象所在类的equals()
        boolean b = collection.contains(123);
        System.out.println(b);

        collection.add(new String("tom"));
        System.out.println(collection.contains(new String("tom")));

        collection.add(new Person("tom",  23));
        System.out.println(collection.contains(new Person("tom",  23)));

        // 7、containsAll(Collection coll):判断形参中的所有元素是否在当前的集合中
        Collection collection2 = Arrays.asList(123, 234, 345);
        System.out.println(collection.containsAll(collection2));

        // 8、remove(Object obj):从当前集合中移除obj元素，如果有返回true
        collection.remove(123);
        System.out.println(collection);

        // 9、removeAll(Collection coll):从当前集合移除coll中所有的元素
        Collection collection3 = Arrays.asList(123, 234);
        collection.removeAll(collection3);
        System.out.println(collection2);

        // 10. retainAll(Collection c):把交集的结果存在当前集合中，不影响c
        collection.retainAll(collection2);
        System.out.println(collection);

        //10. equals(Object obj):当前集合与形参集合元素都相同，才返回true
        Collection collection4 = new ArrayList();
        collection4.add(123);
        collection4.add(234);
        System.out.println(collection.equals(collection4));

        //11. hashCode():返回集合对象的哈希值
        System.out.println(collection.hashCode());

        //12. toArray():转换成对象数组
        Object[] objects = collection.toArray();

        // 13. array --> collection
        List<String> strings = Arrays.asList("AA", "BB");
        System.out.println(strings);

        List<int[]> ints = Arrays.asList(new int[]{123, 234});// 将整个数组作为一个元素
        System.out.println(ints.size());
        System.out.println(ints);
        List<Integer> integers = Arrays.asList(123, 234);
        System.out.println(integers.size());

        // 14.iterator():返回迭代器对象，用于集合遍历


    }
}
