package day03_review.demo03_面向对象.面向对象下.static关键字.单例模式;

/*
单例设计模式：
所谓类的单例设计模式，就是采取一定的方法保证在整个的软件系统中，对
某个类只能存在一个对象实例，并且该类只提供一个取得其对象实例的方法。
如果我们要让类在一个虚拟机中只能产生一个对象，我们首先必须将类的构
造器的访问权限设置为private，这样，就不能用new操作符在类的外部产生
类的对象了，但在类内部仍可以产生该类的对象。因为在类的外部开始还无
法得到类的对象，只能调用该类的某个静态方法以返回类内部创建的对象，
静态方法只能访问类中的静态成员变量，所以，指向类内部产生的该类对象
的变量也必须定义成静态的。

两种实现模式：
饿汉式
懒汉式
* */
public class SingletonTest1 {
    public static void main(String[] args) {
        Bank bank1 = Bank.getInstance();
        Bank bank2 = Bank.getInstance();
        System.out.println(bank1 == bank2);
    }
}

// 饿汉式
class Bank{
//    将类的构造器的访问权限设置为private
    private Bank(){
    }
    // 内部创建类的对象，必须声明为静态
    private static Bank instance = new Bank();
    // 提供公共的静态方法，返回类的对象
    public static Bank getInstance() {
        return instance;
    }
}
