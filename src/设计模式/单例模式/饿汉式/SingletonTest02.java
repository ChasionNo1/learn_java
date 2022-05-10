package 设计模式.单例模式.饿汉式;

import org.testng.annotations.Test;

/**
 * @ClassName SingletonTest2
 * @Description TODO
 * @Author chasion
 * @Date 2022/5/9 15:21
 */
public class SingletonTest02 {

    @Test
    public void test1(){
        Singleton1 instance = Singleton1.getInstance();
        Singleton1 instance1 = Singleton1.getInstance();
        System.out.println(instance == instance1);
    }

    /*
    1)这种方式和上面的方式其实类似，只不过将类实例化的过程放在了静态代码块中，也是在类装载的时候，就执
    行静态代码块中的代码，初始化类的实例。优缺点和上面是一样的。

    2)结论:这种单例模式可用，但是可能造成内存浪费

    * */
}

// 饿汉式（静态代码块）
class Singleton1{

    // 1、私有化构造器，外部不能new
    private Singleton1(){}

    // 2、本类内部创建实例对象
    private static Singleton1 instance;

    static {
        instance = new Singleton1();
    }

    // 3、提供一个公有的静态方法，返回实例对象
    public static Singleton1 getInstance(){
        return instance;
    }
}
