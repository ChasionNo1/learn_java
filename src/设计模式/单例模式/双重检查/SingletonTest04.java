package 设计模式.单例模式.双重检查;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

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

    // 使用反射破坏单例模式
    @Test
    public void test1() throws Exception {
//        Singleton instance = Singleton.getInstance();
        // 如果可以获取flag属性
        Field flag = Singleton.class.getDeclaredField("flag");
        Constructor<Singleton> declaredConstructor = Singleton.class.getDeclaredConstructor(null);
        declaredConstructor.setAccessible(true);
        // 两个都使用反射构造对象
        Singleton instance = declaredConstructor.newInstance();
        // 重新设置flag为false，仍然可以构造
        flag.setAccessible(true);
        flag.set(instance, false);
        Singleton instance1 = declaredConstructor.newInstance();
        // false
        System.out.println(instance == instance1);

    }
}

class Singleton{

    // 使用一个加密属性，防止反射多次创建对象
    private static boolean flag = false;
    private static volatile Singleton instance;

    private Singleton(){
        synchronized (Singleton.class){
            if (flag == false){
                flag = true;
            }else {
                throw new RuntimeException("不要试图使用反射破坏异常");
            }
//            if (instance != null){
//                throw new RuntimeException("不要试图使用反射破坏异常");
//            }
        }
    }

    // 双重检查
    public static Singleton getInstance(){
        if (instance == null){
            synchronized (Singleton.class){
                if (instance == null){
                    // 不是一个原子性操作
                    /**
                     * 1、分配内存空间
                     * 2、执行构造方法，初始化对象
                     * 3、把这个对象指向这个空间
                     *
                     * 由于指令重排，可能132，此时还没完成构造
                     * 使用volatile解决
                     * */
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
