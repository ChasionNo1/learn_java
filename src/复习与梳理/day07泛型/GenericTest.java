package 复习与梳理.day07泛型;

import day04_review.demo05_泛型.泛型在继承上的使用.Person;
import day04_review.demo05_泛型.泛型在继承上的使用.Student;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 泛型的使用
 *
 * @Description TODO
 * @Author chasion
 * @Date 2022/1/27 21:11
 **/
public class GenericTest {

    @Test
    public void test1(){
        /*
        1.泛型的概念
        所谓泛型，就是允许在定义类、接口时通过一个标识表示类中某个属性的类型或者是某个方法的返
        回值及参数类型。这个类型参数将在使用时（例如，继承或实现这个接口，用这个类型声明变量、
        创建对象时确定（即传入实际的类型参数，也称为类型实参）。

        2.泛型的引入背景
        集合容器类在设计阶段/声明阶段不能确定这个容器到底实际存的是什么类型的对象，
        所以在JDK1.5之前只能把元素类型设计为Object，JDK1.5之后使用泛型来解决。
        因为这个时候除了元素的类型不确定，其他的部分是确定的，例如关于这个元素如何保存，
        如何管理等是确定的，因此此时把元素的类型设计成一个参数，这个类型参数叫做泛型。
        Collection<E>，List<E>，ArrayList<E>   这个<E>就是类型参数，即泛型。

        泛型在集合中的使用：
        *  ① 集合接口或集合类在jdk5.0时都修改为带泛型的结构。
        *  ② 在实例化集合类时，可以指明具体的泛型类型
        *  ③ 指明完以后，在集合类或接口中凡是定义类或接口时，内部结构（比如：方法、构造器、属性等）使用到类的泛型的位置，
            都指定为实例化的泛型类型。比如：add(E e)  --->实例化以后：add(Integer e)
        *  ④ 注意点：泛型的类型必须是类，不能是基本数据类型。需要用到基本数据类型的位置，拿包装类替换
        *  ⑤ 如果实例化时，没指明泛型的类型。默认类型为java.lang.Object类型。
        * */
    }

    @Test
    public void test2(){
        /*
        自定义泛型类、泛型接口、泛型方法

        注意：
        1、泛型类可能有多个参数，此时应将多个参数一起放在尖括号内。比如：Entry<K,V>
        2、泛型类的构造器如下：public GenericClass(){},构造器不带泛型结构
        3、实例化后，操作原来泛型位置的结构必须与指定的泛型类型一致
        4、泛型不同的引用不能相互赋值，尽管在编译时ArrayList<String>和ArrayList<Integer>是两种类型，但是，在运行时只有一个ArrayList
           被加载到JVM中
        5、泛型如果不指定，将被擦除，泛型对应的类型按照Object处理，但不等价与Object。经验：泛型要是使用，就用到底，要么就不用
        6、如果泛型结构是一个结构或抽象类，则不可以创建泛型类的对象
        7、jdk1.7，泛型的简化操作，自动类型推断
        8、泛型的指定中不能使用基本数据类型，使用包装类替换
        9、在类、接口上声明的泛型，在本类或本接口中即代表某种类型，可以作为非静属性的类型、非静态方法的参数类型、非静态方法的返回值。但在
           静态方法中不能使用类的泛型
        10、异常类不能是泛型的
        11、不能使用new E[]，但是可以：E[] elements = (E[])new Object[capacity];
            参考：ArrayList源码中声明：Object[] elementData,而非泛型参数类型数组。
        12、父类有泛型，子类可以选择保留泛型，也可以选择指定泛型类型；
            子类不保留父类的泛型:按需实现
            没有类型 擦除
            具体类型
            子类保留父类的泛型：泛型子类
            全部保留
            部分保留
            结论：子类必须是“富二代”，子类除了指定或者保留父类的泛型，还可以增加自己的泛型
        13、应用场景：DAO,data access operator

        * */
    }

    @Test
    public void test3(){
        /*
        通配符的使用：
        通配符：?
        类A是类B的父类，G<A>和G<B>是没有关系的，二者共同的父类是：G<?>
        * */
        List<Object> list1 = null;
        List<String> list2 = null;

        List<?> list = null;

        list = list1;
        list = list2;
        //编译通过
//        print(list1);
//        print(list2);
        //
        List<String> list3 = new ArrayList<>();
        list3.add("AA");
        list3.add("BB");
        list3.add("CC");
        list = list3;
        //添加(写入)：对于List<?>就不能向其内部添加数据。
        //除了添加null之外。
//        list.add("DD");
//        list.add('?');

        list.add(null);

        //获取(读取)：允许读取数据，读取的数据类型为Object。
        Object o = list.get(0);
        System.out.println(o);

    }

    @Test
    public void test4(){
         /*
            3.有限制条件的通配符的使用。
                ? extends A:   ?小于等于A
                        G<? extends A> 可以作为G<A>和G<B>的父类，其中B是A的子类

                ? super A:    ?大于等于A
                        G<? super A> 可以作为G<A>和G<B>的父类，其中B是A的父类

               带有超类型限定的通配符允许写入一个泛型对象
               带有子类型限定的通配符允许读取一个泛型对象
             */
        List<? extends Person> list1 = null;
        List<? super Person> list2 = null;

        List<Student> list3 = new ArrayList<Student>();
        List<Person> list4 = new ArrayList<Person>();
        List<Object> list5 = new ArrayList<Object>();

        list1 = list3;
        list1 = list4;
//        list1 = list5;

//        list2 = list3;
        list2 = list4;
        list2 = list5;

        //读取数据：
        list1 = list3;
        Person p = list1.get(0);
        //编译不通过，
        //Student s = list1.get(0);
        // 直接将父类赋值给子类不行，加上强转可以
        Person p1 = new Person();
        Student t = null;
        t = (Student) p1;

        list2 = list4;
        Object obj = list2.get(0);
        ////编译不通过， list中最小类为Person，当大类赋值给小类时，需要强转，不能直接赋值
//        Person obj = list2.get(0);

        //写入数据：
        //编译不通过
//        list1.add(new Student());

        //编译通过
        list2.add(new Person());
        list2.add(new Student());
        // 编译不通过
//        list2.add(new Object());
    }
}

class Order<T>{
    String orderName;
    int orderID;

    public Order(String orderName, int orderID) {
        this.orderName = orderName;
        this.orderID = orderID;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderName='" + orderName + '\'' +
                ", orderID=" + orderID +
                '}';
    }

    //泛型方法：在方法中出现了泛型的结构，泛型参数与类的泛型参数没有任何关系。
    //换句话说，泛型方法所属的类是不是泛型类都没有关系。
    //泛型方法，可以声明为静态的。原因：泛型参数是在调用方法时确定的。并非在实例化类时确定。
    public static <E> List<E> copyFromArrayToList(E[] arr){

        ArrayList<E> list = new ArrayList<>();

        for(E e : arr){
            list.add(e);
        }
        return list;

    }

}
