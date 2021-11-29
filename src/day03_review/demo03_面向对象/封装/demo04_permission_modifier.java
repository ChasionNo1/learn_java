package day03_review.demo03_面向对象.封装;
/*
封装性的体现，需要权限修饰符来配合
1、四种权限修饰符：private\缺省(default)\protected\public
private:；类内部
default:类内部、同一个包
protected:类内部、同一个包、不同包的子类
public:类内部、同一个包、不同包的子类、同一个工程

2、4种权限修饰符可以用来修饰类及类的内部结构：属性、方法、构造器、内部类

3、4种权限修饰符都可以用类的内部结构：属性、方法、构造器、内部类
    修饰类的话，只能是default和public


* */
public class demo04_permission_modifier {
    private int orderPrivate;
    int order;
    protected int orderProtecetd;
    public int orderPublic;
    private void methodPrivate(){
        orderPrivate = 1;
        order = 2;
        orderProtecetd = 3;
         orderPublic = 4;
    }
    void methodDefault(){
        orderPrivate = 1;
        order = 2;
        orderProtecetd = 3;
        orderPublic = 4;
    }
    public void methodPublic(){
        orderPrivate = 1;
        order = 2;
        orderProtecetd = 3;
        orderPublic = 4;
    }
}
