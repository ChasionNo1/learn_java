package day03_review.demo03_面向对象.面向对象上.封装;


import javax.xml.crypto.Data;

/*
* 构造器的使用
*
* 1、构造器的作用：
*   创建对象
* 2、说明：
* 如果没有显示定义构造器，系统提供空参构造器
* 定义格式：
* 权限修饰符 类名(形参列表){}
*
* 修饰符 类名 (参数列表) {
初始化语句；
}
* 它具有与类相同的名称
* 它不声明返回值类型。（与声明为void不同）
* 不能被static、final、synchronized、abstract、native修饰，不能有
* return语句返回值
*
* 作用：
* 创建对象；给对象进行初始化
*
*根据参数不同，构造器可以分为如下两类：
* 隐式无参构造器（系统默认提供）
* 显式定义一个或多个构造器（无参、有参）
*
*
* 注意：
* Java语言中，每个类都至少有一个构造器
默认构造器的修饰符与所属类的修饰符一致
一旦显式定义了构造器，则系统不再提供默认构造器
一个类可以创建多个重载的构造器
父类的构造器不可被子类继承

*
* 构造器重载
* 构造器重载使得对象的创建更加灵活，方便创建各种不同的对象。
*
*
*
* 属性赋值的过程：
* 截止到目前，我们讲到了很多位置都可以对类的属性赋值。现总结这几个位
置，并指明赋值的先后顺序。
*
* 赋值的位置：
1、 默认初始化
2、显式初始化
3、构造器中初始化
4、通过“对象.属性“或“对象.方法”的方式赋值
*
* 赋值的先后顺序：
1-2-3-4
* */
public class demo05_constructor {
    public static void main(String[] args) {
        // 创建对象：new + 构造器
        Person person = new Person("cairen", 24);
        System.out.println(person.age);
        person.eat();
        person.study();
    }
}

class Person{
    String name;
    int age;
    private Data birthDate;

    // 构造器
    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }
    // 构造器重载
    public Person(String name, int age, Data birthDate){
        this.name = name;
        this.age = age;
        this.birthDate = birthDate;

    }
    public void eat(){
        System.out.println("eat");
    }
    public void study(){
        System.out.println("study");
    }
}
