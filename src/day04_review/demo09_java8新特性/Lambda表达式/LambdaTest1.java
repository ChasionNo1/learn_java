package day04_review.demo09_java8新特性.Lambda表达式;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Consumer;

/**
 *
 *  * Lambda表达式的使用
 *  *
 *  * 1.举例： (o1,o2) -> Integer.compare(o1,o2);
 *  * 2.格式：
 *  *      -> :lambda操作符 或 箭头操作符
 *  *      ->左边：lambda形参列表 （其实就是接口中的抽象方法的形参列表）
 *  *      ->右边：lambda体 （其实就是重写的抽象方法的方法体）
 *  *
 *  * 3. Lambda表达式的使用：（分为6种情况介绍）
 *  *
 *  *    总结：
 *  *    ->左边：lambda形参列表的参数类型可以省略(类型推断)；如果lambda形参列表只有一个参数，其一对()也可以省略
 *  *    ->右边：lambda体应该使用一对{}包裹；如果lambda体只有一条执行语句（可能是return语句），省略这一对{}和return关键字
 *  *
 *  * 4.Lambda表达式的本质：作为函数式接口的实例
 *  *
 *  * 5. 如果一个接口中，只声明了一个抽象方法，则此接口就称为函数式接口。我们可以在一个接口上使用 @FunctionalInterface 注解，
 *  *   这样做可以检查它是否是一个函数式接口。
 *  *
 *  * 6. 所以以前用匿名实现类表示的现在都可以用Lambda表达式来写。
 *
 * @program: test
 * @author: chasion
 * @create: 2022-01-17 18:51
 */
public class LambdaTest1 {

    @Test
    public void test1(){
        // 语法格式一：无参、无返回值
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("aaa");
            }
        };
        r1.run();

        System.out.println("--------");

        Runnable r2 = () -> {
            System.out.println("bbb");
        };
        r2.run();
    }

    @Test
    public void test2(){
        // 语法格式二：需要一个参数、但是没有返回值
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        consumer.accept("ccc");

        System.out.println("----------");

        Consumer<String> consumer1 = (String str) -> {
            System.out.println(str);
        };
        consumer1.accept("ddd");
    }

    @Test
    public void test3(){
        //语法格式三：数据类型可以省略，因为可由编译器推断得出，称为“类型推断”
        ArrayList<Integer> integers = new ArrayList<>();
        int[] arr = {1, 23, 4};

        Consumer<String> consumer = (String str) -> System.out.println(str);
        consumer.accept("ggg");

        Consumer<String> consumer1 = (s) -> System.out.println(s);
        consumer1.accept("hhh");
    }

    @Test
    public void test4(){
        //语法格式四：Lambda 若只需要一个参数时，参数的小括号可以省略
        Consumer<String> consumer = (s) -> {
            System.out.println(s);
        };
        consumer.accept("eee");
        System.out.println("--------");

        Consumer<String> consumer1 = s -> {
            System.out.println(s);
        };
        consumer1.accept("fff");
    }

    @Test
    public void test5(){
        //语法格式五：Lambda 需要两个或以上的参数，多条执行语句，并且可以有返回值
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        int result = comparator.compare(12, 45);
        System.out.println(result);

        Comparator<Integer> comparator1 = (o1, o2) -> {
            return Integer.compare(o1, o2);
        };
        int result2 = comparator1.compare(12, 34);
        System.out.println(result2);
    }

    @Test
    public void test6(){
        //语法格式六：当 Lambda 体只有一条语句时，return 与大括号若有，都可以省略
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        comparator.compare(12, 42);

        Comparator<Integer> comparator1 = ((o1, o2) -> Integer.compare(o1, o2));
        comparator1.compare(122,42);
    }
}
