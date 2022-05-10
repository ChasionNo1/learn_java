package 设计模式.单例模式.饿汉式;


import org.testng.annotations.Test;

/**
 * @ClassName SingletonTest01
 * @Description TODO
 * @Author chasion
 * @Date 2022/5/9 15:01
 *
 * 单例设计模式八种方式：
 * 1、饿汉式（静态常量）
 * 2、饿汉式（静态代码块）
 * 3、懒汉式（线程不安全）
 * 4、懒汉式（线程安全，同步方法）
 * 5、懒汉式（线程安全，同步代码块）
 * 6、双重检查
 * 7、静态内部类
 * 8、枚举
 *
 *
 * 一般情况下，不建议使用第 1 种和第 2 种懒汉方式，建议使用饿汉方式。
 * 只有在要明确实现 lazy loading 效果时，才会使用静态内部类方式。
 * 如果涉及到反序列化创建对象时，可以尝试使用枚举方式。如果有其他特殊的需求，可以考虑使用双检锁方式。
 */
public class SingletonTest01 {

    /*
    *
    * 1)优点:这种写法比较简单，就是在类装载的时候就完成实例化。避免了线程同步问题。
    *
    * 2)缺点:在类装载的时候就完成实例化，没有达到Lazy Loading 的效果。如果从始至终从未使用过这个实例，则会造成内存的浪费
    *
    * 3)这种方式基于classloder机制避免了多线程的同步问题，不过，instance在类装载时就实例化，在单例模式中大多数都是调用getInstance方法，
    * 但是导致类装载的原因有很多种，因此不能确定有其他的方式(或者其他的静态方法〉导致类装载，这时候初始化instance就没有达到lazy loading 的效果
    *
    * 4)结论:这种单例模式可用，可能造成内存浪费
    * */

    @Test
    public void test1(){
        Singleton instance = Singleton.getInstance();
        Singleton instance1 = Singleton.getInstance();
        System.out.println(instance == instance1);
        System.out.println(instance.hashCode());
        System.out.println(instance1.hashCode());
    }

}

// 饿汉式（静态变量）
class Singleton{

    // 1、私有化构造器，外部不能new
    private Singleton(){
    }

    // 2、本类内部创建对象实例
    private static Singleton instance = new Singleton();

    // 3、提供一个公有静态方法，返回实例对象
    public static Singleton getInstance(){
        return instance;
    }
}
