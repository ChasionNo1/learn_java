package 设计模式.单例模式.懒汉式;

import org.testng.annotations.Test;

/**
 * @ClassName SingletonTest03
 * @Description TODO
 * @Author chasion
 * @Date 2022/5/9 15:31
 */
public class SingletonTest03 {

    /*
    1)起到了Lazy Loading 的效果，但是只能在单线程下使用。
    2)如果在多线程下，一个线程进入了if (singleton ==-null)判断语句块，还未来得及往下执行，另一个线程也通过
    了这个判断语句，这时便会产生多个实例。所以在多线程环境下不可使用这种方式
    3)结论:在实际开发中，不要使用这种方式.

    使用synchronized关键字：
    1)解决了线程安全问题
    2)）效率太低了，每个线程在想获得类的实例时候，执行getInstance()方法都要进行同步。而其实这个方法只执行
    一次实例化代码就够了，后面的想获得该类实例，直接return就行了。方法进行同步效率太低
    3)结论:在实际开发中，不推荐使用这种方式


    * */

    @Test
    public void test1(){
        Singleton instance = Singleton.getInstance();
        Singleton instance1 = Singleton.getInstance();
        System.out.println(instance == instance1);
    }


}

class Singleton{

    private static Singleton instance;

    private Singleton() {
    }

    // 提供一个静态的公有方法，当使用到该方法时，采取创建实例对象
//    public static Singleton getInstance(){
//        if (instance == null){
//            instance = new Singleton();
//        }
//        return instance;
//    }

    // 同步方法处理：
//    public static synchronized Singleton getInstance(){
//        if (instance == null){
//            instance = new Singleton();
//        }
//        return instance;
//    }

    // 同步代码块：
    public static Singleton getInstance(){
        if (instance == null){
            synchronized (Singleton.class){
                instance = new Singleton();
            }
        }
        return instance;
    }
}
