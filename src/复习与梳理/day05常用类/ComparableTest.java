package 复习与梳理.day05常用类;

import org.testng.annotations.Test;

import java.util.Comparator;

/**
 * java中的比较器
 * comparable \ comparator
 * Java中的对象，正常情况下，只能进行比较：==  或  != 。不能使用 > 或 < 的
 * 但是在开发场景中，我们需要对多个对象进行排序，言外之意，就需要比较对象的大小。
 * 如何实现？使用两个接口中的任何一个：Comparable 或 Comparator
 * @Description TODO
 * @Author chasion
 * @Date 2022/1/26 20:54
 **/
public class ComparableTest {

    @Test
    public void test1(){
        /*
        * 2.自然排序：使用Comparable接口
        2.1 说明
        1.像String、包装类等实现了Comparable接口，重写了compareTo(obj)方法，给出了比较两个对象大小的方式。
        2.像String、包装类重写compareTo()方法以后，进行了从小到大的排列
        3. 重写compareTo(obj)的规则：
            如果当前对象this大于形参对象obj，则返回正整数，
            如果当前对象this小于形参对象obj，则返回负整数，
            如果当前对象this等于形参对象obj，则返回零。
        4. 对于自定义类来说，如果需要排序，我们可以让自定义类实现Comparable接口，重写compareTo(obj)方法。在compareTo(obj)方法中指明如何排序
        * */
    }

    @Test
    public void test2(){
        /*
        * 3.定制排序：使用Comparator接口
        3.1 说明
        1.背景：
        当元素的类型没实现java.lang.Comparable接口而又不方便修改代码，或者实现了java.lang.Comparable接口的排序规则不适合当前的操作，
        那么可以考虑使用 Comparator 的对象来排序
        2.重写compare(Object o1,Object o2)方法，比较o1和o2的大小：
        如果方法返回正整数，则表示o1大于o2；
        如果返回0，表示相等；
        返回负整数，表示o1小于o2。
        *
        comparable接口的方式一旦一定，保证Comparable接口实现类的对象在任何位置都可以比较大小。
        Comparator接口属于临时性的比较。
        * */
        Comparator com = new Comparator() {
            //指明商品比较大小的方式:照产品名称从低到高排序,再照价格从高到低排序
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof Goods && o2 instanceof Goods){
                    Goods g1 = (Goods)o1;
                    Goods g2 = (Goods)o2;
                    if(g1.getName().equals(g2.getName())){
                        return -Double.compare(g1.getPrice(),g2.getPrice());
                    }else{
                        return g1.getName().compareTo(g2.getName());
                    }
                }
                throw new RuntimeException("输入的数据类型不一致");
            }
        };
        Comparator<Goods> comparator = Comparator.comparing(Goods::getName);
    }
}

class Goods implements  Comparable{

    private String name;
    private double price;

    //指明商品比较大小的方式:照价格从低到高排序,再照产品名称从高到低排序
    @Override
    public int compareTo(Object o) {
//        System.out.println("**************");
        if(o instanceof Goods){
            Goods goods = (Goods)o;
            //方式一：
            if(this.price > goods.price){
                return 1;
            }else if(this.price < goods.price){
                return -1;
            }else{
//                return 0;
                return -this.name.compareTo(goods.name);
            }
            //方式二：
//           return Double.compare(this.price,goods.price);
        }
//        return 0;
        throw new RuntimeException("传入的数据类型不一致！");
    }
// getter、setter、toString()、构造器：省略

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
