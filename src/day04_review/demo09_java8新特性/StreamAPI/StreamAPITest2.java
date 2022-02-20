package day04_review.demo09_java8新特性.StreamAPI;

import day04_review.demo09_java8新特性.方法引用与构造器引用.Employee;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author:chasion
 * @Date:2022/1/20 18:15
 * @Description:
 *  * 测试Stream的终止操作
 */
public class StreamAPITest2 {

    @Test
    public void test1(){
        // 1-匹配与查找
        List<Employee> employees = EmployeeData.getEmployees();

        //        allMatch(Predicate p)——检查是否匹配所有元素。
        //          练习：是否所有的员工的年龄都大于18
        boolean allMatch = employees.stream().allMatch(e -> e.getAge() > 18);
        System.out.println(allMatch);

        //        anyMatch(Predicate p)——检查是否至少匹配一个元素。
        //         练习：是否存在员工的工资大于 10000
        boolean anyMatch = employees.stream().allMatch(e -> e.getSalary() > 10000);
        System.out.println(anyMatch);

        //        noneMatch(Predicate p)——检查是否没有匹配的元素。
//          练习：是否存在员工姓“雷”
        boolean noneMatch = employees.stream().noneMatch(employee -> employee.getName().startsWith("雷"));
        System.out.println(noneMatch);

        //        findFirst——返回第一个元素
        Optional<Employee> first = employees.stream().findFirst();
        System.out.println(first);

        //        findAny——返回当前流中的任意元素
        Optional<Employee> any = employees.stream().findAny();
        System.out.println(any);
    }

    @Test
    public void test2(){
        // count——返回流中元素的总个数
        List<Employee> employees = EmployeeData.getEmployees();
        long count = employees.stream().filter(employee -> employee.getSalary() > 5000).count();
        System.out.println(count);
//        max(Comparator c)——返回流中最大值
//        练习：返回最高的工资：
        Stream<Double> salaryStream = employees.stream().map(employee -> employee.getSalary());
        Optional<Double> max = salaryStream.max(Double::compareTo);
        System.out.println(max);
        //        min(Comparator c)——返回流中最小值
//        练习：返回最低工资的员工
        Stream<Double> doubleStream = employees.stream().map(Employee::getSalary);
        Optional<Double> min = doubleStream.min(Double::compareTo);
        System.out.println(min);

        //        forEach(Consumer c)——内部迭代
        employees.stream().forEach(System.out::println);
        //使用集合的遍历操作
        employees.forEach(System.out::println);
    }

    //2-归约
    @Test
    public void test3(){
        //        reduce(T identity, BinaryOperator)——可以将流中元素反复结合起来，得到一个值。返回 T
//        练习1：计算1-10的自然数的和
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        Integer sum1 = list.stream().reduce(0, Integer::sum);
        System.out.println(sum1);
        //        reduce(BinaryOperator) ——可以将流中元素反复结合起来，得到一个值。返回 Optional<T>
//        练习2：计算公司所有员工工资的总和
        List<Employee> employees = EmployeeData.getEmployees();
        Stream<Double> salaryStream = employees.stream().map(Employee::getSalary);
        Optional<Double> sum2 = salaryStream.reduce(Double::sum);
        System.out.println(sum2);

        Optional<Double> sum3 = employees.stream().map(Employee::getSalary).reduce((d1, d2) -> d1 + d2);
        System.out.println(sum3.get());

    }

    //3-收集
    @Test
    public void test4(){
        //        collect(Collector c)——将流转换为其他形式。接收一个 Collector接口的实现，用于给Stream中元素做汇总的方法
//        练习1：查找工资大于6000的员工，结果返回为一个List或Set
        List<Employee> employees = EmployeeData.getEmployees();
        List<Employee> employeeList = employees.stream().filter(employee -> employee.getSalary() > 6000).collect(Collectors.toList());
        employeeList.forEach(System.out::println);
        System.out.println();
        Set<Employee> employeeSet = employees.stream().filter(employee -> employee.getSalary() > 6000).collect(Collectors.toSet());
        employeeSet.forEach(System.out::println
        );


    }
}
