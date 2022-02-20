package day04_review.demo09_java8新特性.Lambda表达式;

import org.testng.annotations.Test;

import java.util.Comparator;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-01-17 18:43
 */
public class LambdaTest {

    @Test
    public void test1() {
        // 匿名内部类，实现接口
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("aaa");
            }
        };

        runnable.run();
        System.out.println("---------");

        Runnable runnable1 = () -> System.out.println("bbb");
        runnable1.run();
    }

    @Test
    public void test2() {
        Comparator<Integer> integerComparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };

        int result1 = integerComparator.compare(12, 34);
        System.out.println(result1);

        Comparator<Integer> comparator = (o1, o2) -> Integer.compare(o1, o2);
        System.out.println(comparator.compare(23, 12));

        // 方法引用
        Comparator<Integer> comparator1 = Integer::compare;
        System.out.println(comparator1.compare(23, 12));
    }

}
