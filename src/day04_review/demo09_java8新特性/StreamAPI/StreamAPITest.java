package day04_review.demo09_java8新特性.StreamAPI;

import day04_review.demo09_java8新特性.方法引用与构造器引用.Employee;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * * 1. Stream关注的是对数据的运算，与CPU打交道
 * *    集合关注的是数据的存储，与内存打交道
 * *
 * * 2.
 * * ①Stream 自己不会存储元素。
 * * ②Stream 不会改变源对象。相反，他们会返回一个持有结果的新Stream。
 * * ③Stream 操作是延迟执行的。这意味着他们会等到需要结果的时候才执行
 * *
 * * 3.Stream 执行流程
 * * ① Stream的实例化
 * * ② 一系列的中间操作（过滤、映射、...)
 * * ③ 终止操作
 * *
 * * 4.说明：
 * * 4.1 一个中间操作链，对数据源的数据进行处理
 * * 4.2 一旦执行终止操作，就执行中间操作链，并产生结果。之后，不会再被使用
 * *
 * *
 * *  测试Stream的实例化
 *
 * @Description TODO
 * @Author chasion
 * @Date 2022/1/19 19:23
 **/
public class StreamAPITest {

    @Test
    public void test1() {
        // 创建Stream的方式一:通过集合
        List<Employee> employees = EmployeeData.getEmployees();
        //        default Stream<E> stream() : 返回一个顺序流
        Stream<Employee> stream = employees.stream();
//        default Stream<E> parallelStream() : 返回一个并行流
        Stream<Employee> employeeStream = employees.parallelStream();

    }

    @Test
    public void test2() {
        // 创建Stream的方式二：通过数组
        int[] arr = new int[]{1, 2, 3, 4};
        //调用Arrays类的static <T> Stream<T> stream(T[] array): 返回一个流
        IntStream stream = Arrays.stream(arr);

        Employee tom = new Employee(1001, "TOM");
        Employee jack = new Employee(1002, "jack");
        Employee[] employees = {tom, jack};
        // 带泛型
        Stream<Employee> stream1 = Arrays.stream(employees);
    }

    @Test
    public void test3(){
        //创建 Stream方式三：通过Stream的of()
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 6);

    }

    @Test
    public void test4(){
        // 创建 Stream方式四：创建无限流
        //      迭代
//      public static<T> Stream<T> iterate(final T seed, final UnaryOperator<T> f)
        //遍历前10个偶数
        Stream.iterate(0, t -> t+2).limit(10).forEach(System.out::println);

        //      生成
//      public static<T> Stream<T> generate(Supplier<T> s)
        Stream.generate(Math::random).limit(10).forEach(System.out::println);
    }
}
