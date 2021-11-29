package day03_review.demo03_面向对象.类的定义.类的使用;

/*
* 内存解析：
* 1、堆：存放对象实例
* 2、栈：存储局部变量，方法执行完，自动释放
* 3、方法区：存储已被虚拟机加载的类信息、常量、静态变量、即时编译后的代码等数据
*
* */
public class Demo02_Test_Class {
    public static void main(String[] args) {
        // 创建对象的格式：类名 对象名 = new 类名();
        Student student = new Student();
        student.name = "cc";
        student.age = 14;
        student.eat();
        student.study();
        // 如果创建了一个类的多个对象，则每个对象都独立的拥有一套类的属性，（非static的）
        // 意味着，如果我们修改一个对象的属性a值，不会影响另一个对象属性a的值。
        Student s2 = new Student();


    }
}
