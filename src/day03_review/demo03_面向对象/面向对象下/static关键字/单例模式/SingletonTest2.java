package day03_review.demo03_面向对象.面向对象下.static关键字.单例模式;


/*

懒汉式

区分懒汉式和饿汉式
饿汉式：
坏处：对象加载时间过长
好处：线程是安全的

饿汉式：
好处：延迟创建对象
目前写法的坏处：线程不安全，


应用场景：
 网站的计数器，一般也是单例模式实现，否则难以同步。
 应用程序的日志应用，一般都使用单例模式实现，这一般是由于共享的日志
文件一直处于打开状态，因为只能有一个实例去操作，否则内容不好追加。
 数据库连接池的设计一般也是采用单例模式，因为数据库连接是一种数据库
资源。
 项目中，读取配置文件的类，一般也只有一个对象。没有必要每次使用配置
文件数据，都生成一个对象去读取。
 Application 也是单例的典型应用
 Windows的Task Manager (任务管理器)就是很典型的单例模式
 Windows的Recycle Bin (回收站)也是典型的单例应用。在整个系统运行过程
中，回收站一直维护着仅有的一个实例。


* */
public class SingletonTest2 {
}

class Order{
    //  私有化类的构造器
    private Order(){
    }
    // 声明当前类对象，没有初始化
    private static Order instance = null;

    // 声明公共返回类对象的方法
    public Order getInstance() {
        // 只会new一次
        if (instance == null){
            instance = new Order();
        }
        return instance;
    }
}
