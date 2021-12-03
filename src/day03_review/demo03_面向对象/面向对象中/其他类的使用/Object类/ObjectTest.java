package day03_review.demo03_面向对象.面向对象中.其他类的使用.Object类;
/*
java.lang.Object类
是所有java类的根父类
如果在类的声明中未使用extends关键字指明其父类，则默认父类为Object类
Object类中的功能（属性、方法）具有通用性
属性：无
方法：equals()/toString()/getClass()/hashCode()/clone()/finalize()/wait()/notify()/notifyAll()
Object类只声明了一个空参的构造器

* */
public class ObjectTest {
    public static void main(String[] args) {
        Order order = new Order();
//        class java.lang.Object
        System.out.println(order.getClass().getSuperclass());
    }
}

class Order{

}