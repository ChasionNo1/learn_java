package day03_review.demo03_面向对象.多态.虚拟方法调用;
/*
 正常的方法调用
Person e = new Person();
e.getInfo();
Student e = new Student();
e.getInfo();
 虚拟方法调用(多态情况下)
子类中定义了与父类同名同参数的方法，在多态情况下，将此时父类的方法称为虚拟方法，父
类根据赋给它的不同子类对象，动态调用属于子类的该方法。这样的方法调用在编译期是无法
确定的。
Person e = new Student();
e.getInfo(); //调用Student类的getInfo()方法
 编译时类型和运行时类型
编译时e为Person类型，而方法的调用是在运行时确定的，所以调用的是Student类
的getInfo()方法。——动态绑定
**/
public class demo01_VirtualMethodInvocation {
}
