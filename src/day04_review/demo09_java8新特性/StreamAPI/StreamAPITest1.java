package day04_review.demo09_java8新特性.StreamAPI;

import day04_review.demo09_java8新特性.方法引用与构造器引用.Employee;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Stream;

/**
 * @Author:chasion
 * @Date:2022/1/20 14:15
 * @Description:
 * 测试Stream的中间操作
 *
 */
public class StreamAPITest1 {

    @Test
    public void test1(){
        //1-筛选与切片
        List<Employee> employees = EmployeeData.getEmployees();
        Stream<Employee> stream = employees.stream();
        //        filter(Predicate p)——接收 Lambda ， 从流中排除某些元素。
        //练习：查询员工表中薪资大于7000的员工信息
        stream.filter(e -> e.getSalary() > 7000).forEach(System.out::println);
        System.out.println();

        //        limit(n)——截断流，使其元素不超过给定数量。
        employees.stream().limit(3).forEach(System.out::println);

        //        skip(n) —— 跳过元素，返回一个扔掉了前 n 个元素的流。若流中元素不足 n 个，则返回一个空流。与 limit(n) 互补
        employees.stream().skip(3).forEach(System.out::println);

        //        distinct()——筛选，通过流所生成元素的 hashCode() 和 equals() 去除重复元素
        employees.add(new Employee(1010,"刘强东",40,8000));
        employees.add(new Employee(1010,"刘强东",41,8000));
        employees.add(new Employee(1010,"刘强东",40,8000));
        employees.add(new Employee(1010,"刘强东",40,8000));
        employees.add(new Employee(1010,"刘强东",40,8000));
        employees.stream().distinct().forEach(System.out::println);
    }

    // 映射
    @Test
    public void test2(){
        //        map(Function f)——接收一个函数作为参数，将元素转换成其他形式或提取信息，该函数会被应用到每个元素上，并将其映射成一个新的元素。
        List<String> strings = Arrays.asList("aa", "bb", "cc", "dd");
        strings.stream().map(str -> str.toUpperCase(Locale.ROOT)).forEach(System.out::println);

//        练习1：获取员工姓名长度大于3的员工的姓名。
        List<Employee> employees = EmployeeData.getEmployees();
        Stream<String> stringStream = employees.stream().map(Employee::getName);
        stringStream.filter(name -> name.length() > 3).forEach(System.out::println);
        System.out.println();
        //练习2：
        //        flatMap(Function f)——接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流。
        Stream<Stream<Character>> streamStream = strings.stream().map(StreamAPITest1::fromStrToStream);
        streamStream.forEach(s -> s.forEach(System.out::println));
        System.out.println();

        Stream<Character> characterStream = strings.stream().flatMap(StreamAPITest1::fromStrToStream);
        characterStream.forEach(System.out::println);
    }
    //将字符串中的多个字符构成的集合转换为对应的Stream的实例
    public static Stream<Character> fromStrToStream(String str){
        ArrayList<Character> list = new ArrayList<>();
        for (Character c :
                str.toCharArray()) {
            list.add(c);
        }
        return list.stream();
    }

    // 3 排序
    @Test
    public void test3(){
        //        sorted()——自然排序
        List<Integer> list = Arrays.asList(1, 98, 23, -8, 29, 53);
        list.stream().sorted().forEach(System.out::println);
        //抛异常，原因:Employee没有实现Comparable接口
//        List<Employee> employees = EmployeeData.getEmployees();
//        employees.stream().sorted().forEach(System.out::println);
        //        sorted(Comparator com)——定制排序
        List<Employee> employees = EmployeeData.getEmployees();
//        employees.stream().sorted((e1, e2) -> Integer.compare(e1.getAge(), e2.getAge())).forEach(System.out::println);
        employees.stream().sorted((e1, e2) -> {
            int intAge = Integer.compare(e1.getAge(), e2.getAge());
            if (intAge != 0){
                return intAge;
            }else {
                return Double.compare(e1.getSalary(), e2.getSalary());
            }
        }).forEach(System.out::println);
    }
}
