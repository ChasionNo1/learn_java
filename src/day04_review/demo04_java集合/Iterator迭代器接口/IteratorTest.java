package day04_review.demo04_java集合.Iterator迭代器接口;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

/**
 * 迭代器的使用：
 * 集合对象每次调用iterator()方法都得到一个全新的迭代器对象，默认游标都在集合
 * 的第一个元素之前。
 *
 *
 * @program: test
 * @author: chasion
 * @create: 2022-01-05 10:42
 */
public class IteratorTest {

    @Test
    public void test1() {
        Collection collection = new ArrayList();
        collection.add("aa");
        collection.add("bb");
        collection.add(123);
        collection.add(new Date());

        Iterator iterator = collection.iterator();
        System.out.println(iterator.next());

        while (iterator.hasNext()) {
            // next()：指针下移，将下移以后集合位置上的元素返回
            System.out.println(iterator.next());
        }
        // 此时，迭代器指针已经到了最后了，如果需要重新遍历，再重新定义一个迭代器使用


    }

    @Test
    public void test2(){
        /*
        Iterator可以删除集合的元素，但是是遍历过程中通过迭代器对象的remove方
        法，不是集合对象的remove方法。

        如果还未调用next()或在上一次调用 next 方法之后已经调用了 remove 方法，
        再调用remove都会报IllegalStateException。
        * */
        Collection collection = new ArrayList();
        collection.add("aa");
        collection.add("bb");
        collection.add(123);
        collection.add(new Date());

        Iterator iterator = collection.iterator();
        while (iterator.hasNext()){
            Object obj = iterator.next();
            if ("aa".equals(obj)){
                System.out.println(1111);
                iterator.remove();
            }
        }

        Iterator iterator1 = collection.iterator();
        while (iterator1.hasNext()){
            System.out.println(iterator1.next());
        }
    }
}
