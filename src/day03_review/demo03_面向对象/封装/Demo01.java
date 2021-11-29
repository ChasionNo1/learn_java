package day03_review.demo03_面向对象.封装;
/*
程序设计：高内聚、低耦合
高内聚 ：类的内部数据操作细节自己完成，不允许外部干涉；
低耦合 ：仅对外暴露少量的方法用于使用。

隐藏对象内部的复杂性，只对外公开简单的接口。便于外界调用，从而提
高系统的可扩展性、可维护性。通俗的说，把该隐藏的隐藏起来，该暴露
的暴露出来。这就是封装性的设计思想。


封装的步骤：
1、使用private关键字修饰成员变量
2、对需要访问的成员变量，提供一对get和set方法

private的含义：
1、private是一个权限修饰符，代表最小权限
2、可以修饰成员变量和成员方法
3、被private修饰后的成员变量和成员方法，只能在本类中访问

使用格式：
private 数据类型 变量名;


封装性的体现：
1、属性私有化
2、不对外暴露的私有方法
3、单例模式

java提供了4种权限修饰符来修饰类以及类的内部结构，体现了类以及类的内部结构在被调用时的可见性大小


* */
public class Demo01 {
    private  String name;
    private  int ages;
    public void setName(String n){
        name = n;
    }

    public String getName() {
        return name;
    }

    public void setAges(int ages) {
        this.ages = ages;
    }

    public int getAges() {
        return ages;
    }
}
