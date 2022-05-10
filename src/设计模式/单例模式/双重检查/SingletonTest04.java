package 设计模式.单例模式.双重检查;

/**
 * @ClassName SingletonTest04
 * @Description TODO
 * @Author chasion
 * @Date 2022/5/9 15:46
 */
public class SingletonTest04 {

    /*
    4、双检锁/双重校验锁（DCL，即 double-checked locking）
    JDK 版本：JDK1.5 起

    是否 Lazy 初始化：是

    是否多线程安全：是

    实现难度：较复杂

    描述：这种方式采用双锁机制，安全且在多线程情况下能保持高性能。
    getInstance() 的性能对应用程序很关键。


    l)Double-Check 概念是多线程开发中常使用到的，如代码中所示，我们进行了两次if (singleton=null)检查，这
    样就可以保证线程安全了。
    2)这样，实例化代码只用执行一次，后面再次访问时，判断if (singleton == null)，直接return 实例化对象，也避
    免的反复进行方法同步.
    3)线程安全;延迟加载;效率较高
    4)结论:在实际开发中，推荐使用这种单例设计模式

    * */
}

class Singleton{

    private static volatile Singleton instance;

    private Singleton(){}

    // 双重检查
    public static Singleton getInstance(){
        if (instance == null){
            synchronized (Singleton.class){
                if (instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
