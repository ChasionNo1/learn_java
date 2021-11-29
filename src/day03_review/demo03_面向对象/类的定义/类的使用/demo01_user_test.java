package day03_review.demo03_面向对象.类的定义.类的使用;
/*
 * 类中属性的使用
 * 属性（成员变量）    局部变量
 * 1、相同点：
 * 定义变量的格式
 * 先声明、后使用
 * 都有相应的作用域
 *
 * 2、不同点：
 * 在类中声明的位置不同
 * 属性：直接定义在类的一对{}内
 * 局部变量：声明在方法内、方法形参、代码块内、构造器形参、构造器内部的变量
 *
 * 关于权限修饰符的不同：
 * 属性：可以在声明属性时，指明其权限，使用权限修饰符
 * 常用的权限修饰符有：private\public\缺省\protected
 *
 * 默认初始化值的情况：
 * 属性：类的属性、根据其类型，都有默认的初始值
 * 局部变量：没有默认初始化值，意味着，在调用之前要显式赋值
 * 特别的，形参在调用时赋值
 *
 * 在内存中加载的位置：
 * 属性：加载到堆空间中（非静态）
 * 局部变量：加载到栈空间
 * */
public class demo01_user_test {
    // 属性（成员变量）
    String name;
    int age;
    boolean isMale;

    public void talk(String language){
        // language:形参
        System.out.println(language);
    }

}
