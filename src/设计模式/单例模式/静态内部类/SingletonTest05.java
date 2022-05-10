package 设计模式.单例模式.静态内部类;

import org.testng.annotations.Test;

/**
 * @ClassName SingletonTest05
 * @Description TODO
 * @Author chasion
 * @Date 2022/5/9 16:00
 */
public class SingletonTest05 {

    /**
     * 1)这种方式采用了类装载机制来保证初始化实例时只有一个线程
     * 2)静态内部类方式在Singleton类被装载时并不会立即实例化，而是在需要实例化时，调用getInstance方法，才
     * 会装载SingletonInstance类，从而完成Singleton 的实例化。
     * 3) 类的静态属性只会在第一次加载类的时候初始化，所以在这里，JVM帮助我们保证了线程的安全性，在类进行
     * 初始化时，别的线程是无法进入的。
     * 4)优点:避免了线程不安全，利用静态内部类特点实现延迟加载，效率高
     * 5)结论:推荐使用.
     * */

    @Test
    public void test1(){
        Singleton instance = Singleton.getInstance();
        Singleton instance1 = Singleton.getInstance();
        System.out.println(instance == instance1);
    }
}


class Singleton{

    // 静态内部类，该类中有一个静态属性
    private static class SingletonHolder{
        private static final Singleton INSTANCE = new Singleton();
    }

    private Singleton(){}

    public static Singleton getInstance(){
        return SingletonHolder.INSTANCE;
    }
}
