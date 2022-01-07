package day04_review.demo05_泛型.自定义泛型;

import com.sun.org.apache.xpath.internal.operations.Or;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 如何自定义泛型结构：泛型类、泛型接口；泛型方法。
 * 1. 关于自定义泛型类、泛型接口：
 * @program: test
 * @author: chasion
 * @create: 2022-01-07 20:23
 */
public class GenericTest {

    @Test
    public void test1(){
        //如果定义了泛型类，实例化没有指明类的泛型，则认为此泛型类型为Object类型
        //要求：如果大家定义了类是带泛型的，建议在实例化时要指明类的泛型。
        Order order = new Order();
        order.setOrderT(123);
        order.setOrderT("aa");

        //建议：实例化时指明类的泛型
        Order<String> stringOrder = new Order<>();
        stringOrder.setOrderT("aa:order");

    }

    @Test
    public void test2(){
        //由于子类在继承带泛型的父类时，指明了泛型类型。则实例化子类对象时，不再需要指明泛型。
        SubOrder subOrder = new SubOrder();
        subOrder.setOrderT(1233);

        SubOrder1<String> stringSubOrder1 = new SubOrder1<>();
        stringSubOrder1.setOrderT("asaf");

    }

    @Test
    public void test3(){

        ArrayList<String> list1 = null;
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        //泛型不同的引用不能相互赋值。
//        list1 = list2;

    }
    @Test
    public void test4(){
        Order<String> order = new Order<>();
        Integer[] integers = {1, 2, 3};
        List<Integer> integers1 = order.copyFromArrayToList(integers);
        System.out.println(integers1);
    }

}
