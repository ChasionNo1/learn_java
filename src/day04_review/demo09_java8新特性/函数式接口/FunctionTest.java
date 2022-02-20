package day04_review.demo09_java8新特性.函数式接口;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * * java内置的4大核心函数式接口
 *  *
 *  * 消费型接口 Consumer<T>     void accept(T t)
 *  * 供给型接口 Supplier<T>     T get()
 *  * 函数型接口 Function<T,R>   R apply(T t)
 *  * 断定型接口 Predicate<T>    boolean test(T t)
 *
 * @program: test
 * @author: chasion
 * @create: 2022-01-17 20:00
 */
public class FunctionTest {
    @Test
    public void test1(){
        happyTime(500, new Consumer<Double>() {
            @Override
            public void accept(Double aDouble) {
                System.out.println("消费了" + aDouble);
            }
        });

        System.out.println("--------");

        happyTime(400, money -> System.out.println("消费了" + money));
    }

    public void happyTime(double money, Consumer<Double> consumer){
        consumer.accept(money);
    }

    @Test
    public void test2(){
        List<String> list = Arrays.asList("北京","南京","天津","东京","西京","普京");
        List<String> filter = filterString(list, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("京");
            }
        });
        System.out.println(filter);

        List<String> filter1 = filterString(list, s -> s.contains("京"));
        System.out.println(filter1);

    }

    //根据给定的规则，过滤集合中的字符串。此规则由Predicate的方法决定
    public List<String> filterString(List<String> list, Predicate<String> predicate){
        ArrayList<String> strings = new ArrayList<>();
        for (String s :
                list) {
            if (predicate.test(s)){
                strings.add(s);
            }
        }
        return strings;
    }

    @Test
    public void test3(){
        Supplier<Integer> integerSupplier = new Supplier<Integer>() {
            @Override
            public Integer get() {
                return 12;
            }
        };
        Integer integer = integerSupplier.get();
        System.out.println(integer);
    }
}
